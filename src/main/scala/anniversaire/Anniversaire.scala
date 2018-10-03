package anniversaire

import outwatch.dom._
import outwatch.dom.dsl._
import monix.execution.Scheduler.Implicits.global
import rx._
import util._

object Anniversaire {
  implicit val ctx: Ctx.Owner = Ctx.Owner.safe()

  def main(args: Array[String]): Unit = {

    val page = Var("")

    def light_div(lightId:String) = {
                    import svg._
                    svg(id:=lightId, width:="30px", height:="40px", rect(y:="5", x:="10", height:="10", width:="10"), circle(r:="10",cy:="25",cx:="15"),
                    position:= "absolute")
    }

    val intro_button = button(id := "intro_button",
                              "They are back.",
                              /*onClick --> sideEffect{page() = "start"}*/
                              onClick("start") --> page
                             )
    val intro_div = div(
                    backgroundImage := "url(intro.jpg)",
                    backgroundSize := "cover", 
                    height := "100%",
                    intro_button,
                    )

    val countDown = div(s"J - ${CountDown.countDown}", fontSize := "80px", textAlign := "left")

    val title = h1(id := "title",
                  countDown,
                  "La Tentaine",
                  fontFamily := "Great Vibes",
                  textAlign := "center",
                  textShadow := "0 1px 1px #fff",
                  fontSize := "160px",
                  marginBottom := "0"

                  )

    val contentHandler = Var[VNode](div("empty"))

    val main_container = div(borderStyle := "dotted",
                             marginLeft := "50px",
                             marginRight := "50px",
                             height := "500px",
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
                    light_div("map")(onClick(div("map")) --> contentHandler),
                    light_div("photo")(onClick(div("photo")) --> contentHandler),
                    light_div("contact")(onClick(Contact.contacts) --> contentHandler),
                    )

    val home_div = div(
                    title,
                    backgroundImage := "url(tente.jpg)",
                    backgroundSize := "cover", 
                    height := "100%",
                    lights_div,
                    main_container
                    )


    val main = div(
                  height := "100%",

              Rx{
                if (page() == "start"){
                  home_div
                }
                else intro_div
                home_div //to be deleted
              }
       )


    OutWatch.renderReplace("#app", main).unsafeRunSync()

  }
}
