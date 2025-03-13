package anniversaire
import outwatch._
import outwatch.dsl._
import colibri._
import colibri.reactive._
object Costume {

  def costume(token: String, language: Observable[Translation]) = {

    val showCostume = Var(1)

    val button_costume = button(
      language.map(_.menu_costume_button_wheel),
      fontWeight.bold,
      fontSize := "15px",
      marginTop := "50px",
      marginLeft := "auto",
      marginRight := "auto",
      backgroundColor := "#fd22c4",
      color := "white",
      display := "block",
      if (token == "jenesuispaslasamedi" || token == "") {
        onClick(4) --> showCostume
      } else { onClick(2) --> showCostume }
    )

    div(
      language.map(_.menu_costume),
      Rx {
        if (showCostume() == 2)
          magicGif(showCostume)
        else if (showCostume() == 3)
          displayCostume(token, language)
        else if (showCostume() == 4)
          loserGif(showCostume)
        else if (showCostume() == 5)
          displayLoser(language)
        else
          button_costume
      },
      fontSize := "16px",
      whiteSpace := "pre-line",
    )
  }

  def displayLoser(language: Observable[Translation]): VNode =
    div(language.map(_.display_no_costume),
        marginTop := "20px",
        display.flex,
        flexDirection := "column",
        alignItems := "center")

  def displayCostume(token: String, language: Observable[Translation]) = {
    val guestName = TokenLogic.findNameAndCostumePerToken(token).toList(0)._1
    println("guestName = " + guestName)
    val costume = TokenLogic.findNameAndCostumePerToken(token).toList(0)._2
    println("costume = " + costume)
    val costumePartner = TokenLogic.findCostumePartner(costume)
    println("costumePartner = " + costumePartner)
    div(language.map(_.display_costume(guestName, costume, costumePartner)),
        marginTop := "20px",
        display.flex,
        flexDirection := "column",
        alignItems := "center")
  }
  def magicGif(showCostume: Var[Int]) =
    div(
      display := "flex",
      video(
        margin := "20px auto",
        source(src := "https://media.giphy.com/media/6CovzgyTig7M4/giphy.mp4",
               tpe := "video/mp4"),
        attr("autoplay") := true,
        onDomMount.asHtml.foreach { x =>
          x.onended = { _ =>
            showCostume.set(3)
          }
        }
      )
    )
  def loserGif(showCostume: Var[Int]) =
    div(
      display := "flex",
      video(
        margin := "20px auto",
        source(
          src := "https://media.giphy.com/media/YOkrK8agZLEk2cXeLi/giphy.mp4",
          tpe := "video/mp4"),
        attr("autoplay") := true,
        onDomMount.asHtml.foreach { x =>
          x.onended = { _ =>
            showCostume.set(5)
          }
        }
      )
    )
}
