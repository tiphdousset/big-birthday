package anniversaire
import outwatch.dom._
import outwatch.dom.dsl._
import monix.execution.Scheduler.Implicits.global
import rx._
import util._

object Infos{

  val info1 = div("Hello, on vous rapelle que vous faites parti des quelques personnes privilégiées qui ont été séléctionné pour participer au weekend de l'année 2019 à ne surtout pas louper", fontSize := "30px" )
}

