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
    val intro_button = button(id := "intro_button",
                              "They are back",
                              onClick --> sideEffect{page() = "start"}
                             )
    val intro = div(
                    backgroundImage := "url(intro.jpg)",
                    backgroundSize := "cover", 
                    height := "100%",
                    intro_button,
                    )

    val main = div(
                  height := "100%",

              Rx{
                if (page() == "start"){
                  div("start page")
                }
                else intro
              }
       )


    OutWatch.renderReplace("#app", main).unsafeRunSync()

  }
}
