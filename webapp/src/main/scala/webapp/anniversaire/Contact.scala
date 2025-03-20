package anniversaire
import outwatch._
import outwatch.dsl._
import colibri._
import colibri.reactive._

object Contact {
  def contact(name: String,
              email: String,
              phone: Seq[String],
              color: String) = {
    div(div(b(name)),
        div(email),
        div(phone),
        padding := "10px",
        border := s"4px solid $color",
        marginTop := "5px")
  }

  val pic = div(backgroundImage := "url(20ans.jpg)",
                backgroundSize := "cover",
                height := "300px",
                width := "84.5%",
                marginLeft := "auto",
                marginRight := "auto",
                marginTop := "30px")

  val tiph = div(
    contact("Tiph",
            environment.BuildInfo.email_tiph,
            Seq(s"${environment.BuildInfo.phone_tiph_fr} / ${environment.BuildInfo.phone_tiph_de}"),
            "gold"))
  val fanch = div(
    contact("Fanch", 
            environment.BuildInfo.email_fanch,
            Seq(environment.BuildInfo.phone_fanch),
            "pink"))
  val bene = div(
    contact("Béné",
            environment.BuildInfo.email_bene,
            Seq(environment.BuildInfo.phone_bene),
            "yellowGreen"))
  def contacts_description(language: Observable[Translation]) = div(
    language.map(_.menu_contact),
    textAlign := "center",
    fontSize := "18px",
    marginTop := "5px"
  )
  val contacts_details = div(
    tiph,
    fanch,
    bene,
    display := "flex",
    justifyContent := "space-between",
    marginTop := "10px",
    marginBottom := "10px",
    width := "84.5%",
    marginLeft := "auto",
    marginRight := "auto",
    fontSize := "10px"
  )

  def contacts(language: Observable[Translation]) =
    div(contacts_description(language), pic, contacts_details)
}
