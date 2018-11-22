package anniversaire
import outwatch.dom._
import outwatch.dom.dsl._
import monix.execution.Scheduler.Implicits.global
import rx._
import util._

object Contact{
  def contact(name: String, email: String, phone: Seq[String], color : String)={
    div(div(name), div(email), div(phone), padding := "10px", border := s"7px solid $color", marginTop := "5px")
  }


  val tiph = div(contact("Tiph", "tiphdousset@gmail.com", Seq("06.63.88.31.50", "0049 1573 0983456"), "gold"))
  val fanch = div(contact("Fanch","francois.sail@gmail.com", Seq("06.76.29.51.25"), "pink"))
  val bene = div(contact("Béné","benedicte.gourdon@gmail.com", Seq("07.81.18.84.63"), "yellowGreen"))
  val contacts = div(
    div(tiph, fanch, bene, display := "flex", justifyContent := "space-around"),
    img(src := "20ans.jpg")
  )
}

