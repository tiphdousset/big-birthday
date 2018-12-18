package anniversaire
import cats.effect.IO
import com.raquo.domtypes.generic.keys.Style
import org.scalajs.dom
import org.scalajs.dom.{Element, document}
import outwatch.dom.helpers.{AttributeBuilder, CustomEmitterBuilder, EmitterBuilder}
import outwatch.dom._
import outwatch._
import rx._
import scala.collection.breakOut
import monix.execution.Scheduler.Implicits.global
import monix.reactive._
import monix.execution._
package object util {


implicit object RxAsValueObservable extends AsValueObservable[Rx] {
  override def as[T](stream: Rx[T]): ValueObservable[T] = new ValueObservable[T]{
    def value = Option(stream.now)
    def observable = Observable.create[T](OverflowStrategy.Unbounded) { observer =>
      implicit val ctx = Ctx.Owner.Unsafe
      val obs = stream.triggerLater(observer.onNext(_))
      Cancelable(() => obs.kill())
    }
  }
}

implicit object VarAsObserver extends AsObserver[Var] {
  override def as[T](stream: Var[_ >: T]): Observer[T] = new Observer.Sync[T] {
    override def onNext(elem: T): Ack = {
      stream() = elem
      Ack.Continue
    }
    override def onError(ex: Throwable): Unit = throw ex
    override def onComplete(): Unit = ()
  }
}

// if you want to use managed()
implicit def obsToCancelable(obs: Obs): Cancelable = {
  Cancelable(() => obs.kill())
}}
