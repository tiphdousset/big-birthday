package anniversaire
import outwatch.dom._
import outwatch.dom.dsl._
import monix.execution.Scheduler.Implicits.global
import rx._
import util._

object Photos{
   val button_20ans = button()
   val photos20ans = div()
   val photos25ans = div()
   val photos30ans = div()
   val photos = div("...on ne va pas tout te devoiler en avance, reviens ici apres la fete!")
}


