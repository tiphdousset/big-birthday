package anniversaire
import outwatch.VDomModifier
import outwatch._
import outwatch.dsl._
object Translation_FR extends Translation {

  def intro_button: String = "They are back."
  def title: String = "Last Call For 35"
  def count_down(numberOfDays: String): String = s"J - $numberOfDays"
  def count_downNow: String = s"Amuse toi bien!"
  def count_downAfter: String = s"Rendez-vous dans 5 ans!"

  def menu_info: String =
    """
    <h2>Hoyé hoyé!</h2>
    Pour toi, cher ami.e choisis entre tous pour célébrer nos 35 ans, voici quelques informations utiles pour préparer l'évènement tant attendu.

    <h2>Quand?</h2>
    Les festivités se dérouleront du <b>Samedi 7 au Lundi 9 Juin 2025</b>. Tu es attendu en fin d'après midi le Samedi (disons vers 17h) et nous quitterons les lieux le Lundi en fin de matinée. 

    <h2>Où?</h2>
    Nous pouvons te dire que ça se passe dans la magnifique bourgade de <b>St Colomban (44)</b>, dans un champ de <a href="https://maps.app.goo.gl/7LrY3YEMv25wooiU7">la ferme de Rublé</a>, à 30 minutes au Sud de Nantes. La localisation précise du champ sera habilement indiquée à ton arrivée à la ferme, ne t'en fais pas.
    
    <h2>Comment?</h2>
    Nous te conseillons de miser sur le co-voiturage depuis Nantes.<br />
    Pour les non-nantais, un billet pour Nantes est à ce stade largement suffisant. <br /> 
    Pour le couchage, un champ sera mis à disposition pour planter les tentes. Pense donc à prendre ta tente ;-)
    <br></br>
    Pour être à jour sur l'évènement, nous te suggérons de <b>rejoindre le groupe WhatsApp</b> dédié, où tu trouveras entre autre un sous-groupe spécialement consacré au "&#128663; Covoiturage".
    <br></br>
    Non-french speaker : keep calm and don't panic, I'm sure you can find the transaltion icons yourself..."""
  def title_menu_info: String = "Informations"

  def menu_costume: String =
    """Pas grand chose à préparer pour nous rejoindre si ce n'est...ta tenue du Samedi!
    Pour savoir ce que le hasard te réserve, reviens donc checker cette page mi Avril.

    Pas de stress cependant pour les allergiques aux déguisements: tu peux te contenter d'arborer l'un des accessoires fétiches du personnage en question - ou au contraire le jouer à fond.
  """
  def menu_costume_button_wheel: String = "Révéler mon déguisement"
  def title_menu_costume: String = "Get dressed"

  def menu_fun: String = "Please bring me back home"
  def title_menu_fun: String = "NE SURTOUT PAS CLIQUER ICI"

  def menu_photo: String = "EN CONSTRUCTION"
  def menu_photo_before_party =
    "Va, danse et reviens (pour télécharger les photos du weekend!"
  def title_menu_photo: String = "Photos"

  def menu_contact: String =
    "Tu as une question? Ou tu veux simplement nous faire une déclaration d'amour? N'hésite pas!"
  def title_menu_contact: String = "Contacts"

  def display_costume(
      guestName: String,
      costume: String,
      costumePartner: String
  ): VDomModifier =
    VDomModifier(
      div("Tu es: "),
      div(b(s"$costume"), fontSize := "35px"),
      div("Tu dois donc retrouver: "),
      div(b(s"$costumePartner "), fontSize := "35px"),
      div(
        "Tu ne sais pas à quoi ces personnages ressemblent? Pas d'excuse, ",
        a(
          "Google est ton ami! ",
          href := s"http://lmgtfy.com/?t=i&q=$costume+et+$costumePartner",
          target := "_blank"
        )
      )
    )

  def display_no_costume: VDomModifier =
    VDomModifier(div(b("Reviens mi Avril!"), fontSize := "20px"))

  def guest_book: String = "Livre d'or"
  def duo: String = "Duo"
  def appareil_jetable: String = "Appareils jetables"
}
