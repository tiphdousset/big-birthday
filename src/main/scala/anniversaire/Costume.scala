package anniversaire
import outwatch.dom._
import outwatch.dom.dsl._
import rx._
import util._
import monix.reactive._
import TokenLogic._

object Costume {

  def costume(token: String, language: Observable[Translation])(
      implicit ctx: Ctx.Owner) = {
//     val showWheel = Var(false)
    val showCostume = Var(false)

    val button_wheel = button(
      language.map(_.menu_costume_button_wheel),
      fontWeight.bold,
      fontSize := "15px",
      marginTop := "50px",
      marginLeft := "auto",
      marginRight := "auto",
      backgroundColor:="#fd22c4",
      color:="white",
      display := "block",
//       onClick(true) --> showWheel ,
      onClick(true) --> showCostume
    )

    div(
      language.map(_.menu_costume),
      Rx {
//         if (showWheel())
//           wheelOfFortune
        if (showCostume())
          displayCostume(token, language)
        else
          button_wheel
      },
      fontSize := "16px",
      whiteSpace := "pre-line"
    )
  }

  def displayCostume(token: String, language: Observable[Translation])(
      implicit ctx: Ctx.Owner) = {
    val guestName = TokenLogic.findNameAndCostumePerToken(token).toList(0)._1
    println("guestName = "+guestName)
    val costume = TokenLogic.findNameAndCostumePerToken(token).toList(0)._2
    println("costume = "+costume)
    val costumePartner = TokenLogic.findCostumePartner(costume)
    println("costumePartner = "+ costumePartner)
    div(language.map(_.display_costume(guestName, costume, costumePartner)), marginTop:="20px", display.flex, flexDirection:="column", alignItems:="center")
  }

//   val wheelOfFortune = div(iframe( src := "https://giphy.com/embed/2SX8z3bnvJe3C" ,
//     attr("width") := "480",
//     attr("height") := "360",
//     attr("frame-border") := "0",
//     cls := "giphy-embed",
//     borderWidth := "0",
//     display := "block",
//     marginLeft := "auto",
//     marginRight := "auto"
//     ) )

}
