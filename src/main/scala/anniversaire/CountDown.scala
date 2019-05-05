package anniversaire
import outwatch.dom._
import outwatch.dom.dsl._
import monix.execution.Scheduler.Implicits.global
import rx._
import util._
import java.util.Date

object CountDown {

  def countDown = {
    val eventDate = new Date(2019 - 1900, 5, 8) // 0 is January so 5 is June
    val today = new Date()
    (((eventDate.getTime() - today.getTime()) / 1000) / (24 * 60 * 60)).toInt
  }
}
