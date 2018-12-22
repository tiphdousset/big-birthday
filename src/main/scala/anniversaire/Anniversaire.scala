package anniversaire

import outwatch.dom._
import outwatch.dom.dsl._
import monix.execution.Scheduler.Implicits.global
import rx._
import util._
import org.scalajs.dom.ext.KeyCode



object Anniversaire {
  implicit val ctx: Ctx.Owner = Ctx.Owner.safe()

  def main(args: Array[String]): Unit = {

    val page = Var("")
    val tokenValue = Var("")

    def light_div(lightId:String, description:String) = { 
      import svg._
      div(
        cls := "lightsCls",
        id := lightId,
        position := "absolute",
        div(
          svg( 
            width:="30px", height:="40px", 
            rect(y:="5", x:="10", height:="10", width:="10"), 
            circle(r:="10",cy:="25",cx:="15")
          )
        ),
      div(cls := "descriptionCls", description)
    )
    }

    val intro_button = button(id := "intro_button",
      "They are back.",
      /*onClick.foreach{page() = "start"}*/
     onClick("start") --> page,
     cursor := "pointer"
     )
    val intro_div = div(
      backgroundImage := "url(intro.jpg)",
      backgroundSize := "cover", 
      height := "100%",
      intro_button,
      onClick("start") --> page,
      cursor := "pointer"

    )

    val countDown = div(s"J - ${CountDown.countDown}", fontSize := "40px", textAlign := "left", marginLeft :="10px")

    val title = h1(id := "title",
      countDown,
      "La Tentaine",
      fontFamily := "Great Vibes",
      textAlign := "center",
      textShadow := "0 1px 1px #fff",
      fontSize := "160px",
      marginBottom := "0"

      )

    //val contentHandler = Var[VNode](div("empty"))
    val contentHandler = Var[VNode](Contact.contacts)

    val main_container = div(borderStyle := "dotted",
      marginLeft := "50px",
      marginRight := "50px",
      marginTop := "60px",
      minHeight := "500px",
      backgroundColor := "#ffffff85",
      contentHandler
      )

    val lights_div = div(
      marginLeft:= "auto", //auto for marginLeft&Right to have the div centered
      marginRight:= "auto",
      width:= "900px", //default width for div is 100%
      /*backgroundImage := "url(lights.svg)",*/
     backgroundImage := "url(lichtketteF.svg)",
     backgroundSize := "contain", 
     backgroundRepeat := "no-repeat",
     height := "150px",
     position:="relative",
     light_div("costume", "découvre ton personnage")(onClick.map(_ =>Costume.costume(tokenValue.now)) --> contentHandler),
     light_div("photo", "le coin photos")(onClick(Photos.photos) --> contentHandler),
     light_div("contact", "contacts")(onClick(Contact.contacts) --> contentHandler),
     light_div("info","Quoi?Où?Comment?")(onClick(Infos.info1) --> contentHandler),

     )

    def onClickToken(showTokenBox: Var[Boolean], tokenBorder: Var[String]) = {
      if (GuestCostume.isTokenValid(tokenValue.now)){
        showTokenBox() = false
      }
      else {
        tokenBorder() = "4px solid red"
      }
    }

    val home_div = {
      val showTokenBox = Var(false)
      val tokenBorder = Var("none")
      div(
        title,
        backgroundImage := "url(tente.jpg)",
        backgroundSize := "cover", 
        backgroundAttachment := "fixed",
        overflow := "auto",
        height := "100%",
        lights_div,
        main_container,
        Rx{
          if (showTokenBox()){
            div(
              height := "100%",
              backgroundColor := "rgba(0,0,0,0.8)",
              position := "absolute",
              top := "0",
              left := "0",
              width := "100%",
              display.flex,
              justifyContent.center,
              alignItems.center,
              input(
                tpe := "text",
                placeholder := "Please enter your token",
                fontSize := "100px",
                cls := "innerShadow",
                border <-- tokenBorder,
                //fontFamily := "monospace"
                onInput.value.foreach{str =>
                  tokenValue() = str
                  tokenBorder() = "none"
                },
                onKeyDown.filter(_.keyCode == KeyCode.Enter).foreach{onClickToken(showTokenBox, tokenBorder)}
                ),
              button("OK",
                onClick.foreach{onClickToken(showTokenBox, tokenBorder) },
                fontSize := "100px",
                marginLeft := "20px"
                ),
              )
          }
          else VDomModifier.empty
        }
        )
    }



    val main = div(
      height := "100%",

      Rx{
        if (page() == "start"){
          home_div
        }
        else intro_div
        home_div //temporary for test purpose
      }
      )


    OutWatch.renderReplace("#app", main).unsafeRunSync()

  }
}
