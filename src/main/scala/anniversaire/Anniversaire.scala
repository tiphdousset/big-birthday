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

    def light_div(lightId:String, description:String) = { 
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
      div(cls := "descriptionCls", description)
    )
    }

    val intro_button = button(id := "intro_button", "They are back.",
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

    val fr = div(
      backgroundImage := "url(FR_croissant.png)",
      backgroundSize := "contain", 
      width := "20px",
      marginRight := "5px",
      onClick(Translation_FR) --> language
    )
    val en = div(
      backgroundImage := "url(EN_shakespeare.svg)",
      backgroundSize := "contain", 
      width := "20px",
      marginRight := "5px",
      onClick(Translation_EN) --> language
    )
    val de = div(
      backgroundImage := "url(DE_beer.svg)",
      backgroundSize := "contain", 
      width := "20px",
      onClick(Translation_DE) --> language
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

    val counter = Observable.interval(1 second)
    var isClicked = true
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

     light_div("info","Informations")(
      onClick(Some(Infos.info1)) --> contentHandler,
      counter.map(x => if (x%5==0 && isClicked) cls := "activate" else VDomModifier.empty)
     ),

     light_div("costume", "Get dressed")(
       onClick.mapTo(Some(Costume.costume(tokenValue.now))) --> contentHandler,
       counter.map(x => if (x%5==1 && isClicked) cls := "activate" else VDomModifier.empty)
      ),

     light_div("fun","DO NOT CLICK HERE")(
       onClick(Some("fun")) --> page,
       counter.map(x => if (x%5==2 && isClicked) cls := "activate" else VDomModifier.empty)
     ),

     light_div("photo", "Photos")(
       onClick(Some(Photos.photos)) --> contentHandler,
       counter.map(x => if (x%5==3 && isClicked) cls := "activate" else VDomModifier.empty)
     ),

     light_div("contact", "Contacts")(
       onClick(Some(Contact.contacts)) --> contentHandler,
       counter.map(x => if (x%5==4 && isClicked) cls := "activate" else VDomModifier.empty)
     ),


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
          Fun.fun(page)
        }
        else intro_div
        //home_div //temporary for test purpose
      }
      )

    // val main = div(
    //   div("Tiph", ), 
    //   counter.map(_%5==1), 
    //   counter.map(_%5==2), 
    //   counter.map(_%5==3), 
    //   counter.map(_%5==4), 
    //   )

     OutWatch.renderReplace("#app", main).unsafeRunSync()

  }
}
