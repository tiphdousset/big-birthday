package anniversaire
import outwatch.dom._
import outwatch.dom.dsl._
import monix.execution.Scheduler.Implicits.global
import rx._
import util._
import monix.reactive._

object Costume{
   val costume_under_construction = div(iframe( src := "https://giphy.com/embed/Fn1XLXZORb7H2" ,
                            attr("width") := "240",
                            attr("height") := "180",
                            attr("frame-border") := "0",
                            cls := "giphy-embed",
                            borderWidth := "0",
                            margin := "0 auto",
                            display := "block",
                            marginTop := "25px",
                          )
                   )
   def costume(token: String, language : Observable[Translation])(implicit ctx:Ctx.Owner) = {
     //div("token = "+token)
     //div("Guest and costume: "+GuestCostume.findNameAndCostumePerToken(token))
     //div(display.flex, justifyContent.center, alignItems.center,fontSize := "50px", "UNDER", costume_under_construction, "CONSTRUCTION")
     val showWheel = Var(false)

     val button_wheel = button(
       language.map(_.menu_costume_button_wheel),
       fontWeight.bold,
       fontSize := "15px",
       marginTop := "50px",
       marginLeft := "auto",
       marginRight := "auto",
       display := "block",
       onClick(true) --> showWheel
     )

     div(
       language.map(_.menu_costume),
       Rx {
         if (showWheel())
           wheelOfFortune
         else
           button_wheel
       },
       fontSize := "16px", whiteSpace := "pre-line")
   }


   val wheelOfFortune = div(iframe( src := "https://giphy.com/embed/2SX8z3bnvJe3C" ,
     attr("width") := "480",
     attr("height") := "360",
     attr("frame-border") := "0",
     cls := "giphy-embed",
     borderWidth := "0",
     // margin := "0 auto",
     display := "block",
     // marginTop := "50px",
     marginLeft := "auto",
     marginRight := "auto"
     ) )


   // val photos = div(display.flex, justifyContent.center, alignItems.center,fontSize := "50px", "UNDER", photos_under_construction, "CONSTRUCTION", height := "500px")
   // <iframe src="https://giphy.com/embed/2SX8z3bnvJe3C" width="480" height="217" frameBorder="0" class="giphy-embed" allowFullScreen></iframe><p><a href="https://giphy.com/gifs/episode-wheel-fortune-2SX8z3bnvJe3C">via GIPHY</a></p>

}


