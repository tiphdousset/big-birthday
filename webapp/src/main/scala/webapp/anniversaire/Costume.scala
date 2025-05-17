package anniversaire
import outwatch._
import outwatch.dsl._
import colibri._
import colibri.reactive._
import anniversaire.resources.{GuestAndFamily, GuestsAndFamilies2025}
object Costume {

  def costume(token: String, language: Observable[Translation]) = {

    val showCostume = Var(1)

    val button_costume = button(
      language.map(_.menu_costume_button_wheel),
      fontWeight.bold,
      fontSize := "15px",
      marginTop := "50px",
      marginLeft := "auto",
      marginRight := "auto",
      backgroundColor := "#fd22c4",
      color := "white",
      display := "block",
      onClick(2) --> showCostume
    )

    div(
      // language.map(_.menu_costume),
      // language.map(_.display_waiting_for_costume),
      language.map(l =>
        div.thunk("content rendering")(l.display_intro_costume)(
          VMod(
            fontSize := "16px",
            innerHTML := UnsafeHTML(l.display_intro_costume)
          )
        )
      ),
      Rx {
        if (showCostume() == 2 && isSaturdayGuest(token))
          displayCostume(token, language)
        else if (showCostume() == 2 && !isSaturdayGuest(token))
          not_a_saturday_guest(language)
        else
          button_costume
      },
      fontSize := "16px",
      whiteSpace := "pre-line"
    )
  }

  def isSaturdayGuest(token: String): Boolean = {
    TokenLogic.getFamily(token).isDefined
  }

  def displayCostume(token: String, language: Observable[Translation]) = {
    val guestAndfamily: Option[GuestAndFamily] = TokenLogic.getFamily(token)

    val family = guestAndfamily match {
      case Some(guestAndFamily2) =>
        guestAndFamily2.family match {
          case "oiseaux" =>
            language.map(l =>
              div.thunk("content rendering")(
                l.family_oiseaux(guestAndFamily2.familySize)
              )(
                VMod(
                  fontSize := "16px",
                  textAlign.center,
                  display.flex,
                  flexDirection.column,
                  div(
                    fontSize := "32px",
                    "🐦 🐧 🦆 🕊️ 🦢"
                  ),
                  div(
                    innerHTML := UnsafeHTML(
                      l.family_oiseaux(guestAndFamily2.familySize)
                    )
                  )
                )
              )
            )
          case "poissons" =>
            language.map(l =>
              div.thunk("content rendering")(
                l.family_poisson(guestAndFamily2.familySize)
              )(
                VMod(
                  fontSize := "16px",
                  textAlign.center,
                  display.flex,
                  flexDirection.column,
                  div(
                    fontSize := "32px",
                    "🐠 🐟 🐡 🐋 🦈"
                  ),
                  div(
                    innerHTML := UnsafeHTML(
                      l.family_poisson(guestAndFamily2.familySize)
                    )
                  )
                )
              )
            )
          case "rayures" =>
            language.map(l =>
              div.thunk("content rendering")(
                l.family_rayures(guestAndFamily2.familySize)
              )(
                VMod(
                  fontSize := "16px",
                  textAlign.center,
                  display.flex,
                  flexDirection.column,
                  div(
                    fontSize := "32px",
                    "🦓 🍭 🐝 🎪 🌈"
                  ),
                  div(
                    innerHTML := UnsafeHTML(
                      l.family_rayures(guestAndFamily2.familySize)
                    )
                  )
                )
              )
            )
          case "couleurs" =>
            language.map(l =>
              div.thunk("content rendering")(
                l.family_couleurs(guestAndFamily2.familySize)
              )(
                VMod(
                  fontSize := "16px",
                  textAlign.center,
                  display.flex,
                  flexDirection.column,
                  div(
                    fontSize := "32px",
                    "🟡 🟢 🟣 🟠 🟤"
                  ),
                  div(
                    innerHTML := UnsafeHTML(
                      l.family_couleurs(guestAndFamily2.familySize)
                    )
                  )
                )
              )
            )
          case "formes_geometriques" =>
            language.map(l =>
              div.thunk("content rendering")(
                l.family_formes_geometriques(guestAndFamily2.familySize)
              )(
                VMod(
                  fontSize := "16px",
                  textAlign.center,
                  display.flex,
                  flexDirection.column,
                  div(
                    fontSize := "32px",
                    "🟩 ⭕ 🔷 ⭐ 🔸"
                  ),
                  div(
                    innerHTML := UnsafeHTML(
                      l.family_formes_geometriques(guestAndFamily2.familySize)
                    )
                  )
                )
              )
            )
          case "paillettes" =>
            language.map(l =>
              div.thunk("content rendering")(
                l.family_paillettes(guestAndFamily2.familySize)
              )(
                VMod(
                  fontSize := "16px",
                  textAlign.center,
                  display.flex,
                  flexDirection.column,
                  div(
                    fontSize := "32px",
                    "✨ 🪩 💫 💎 🌟"
                  ),
                  div(
                    innerHTML := UnsafeHTML(
                      l.family_paillettes(guestAndFamily2.familySize)
                    )
                  )
                )
              )
            )
          case "legumes" =>
            language.map(l =>
              div.thunk("content rendering")(
                l.family_legumes(guestAndFamily2.familySize)
              )(
                VMod(
                  fontSize := "16px",
                  textAlign.center,
                  display.flex,
                  flexDirection.column,
                  div(
                    fontSize := "32px",
                    "🥕 🍅 🥦 🍌 🍒"
                  ),
                  div(
                    innerHTML := UnsafeHTML(
                      l.family_legumes(guestAndFamily2.familySize)
                    )
                  )
                )
              )
            )
          case "fleurs" =>
            language.map(l =>
              div.thunk("content rendering")(
                l.family_fleurs(guestAndFamily2.familySize)
              )(
                VMod(
                  fontSize := "16px",
                  textAlign.center,
                  display.flex,
                  flexDirection.column,
                  div(
                    fontSize := "32px",
                    "🌸 🌼 🌻 🌹 🌺"
                  ),
                  div(
                    innerHTML := UnsafeHTML(
                      l.family_fleurs(guestAndFamily2.familySize)
                    )
                  )
                )
              )
            )
          case "felins" =>
            language.map(l =>
              div.thunk("content rendering")(
                l.family_felins(guestAndFamily2.familySize)
              )(
                VMod(
                  fontSize := "16px",
                  textAlign.center,
                  display.flex,
                  flexDirection.column,
                  div(
                    fontSize := "32px",
                    "🐱 🐯 🦁 🐆 🦊"
                  ),
                  div(
                    innerHTML := UnsafeHTML(
                      l.family_felins(guestAndFamily2.familySize)
                    )
                  )
                )
              )
            )
        }
      case None =>
        language.map(l =>
          div.thunk("content rendering")(l.display_not_a_saturday_guest)(
            VMod(
              fontSize := "16px",
              innerHTML := UnsafeHTML(l.display_not_a_saturday_guest)
            )
          )
        )
    }

    div(family)

  }

  def magicGif(showCostume: Var[Int]) =
    div(
      display := "flex",
      video(
        margin := "20px auto",
        source(
          src := "https://media.giphy.com/media/6CovzgyTig7M4/giphy.mp4",
          tpe := "video/mp4"
        ),
        attr("autoplay") := true,
        onDomMount.asHtml.foreach { x =>
          x.onended = { _ =>
            showCostume.set(3)
          }
        }
      )
    )
  def not_a_saturday_guest(language: Observable[Translation]) =
    div(
      language.map(_.display_not_a_saturday_guest),
      display := "flex",
      flexDirection := "column",
      alignItems := "center",
      video(
        margin := "20px auto",
        source(
          src := "https://media.giphy.com/media/YOkrK8agZLEk2cXeLi/giphy.mp4",
          tpe := "video/mp4"
        ),
        attr("autoplay") := true,
        attr("loop") := true
      )
    )
}
