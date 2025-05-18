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

  def display_waiting_for_costume: VDomModifier =
    VDomModifier(
      div(b("Noch ein wenig Geduld, wir sind fast soweit ...")),
      fontSize := "20px"
    )

  def display_intro_costume: String =
    """
    Weil ihr alle uns nahestehende und wertvolle Menschen seid, vereinen wir euch an diesem festlichen Wochenende unter dem Motto der Familie. 
    
    <i>Doch was bedeutet Familie wirklich?</i> 
    
    Da uns die traditionellen Modelle nicht ganz überzeugt haben, bieten wir euch alternative Möglichkeiten an, bei denen jeder die Freiheit hat, die Rolle zu wählen, die er möchte.

    Für diejenigen, die sich nicht gerne verkleiden, gilt wie immer: Kein Zwang, einfache Accessoires oder Details sind völlig ausreichend. 
    Alle anderen sind eingeladen, ihrer Kreativität freien Lauf zu lassen und uns zu überraschen!

    Ein Ziel für Samstagabend: <u>Versammeln deiner gesamten Familie</u> für <b>das ultimative Familienfoto</b>!
    """
  def family_poisson(familySize: Int): String =
    s"""
    Du gehörst zur <b>FISCHE</b>-Familie!
    Es gibt <b>$familySize</b> Fische in deiner Familie.

    <i><center>"Fischers Fritz fischt frische Fische, frische Fische fischt Fischers Fritz."</center></i> 

    Wenn auch du im Geheimen diesen Zungenbrecher unzählige Male wiederholt hast, dann wartet irgendwo in dir ein kleiner Fisch darauf, ins Rampenlicht zu schwimmen. 
    Der 7. Juni wird die ideale Gelegenheit sein, deine Schuppen zu zeigen und dich dem Schwarm im großen Becken anzuschließen.
    """

  def family_fleurs(familySize: Int): String =
    s"""
    Du gehörst zur <b>BLUMEN</b>-Familie!
    Es gibt <b>$familySize</b> Blumen in deiner Familie.
    
    <i><center>"Es war die Zeit der Blumen
    Wir kannten keine Angst
    Die Zukunft schmeckte nach Honig"</center></i> 
    
    Die Worte von Dalida werden deine Hymne für Samstag, den 7. Juni, lieber Vertreter der Blumenfamilie! 
    Ob du deine schönsten Blumenmuster und -accessoires trägst,
    oder dich in eine große Sonnenblume verwandelst,
    das Wichtigste ist, die Knospe in dir zum Erblühen zu bringen! 
    Finde andere verstreute Zweige im Mustergewusel, um einen vergänglichen Blumenstrauß zu bilden!
    """

  def family_legumes(familySize: Int): String =
    s"""
    Du gehörst zur <b>OBST & GEMÜSE</b>-Familie!
    Es gibt <b>$familySize</b> Obst und Gemüse in deiner Familie.

    <i><center>"Obstsalat, hübsch, hübsch, hübsch"</center></i> 

    Das wird deine Hymne sein, um dein Outfit zu inspirieren, lieber Vertreter der Obst- und Gemüsefamilie! 
    Ob du dein schönstes Hemd mit Kirschenmuster tragen,
    oder ein flämisches Stillleben zum Leben erwecken möchtest,
    lass das Obst oder Gemüse, das in dir wächst, erblühen und finde deine Mitstreiter für einen einzigartigen gemischten Salat!
    """

  def family_paillettes(familySize: Int): String =
    s"""
    Du gehörst zur <b>GLITZER</b>-Familie!
    Es gibt <b>$familySize</b> Glitzer in deiner Familie.

    <i><center>"Remember when you were young, you shone like the sun. Shine on you crazy diamond"</center></i> 

    Diese Worte von David Gilmour werden dein Mantra für den Abend sein, lieber Vertreter der Glitzerfamilie! 
    Ob du nur ein paar Glitzerpartikel in die Augenwinkel setzen,
    oder dich in eine echte Discokugel verwandeln möchtest,
    du hast die Idee verstanden: Es geht darum, in voller Pracht zu erstrahlen und deine Lichtgeschwister in der Vielfalt der Muster wiederzufinden!
  """

  def family_felins(familySize: Int): String =
    s"""
    Du gehörst zur <b>KATZEN</b>-Familie!
    Es gibt <b>$familySize</b> Katzen in deiner Familie.

    <i><center>"Everybody, everybody, everybody wants to be a cat"</center></i> 

    singen deine Gefährten aus den Aristocats. 
    Für den 7. Juni schlüpf in deinen Leopardenanzug,
    oder style deine prächtigste Mähne.
    Das Wichtigste ist, die Katze in dir zu erwecken und dein Rudel zu finden!
    """

  def family_oiseaux(familySize: Int): String =
    s"""
    Du gehörst zur <b>VOGELN</b>-Familie!
    Es gibt <b>$familySize</b> Vögel in deiner Familie.

    <i><center>"Wenn ich ein Vogel wäre, würde ich über die Städte fliegen, über das Land, Parkplätze, andere Parkplätze, Denkmäler, Baustellen, ich würde über Baustellen fliegen, wenn ich ein Vogel wäre, selbst ganz klein, würde ich über das Land fliegen, mit dem Wind, mit den Wolken..."</center></i> 

    Auch wenn du nicht wirklich abheben kannst (oder vielleicht doch...), ist der 7. Juni die Gelegenheit, den Vogel in dir zum Vorschein zu bringen. 
    Also zeig dein Gefieder, deinen Schnabel oder deine Krallen, richte dein Geflatter aus und schließe dich deinem Schwarm an!
    """

  def family_rayures(familySize: Int): String =
    s"""
    Du gehörst zur <b>STREIFEN</b>-Familie!
    Es gibt <b>$familySize</b> Streifen in deiner Familie.

    <i><center>"Stripes on your shoulders, Stripes on your back and on your hands"</center></i> 

    Hat Bob Dylan vielleicht schon deine Aufmachung für den Samstagabend vorausgesehen, lieber Vertreter der Streifenfamilie? 
    Wahrscheinlich. 
    Egal, ob du dich in ein echtes Zebra verwandeln, 
    das Motto von Sonia Rykiel „beauty will always be striped“ verkörpern,
    oder einfach nur dein Ringelshirt aus dem Schrank holen möchtest.
    Die Regel ist einfach: Finde deine gestreifte Familie!
    """

  def family_couleurs(familySize: Int): String =
    s"""  
    Du gehörst zur <b>FARBEN</b>-Familie!
    Es gibt <b>$familySize</b> Farben in deiner Familie.

    <i><center>"Moon is yellow silver
    Oh, the things that summer brings
    It's a love you'd kill for 
    And all the world is green"</center></i>

    Wie Tom Waits wirst auch du die Welt in Farbe sehen, auf monochrome Art und Weise an diesem Samstag, dem 7. Juni. 
    Wähle eine Farbe, die du magst, und verkörpere sie vollständig. 
    Finde deine Farbenfamilie im bunten Mustergewirr und bildet zusammen eine einzigartige Palette.
    """

  def family_formes_geometriques(familySize: Int): String =
    s"""
    Du gehörst zur <b>GEOMETRISCHE MUSTER</b>-Familie!
    Es gibt <b>$familySize</b> geometrische Muster in deiner Familie.

    <i><center>"Gott betreibt immer Geometrie"</center></i> 

    sagte einst ein gewisser Platon vor langer Zeit.

    Dies ist also dein Glückstag, lieber Vertreter dieser Familie, denn du kannst dich für einen Abend wie ein Schöpfer fühlen! 
    Egal, ob du perfekte Formen auf deine Kleidung,
    oder Haut mit Zirkel und Lineal zeichnen willst,
    deinen gepunkteten Rock oder dein kariertes Hemd anziehen möchtest.
    Die Regel ist einfach: Finde deine geometrische Familie!
    """

  def display_not_a_saturday_guest: String =
    """
    Leider werden wir dich am Samstag nicht bei uns haben. Das heißt, du brauchst dich um kein Dresscode zu kümmern.
    """
  def guest_book: String = "Gästebuch"
  def duo: String = "Pärchen"
  def appareil_jetable: String = "Einwegcameras"
}
