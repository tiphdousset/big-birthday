package anniversaire
import outwatch.dom._
import outwatch.dom.dsl._
import monix.execution.Scheduler.Implicits.global
import rx._
import util._

object Costume{
   //val map = div("Suis nous, c'est par ici!")
   def costume(token: String) = {
     //div("token = "+token)
     div("Guest and costume: "+GuestCostume.findNameAndCostumePerToken(token))
   }
 }


