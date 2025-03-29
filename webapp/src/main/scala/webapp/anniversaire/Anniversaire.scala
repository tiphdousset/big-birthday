package anniversaire

import anniversaire.resources.{Costumes, Guests, GuestsAndCostumes}

import concurrent.duration._
import outwatch._
import outwatch.dsl._
import org.scalajs.dom.ext.KeyCode
import colibri.reactive._
import colibri._
import cats.effect.IO
import cats.effect.IOApp
import cats.effect.SyncIO

object Anniversaire {

  def main(args: Array[String]): Unit = {

    // val intersection: Set[String] =
    //   GuestsAndCostumes.guestsEmails intersect Guests.emails
    // val union: Set[String] = GuestsAndCostumes.guestsEmails union Guests.emails
    // TODO: re-activate the asserts
    // assert(
    //   GuestsAndCostumes.guestsEmails == Guests.emails,
    //   "!!!!!!! Ooops, it looks like one guest does not have a costume !!!!!!!"
    // )
    // assert(
    //   GuestsAndCostumes.guestCostumes == Costumes.names,
    //   "!!!!!!! Ooops, errors in costumes!!!!!!!!!!"
    // )

    val page = Var(Option(""))
//    val tokenValue = Var("queen-bene-francois-fun-king")
    val tokenValue = Var("")
    val language = Var[Translation](Translation_FR)
    val counter = Observable.interval(1.second)
    var isClicked = true
    val encrypted_whatsapp_link =
      "U2FsdGVkX19rOSMwADaiAGtcDH0YRqp9eiZEobHmrnW8PRBnQHrxNGdCvQBWVNCq0dG33aGfzP01C2v8R03MQOrfPnQlBgLkj2Fknge3mjg="
    val decryptedLink = Var(None: Option[String])

    def light_div(
        lightId: String,
        description: String,
        onClick_function: VDomModifier,
        number: Int
    ) = {
      import svg._
      div(
        cls := "lightsCls",
        id := lightId,
        position := "absolute",
        div(
          svg(
            cls := "svgCls",
            width := "25px",
            height := "25px",
            viewBox := "0 0 30 40",
            rect(y := "5", x := "10", height := "10", width := "10"),
            circle(r := "10", cy := "25", cx := "15")
          )
        ),
        div(cls := "descriptionCls", description),
        onClick_function,
        counter.map(x =>
          if (x % 5 == number && isClicked) cls := "activate"
          else VDomModifier.empty
        )
      )
    }

    val intro_button = button(
      id := "intro_button",
      language.map(_.intro_button),
      onClick.as(Some("start")) --> page,
      cursor := "pointer"
    )

    val intro_div = div(
      backgroundImage := "url(intro.jpg)",
      backgroundSize := "cover",
      backgroundPosition := "center 0",
      height := "100%",
      intro_button,
      onClick.as(
        Some("start")
      ) --> page, // we want to be able to click everywhere on the page and not only on the button
      cursor := "pointer"
    )

    def createTranslationIcon(
        language_hover: String,
        image: String,
        language_class: Translation
    ) = {
      div(
        cls := "language",
        backgroundImage := s"url($image)",
        backgroundSize := "contain",
        width := "20px",
        flexShrink := 0,
        marginRight := "10px",
        onClick(language_class) --> language,
        backgroundRepeat := "no-repeat",
        div(
          cls := "language_description",
          language_hover,
          marginTop := "30px",
          fontSize := "15px"
        )
      )
    }

    val fr = createTranslationIcon("fr", "FR.svg", Translation_FR)
    val en = createTranslationIcon("en", "EN.svg", Translation_EN)
    val de = createTranslationIcon("de", "DE0.svg", Translation_DE)
    val be = createTranslationIcon("be", "BE.svg", Translation_FR)
    val ca = createTranslationIcon("ca", "CA.svg", Translation_FR)

    val languages = div(
      display.flex,
      height := "20px",
      id := "languages",
      fr,
      en,
      de,
      be,
      ca,
      marginLeft := "auto"
    )

    val header = h1(
      id := "header",
      display.flex,
      language.map(translation => CountDown.countDown(translation)),
      languages,
      fontSize := "20px",
      textAlign := "left",
      marginLeft := "10px"
    )

    val contentHandler =
      Var[Option[VMod]](None)

    val title = h1(
      id := "title",
      language.map(_.title),
      textAlign := "center",
      textShadow := "0 1px 1px #fff",
      fontSize := "80px",
      marginBottom := "0",
      onClick.as(None) --> contentHandler,
      cursor := "pointer"
    )

    val main_container = div(id := "mainContainer", contentHandler)

    val lights_div = div(
      id := "lightsDiv",
      marginLeft := "auto", // auto for marginLeft&Right to have the div centered
      marginRight := "auto",
      width := "450px", // default width for div is 100%
      /*backgroundImage := "url(lights.svg)",*/
      backgroundImage := "url(lichtketteF.svg)",
      backgroundSize := "contain",
      backgroundRepeat := "no-repeat",
      height := "75px",
      position := "relative",
      language.map { l =>
        light_div(
          "info",
          l.title_menu_info,
          onClick(decryptedLink).map(link =>
            Some(Infos.info(language.observable, link))
          ) --> contentHandler,
          0
        )
      },
      language.map { l =>
        light_div(
          "costume",
          l.title_menu_costume,
          onClick
            .mapTo(
              Some(Costume.costume(tokenValue.now, language.observable))
            ) --> contentHandler,
          1
        )
      },
      language.map { l =>
        light_div("fun", l.title_menu_fun, onClick.as(Some("fun")) --> page, 2)
      },
      language.map { l =>
        light_div(
          "photo",
          l.title_menu_photo,
          onClick.mapTo(
            Some(Photos.photo_before_party(language.observable))
          ) --> contentHandler,
          3
        )
      },
      language.map { l =>
        light_div(
          "contact",
          l.title_menu_contact,
          onClick.as(
            Some(Contact.contacts(language.observable))
          ) --> contentHandler,
          4
        )
      },
      onClick.foreach { isClicked = false }
    )

    def onClickToken(showTokenBox: Var[Boolean], tokenBorder: Var[String]) = {
      if (TokenLogic.isTokenValid(tokenValue.now)) {
        showTokenBox.set(false)
        val dectryptedLinkValue = TokenLogic.decryptWhatsappLink(
          encrypted_whatsapp_link,
          tokenValue.now
        )
        decryptedLink.set(dectryptedLinkValue)
      } else {
        tokenBorder.set("4px solid red")
      }
    }

    val home_div = {
      val showTokenBox = Var(true)
      val tokenBorder = Var("none")
      div(
        header,
        title,
        backgroundImage := "url(tente.jpg)",
        backgroundSize := "cover",
        backgroundPosition := "center 0",
        backgroundAttachment := "fixed",
        overflow := "auto",
        height := "100%",
        lights_div,
        contentHandler.map { content =>
          if (content.isDefined)
            main_container
          else
            VDomModifier.empty
        },
        Rx {
          if (showTokenBox()) {
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
                fontSize := "30px",
                width := "600px",
                cls := "innerShadow",
                border <-- tokenBorder,
                onInput.value.foreach { str =>
                  tokenValue.set(str)
                  tokenBorder.set("none")
                },
                onKeyDown.filter(_.keyCode == KeyCode.Enter).foreach {
                  onClickToken(showTokenBox, tokenBorder)
                }
              ),
              button(
                "OK",
                onClick.foreach {
                  onClickToken(showTokenBox, tokenBorder)
                },
                fontSize := "30px",
                marginLeft := "20px",
                backgroundColor := "#fd22c4",
                color := "white",
                fontWeight.bold,
                borderRadius := "3px",
                border := "none"
              )
            )
          } else VDomModifier.empty
        }
      )
    }

    val main = div(
      height := "100%",
      Rx {
        if (page() == Some("start")) {
          home_div
        } else if (page() == Some("fun")) {
          Fun.fun(page, language.observable)
        } else intro_div
      }
    )

    // OutWatch.renderReplace("#app", main).unsafeRunSync()
    Outwatch.renderReplace[SyncIO]("#app", main).unsafeRunSync()

  }
}
