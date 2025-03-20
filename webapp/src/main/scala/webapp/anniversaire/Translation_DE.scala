package anniversaire

import outwatch.VDomModifier
import outwatch._
import outwatch.dsl._

object Translation_DE extends Translation {

  def intro_button: String = "They are back."
  def title: String = "Last Call For 35"
  def count_down(numberOfDays: String): String = s"Noch $numberOfDays Tage"
  def count_downNow: String = s"Viel Spass!"
  def count_downAfter: String = s"Wir sehen uns in 5 Jahren!"

  def menu_info: String =
    """Halli hallo!

    Für dich, lieber Freund, der auserwählt wurde, um unser 30-jähriges Jubiläum zu feiern gibt es hier einige nützliche Informationen zur Vorbereitung auf die lang erwartete Veranstaltung.
    Zunächst das Datum: Die Feierlichkeiten finden vom Samstag, den 8. bis Montag, den 10. Juni statt. Du wirst am späten Nachmittag am Samstag erwartet (z.B. gegen 17 Uhr) und wir werden das Gelände am Montag am späten Vormittag verlassen. 

    Für den Ort können wir dir sagen, dass es sich um das prächtige Dorf St. Colomban handelt, 30 Minuten südlich von Nantes. Der genaue Standort des Geländes wird dir bis dahin mitgeteilt. 
    Wir empfehlen dir, die Mitfahrgelegenheiten von Nantes aus zu nutzen, die zu gegebener Zeit über diese Website organisiert werden können. 
    Für Leute, die nicht aus Nantes kommen, ist ein Ticket nach Nantes zu diesem Zeitpunkt mehr als genug.

    Zum Schlafen wird ein Feld für Zelte zur Verfügung gestellt. Also denk daran, dein Zelt zu mitzunehmen ;-)

    Falls du früher ankommen oder später abreisen möchtest, zögere nicht, uns zu kontaktieren, damit du bei uns untergebracht werden kannst.

    Wenn du kein Wort verstanden hast, weil du denkst, dass mein Deutsch zu undeutlich ist.... geh und nimm Französischunterricht und dann lies die französische Variante."""

  def title_menu_info: String = "Informationen"

  def menu_costume: String =
    """Du hast nicht viel vorzubereiten, außer.... deinem Outfit!
    Das folgende Glücksrad wird dir in wenigen Monaten eine Verkleidung zeigen, die du am Samstag tragen musst.

    Dein Charakter ist Teil eines Paares und du musst deinen Partner an diesem ersten Abend unter den Gästen persönlich wiederfinden.

    Für diejenigen, die gegen Verkleidungen allergisch sind, gibt es jedoch keinen Stress: Du kannst einfach eines der Lieblingsaccessoires der Figur tragen oder umgekehrt, sie in vollen Zügen spielen. Das Wichtigste ist, deine Hälfte zu finden. #love 

    Um zu wissen, was dich genau erwartet, komm im Frühjahr wieder und schau dir diese Seite an!"""

  def menu_costume_button_wheel: String = "Wer bin ich?"
  def title_menu_costume: String = "Get dressed"

  def menu_fun: String = "please bring me back home"
  def title_menu_fun: String = "DO NOT CLICK HERE"

  def menu_photo: String = "UNDER CONSTRUCTION"
  def title_menu_photo: String = "Fotos"

  def menu_contact: String =
    """Du hast ein Frage? Oder du willst uns eine Liebeserklärung machen? Kein Problem, wir freuen uns auf deine Nachricht!"""
  def title_menu_contact: String = "Kontakt"

  def display_costume(guestName: String,
                      costume: String,
                      costumePartner: String): VDomModifier =
    VDomModifier(
      div("Du bist: "),
      div(b(s"$costume"), fontSize := "35px"),
      div("Suche nach: "),
      div(b(s"$costumePartner "), fontSize := "35px"),
      div(
        "Du weisst nicht wie sie aussehen? Keine Ausreden, ",
        a(
          "frag mal Google! ",
          href := s"http://lmgtfy.com/?t=i&q=$costume+et+$costumePartner",
          target := "_blank"
        )
      )
    )

  def display_no_costume: VDomModifier =
    VDomModifier(div(b("Kein Token, keine Verkleidung!")), fontSize := "20px")

  def guest_book: String = "Gästebuch"
  def duo: String = "Pärchen"
  def appareil_jetable: String = "Einwegcameras"
}
