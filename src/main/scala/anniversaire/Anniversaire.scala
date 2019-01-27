package anniversaire

import monix.reactive._
import concurrent.duration._
import outwatch.dom._
import outwatch.dom.dsl._
import monix.execution.Scheduler.Implicits.global
import rx._
import util._
import org.scalajs.dom.ext.KeyCode



object Anniversaire {
  implicit val ctx: Ctx.Owner = Ctx.Owner.safe()

  def main(args: Array[String]): Unit = {

    val page = Var(Option.empty[String])
    val tokenValue = Var("")
    val language = Var[Translation](Translation_FR)
    val counter = Observable.interval(1 second)
    var isClicked = true

    def light_div(lightId:String, description:String, onClick_function:VDomModifier, number:Int) = { 
      import svg._
      div(
        cls := "lightsCls",
        id := lightId,
        position := "absolute",
        div(
          svg(
            cls := "svgCls",
            width:="25px", height:="25px", 
            viewBox := "0 0 30 40", 
            rect(y:="5", x:="10", height:="10", width:="10"), 
            circle(r:="10",cy:="25",cx:="15"),
          )
        ),
      div(cls := "descriptionCls", description),
      onClick_function,
      counter.map(x => if (x%5==number && isClicked) cls := "activate" else VDomModifier.empty)
    )
    }

    val intro_button = button(id := "intro_button",
      Rx{
        language().intro_button
      },
     onClick(Some("start")) --> page,
     cursor := "pointer"
     )

    val intro_div = div(
      backgroundImage := "url(intro.jpg)",
      backgroundSize := "cover", 
      backgroundPosition := "center 0",
      height := "100%",
      intro_button,
      onClick(Some("start")) --> page, //we want to be able to click everywhere on the page and not only on the button
      cursor := "pointer"
    )

    def createTranslationIcon(image : String, language_class : Translation) = {   
      div(
      backgroundImage := s"url($image)",
      backgroundSize := "contain", 
      width := "20px",
      marginRight := "5px",
      onClick(language_class) --> language,
      backgroundRepeat := "no-repeat"
    )
    }

    val fr = createTranslationIcon("FR_tour_eiffel.svg", Translation_FR)
    
    val en = div(
      backgroundImage := "url(EN_bigben.svg)",
      //backgroundImage := "url(EN_shakespear.svg)",
      backgroundSize := "contain", 
      width := "20px",
      marginRight := "5px",
      onClick(Translation_EN) --> language,
      backgroundRepeat := "no-repeat",
    )

    val de = div(
      backgroundImage := "url(DE_bretzel.svg)",
      //backgroundImage := "url(DE_beer.svg)",
      backgroundSize := "contain", 
      width := "20px",
      onClick(Translation_DE) --> language,
      backgroundRepeat := "no-repeat",
    )

    val languages = div(
      display.flex,
      width := "100px",
      height := "20px",
      id := "languages",
      fr,
      en,
      de,
      marginLeft := "auto"
    )

    val header = div(
      id := "header",
      display.flex,
      Rx{
        language().count_down(CountDown.countDown)
      },
      languages,
      fontSize := "20px",
      textAlign := "left",
      marginLeft :="10px",
    )

    //val contentHandler = Var[VNode](div("empty"))
    val contentHandler = Var[Option[VNode]](None)


    val title = h1(id := "title",
      header,
      Rx{
        language().title
      },
      textAlign := "center",
      textShadow := "0 1px 1px #fff",
      fontSize := "80px",
      marginBottom := "0",
      onClick(None) --> contentHandler,
      cursor := "pointer"

      )

     val main_container = div(
      id := "mainContainer", 
      contentHandler
      )

    val lights_div = div(
      id := "lightsDiv",
      marginLeft:= "auto", //auto for marginLeft&Right to have the div centered
      marginRight:= "auto",
      width:= "450px", //default width for div is 100%
      /*backgroundImage := "url(lights.svg)",*/
     backgroundImage := "url(lichtketteF.svg)",
     backgroundSize := "contain", 
     backgroundRepeat := "no-repeat",
     height := "75px",
     position:="relative",

     Rx{
       light_div(
         "info",
         language().title_menu_info,
         onClick(Some(Infos.info(language))) --> contentHandler,
         0
       )
     },


     Rx{
       light_div(
         "costume",
         language().title_menu_costume,
         onClick.mapTo(Some(Costume.costume(tokenValue.now, language))) --> contentHandler,
         1
       )
     },

     Rx{
       light_div(
         "fun",
         language().title_menu_fun,
         onClick(Some("fun")) --> page,
         2
       )
     },

     Rx{
       light_div(
         "photo", 
         language().title_menu_photo,
         onClick(Some(Photos.photos)) --> contentHandler,
         3
       )
     },

     Rx{
       light_div(
         "contact",
          language().title_menu_contact,
         onClick(Some(Contact.contacts(language))) --> contentHandler,
         4
       )
     },


    onClick.foreach{isClicked = false}
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
        backgroundPosition := "center 0",
        backgroundAttachment := "fixed",
        overflow := "auto",
        height := "100%",
        lights_div,

        Rx{
        if (contentHandler().isDefined)
          main_container
        else
          VDomModifier.empty
        },

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
        if (page() == Some("start")){
          home_div
        }
        else if (page() == Some("fun")){
          Fun.fun(page, language)
        }
        else intro_div
        //home_div //temporary for test purpose
      }
      )

     OutWatch.renderReplace("#app", main).unsafeRunSync()

  }
}
