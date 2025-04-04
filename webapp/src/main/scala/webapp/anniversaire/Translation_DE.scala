package anniversaire

import outwatch.VDomModifier
import outwatch._
import outwatch.dsl._

object Translation_DE extends Translation {

  def intro_button: String = "They are back."
  def title: String = "Last Call For 35!"
  def count_down(numberOfDays: String): String = s"Noch $numberOfDays Tage"
  def count_downNow: String = s"Viel Spass!"
  def count_downAfter: String = s"Wir sehen uns in 4 Jahren!"

  def menu_info(whatsappLink: Option[String]): String = {
    val whatsappLinkMessage = whatsappLink match {
      case Some(link) =>
        s"""<center><a href="$link" target="_blank">Whatsapp-Gruppe</a></center>"""
      case None =>
        "<center>Bitte geben Sie ein gültiges Token an, um Zugang zur WhatsApp-Gruppe zu erhalten.</center>"
    }

    s"""
    <h2>Halli hallo!</h2>

    Für dich, lieber Freund, der auserwählt wurde, um unser 35-jähriges Jubiläum zu feiern gibt es hier einige nützliche Informationen zur Vorbereitung auf die lang erwartete Veranstaltung.
    

    <h2>Wann?</h2>
    Die Feierlichkeiten finden vom Samstag, den <b>7. bis Montag, den 9. Juni 2025</b> statt. Du wirst am späten Nachmittag am Samstag erwartet (z.B. gegen 17 Uhr) und wir werden das Gelände am Montag am späten Vormittag verlassen. 

    <h2>Wo?</h2>
    Wir können dir sagen, dass es sich um das prächtige Dorf <b>St. Colomban (44)</b> handelt, in einem Feld von <a href="https://maps.app.goo.gl/7LrY3YEMv25wooiU7" target="_blank">la ferme de Rublé</a>, 30 Minuten südlich von Nantes. Die genaue Lage des Feldes wird dir bei deiner Ankunft auf der Farm kunstvoll angezeigt, keine Sorge. 

    <h2>Wie?</h2>
    Wir empfehlen dir, die Mitfahrgelegenheiten von Nantes aus zu nutzen.<br />
    Für Leute, die nicht aus Nantes kommen, ist ein Ticket nach Nantes zu diesem Zeitpunkt mehr als genug.<br />
    Zum Schlafen wird ein Feld für Zelte zur Verfügung gestellt. Also denk daran, dein Zelt mitzunehmen ;-)
    <br></br>
    Um über die Veranstaltung auf dem Laufenden zu bleiben, empfehlen wir dir, der speziellen <b>WhatsApp-Gruppe</b> beizutreten, wo du unter anderem eine Untergruppe findest, die sich speziell mit Fahrgemeinschaften befasst.
    <br></br>
    $whatsappLinkMessage
    <br></br>
    Falls du dies noch nicht getan hast, teile bitte einem der Gastgeber mit, an welchem Essen (Samstagabend, Sonntagbrunch, Sonntagabend) du teilnehmen möchtest.
    <br></br>

    Wenn du kein Wort verstanden hast, weil du denkst, dass mein Deutsch zu undeutlich ist.... geh und nimm Französischunterricht und dann lies die französische Variante."""
  }

  def title_menu_info: String = "Informationen"

  def menu_costume: String =
    """Du hast nicht viel vorzubereiten, außer.... deinem Outfit für den Samstag!

    Für diejenigen, die gegen Verkleidungen allergisch sind, gibt es jedoch keinen Stress: Du kannst einfach eines der Lieblingsaccessoires der Figur tragen oder umgekehrt, sie in vollen Zügen spielen.

    Um zu wissen, was dich genau erwartet, komm Anfang Mai wieder und schau dir diese Seite an!"""

  def menu_costume_button_wheel: String = "Meine Verkleidung aufdecken"
  def title_menu_costume: String = "Dresscode"

  def menu_fun: String = "please bring me back home"
  def title_menu_fun: String = "DO NOT CLICK HERE"

  def menu_photo: String = "UNDER CONSTRUCTION"
  def menu_photo_before_party =
    "Geh, tanz und komm zurück im Juli (um die Fotos von der Party runterzuladen)!"
  def title_menu_photo: String = "Fotos"

  def menu_contact: String =
    """Du hast ein Frage? Oder du willst uns eine Liebeserklärung machen? Kein Problem, wir freuen uns auf deine Nachricht!"""
  def title_menu_contact: String = "Kontakt"

  def display_costume(
      guestName: String,
      costume: String,
      costumePartner: String
  ): VDomModifier =
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
    VDomModifier(div(b("Komm Anfang Mai zurück")), fontSize := "20px")

  def guest_book: String = "Gästebuch"
  def duo: String = "Pärchen"
  def appareil_jetable: String = "Einwegcameras"
}
