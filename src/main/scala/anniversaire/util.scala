package anniversaire
import cats.effect.IO
import com.raquo.domtypes.generic.keys.Style
import monix.execution.ExecutionModel.{AlwaysAsyncExecution, SynchronousExecution}
import monix.execution.{Ack, Cancelable, Scheduler}
import monix.reactive.Observable
import monix.reactive.{Observable, Observer}
import monix.reactive.OverflowStrategy.Unbounded
import org.scalajs.dom
import org.scalajs.dom.{Element, document}
import outwatch.dom.helpers.{AttributeBuilder, CustomEmitterBuilder, EmitterBuilder}
import outwatch.dom.{Attribute, Handler, Modifier, ModifierStreamReceiver, OutWatch, VDomModifier, VNode, dsl}
import outwatch.{AsVDomModifier, ObserverSink, Sink}
import rx._
import scala.collection.breakOut
import monix.execution.Scheduler.Implicits.global
package object util {

implicit class RichRx[T](val rx: Rx[T]) extends AnyVal {
    def toLaterObservable(implicit ctx: Ctx.Owner): Observable[T] = Observable.create[T](Unbounded) {
      observer =>
        val obs = rx.triggerLater(observer.onNext(_))
        Cancelable(() => obs.kill())
    }

    def toObservable(implicit ctx: Ctx.Owner): Observable[T] = Observable.create[T](Unbounded) {
      observer =>
        val obs = rx.foreach(observer.onNext)
        Cancelable(() => obs.kill())
    }

    def debug(implicit ctx: Ctx.Owner): Obs = { debug() }
    def debug(name: String = "")(implicit ctx: Ctx.Owner): Obs = {
      rx.foreach(x => println(s"$name: $x"))
    }
    def debug(print: T => String)(implicit ctx: Ctx.Owner): Obs = {
      rx.foreach(x => println(print(x)))
    }
  }

  implicit def obsToCancelable(obs: Obs): Cancelable = {
    Cancelable(() => obs.kill())
  }
  implicit def observerAsSink[T](observer: Observer[T]): Sink[T] =
    ObserverSink(observer)

  implicit def rxAsVDomModifier[T: AsVDomModifier](implicit ctx: Ctx.Owner): AsVDomModifier[Rx[T]] =
    (value: Rx[T]) => VDomModifier.stream(value.toLaterObservable.map(VDomModifier(_)), VDomModifier(value.now))

  implicit class RichEmitterBuilder[E, O, R](val eb: EmitterBuilder[E, O, R]) extends AnyVal {
    //TODO: scala.rx have a contravariant trait for writing-only
    def -->(rxVar: Var[_ >: O])(implicit ctx: Ctx.Owner): IO[R] = eb --> rxVar.toSink
  }
  implicit class RichAttributeEmitterBuilder[-T, +A <: Attribute](val ab: AttributeBuilder[T, A])
      extends AnyVal {
    def <--(valueStream: Rx[T])(implicit ctx: Ctx.Owner) = ab <-- (valueStream.toLaterObservable, valueStream.now)
  }
  implicit class RichStyle[T](val ab: Style[T]) extends AnyVal {
    import outwatch.dom.StyleIsBuilder
    //TODO: make outwatch AttributeStreamReceiver public to allow these kinds of builder conversions?
    def <--(valueStream: Rx[T])(implicit ctx: Ctx.Owner) =
      StyleIsBuilder[T](ab) <-- (valueStream.toLaterObservable, valueStream.now)
  }

  implicit class RichVar[T](val rxVar: Var[T]) extends AnyVal {
    def unsafeToHandler(implicit ctx: Ctx.Owner): Handler[T] = {

      val h = Handler.create[T](rxVar.now).unsafeRunSync()
      h.filter(_ != rxVar.now).subscribe(new VarObserver(rxVar))
      rxVar.foreach(h.unsafeOnNext)
      h
    }

    def toSink(implicit ctx: Ctx.Owner): Sink[T] = {

      Sink
        .create[T] { event =>
          rxVar.update(event)
          Ack.Continue
        }
        .unsafeRunSync()
    }
  }

  class VarObserver[T](rx: Var[T]) extends Observer.Sync[T] {
    override def onNext(elem: T): Ack = {
      rx() = elem
      Ack.Continue
    }
    override def onError(ex: Throwable): Unit = throw ex
    override def onComplete(): Unit = ()
  }
}
