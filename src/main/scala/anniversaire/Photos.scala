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
   val photos_under_construction = div(iframe( src := "https://giphy.com/embed/fVeAI9dyD5ssIFyOyM" ,
                            attr("width") := "480",
                            attr("height") := "360",
                            attr("frame-border") := "0",
                            cls := "giphy-embed",
                            borderWidth := "0",
                            margin := "0 auto",
                            display := "block",
                            marginTop := "50px",
                          ) )

    val photos = div(display.flex, justifyContent.center, alignItems.center,fontSize := "50px", "UNDER", photos_under_construction, "CONSTRUCTION")
}



