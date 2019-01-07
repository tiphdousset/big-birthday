package anniversaire
import outwatch.dom._
import outwatch.dom.dsl._
import monix.execution.Scheduler.Implicits.global
import rx._
import util._

object Costume{
   val costume_under_construction = div(iframe( src := "https://giphy.com/embed/Fn1XLXZORb7H2" ,
                            attr("width") := "480",
                            attr("height") := "360",
                            attr("frame-border") := "0",
                            cls := "giphy-embed",
                            borderWidth := "0",
                            margin := "0 auto",
                            display := "block",
                            marginTop := "50px",
                          )
                   )
   def costume(token: String)(implicit ctx:Ctx.Owner) = {
     //div("token = "+token)
     //div("Guest and costume: "+GuestCostume.findNameAndCostumePerToken(token))
     //div(display.flex, justifyContent.center, alignItems.center,fontSize := "50px", "UNDER", costume_under_construction, "CONSTRUCTION")
     val showWheel = Var(false)

     val button_wheel = button("Qui suis-je?", fontWeight.bold,fontSize := "30px", marginTop := "100px", marginLeft := "auto",
       marginRight := "auto", display := "block",  onClick(true) --> showWheel)

     div("""Pas grand chose à préparer pour nous rejoindre si ce n'est...ta tenue !
       La grande roue ci-après te dévoilera dans quelques mois un déguisement à revêtir le """,b("Samedi"),""".

       Ton personnage appartient à un duo et tu devras lors de cette première soirée retrouver ton binôme parmi les invités.

       Pas de stress cependant pour les allergiques aux déguisements : tu peux te contenter d'arborer l'un des accessoires fétiches du personnage en question ou au contraire le jouer à fond, l'important c'est de retrouver ta moitié. """, b("#love"),""" 

       Pour savoir ce que le hasard te réserve, reviens donc checker cette page au printemps!
       """,
       Rx {
         if (showWheel())
           wheelOfFortune
         else
           button_wheel
       },
       fontSize := "20px", whiteSpace := "pre-line")
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


