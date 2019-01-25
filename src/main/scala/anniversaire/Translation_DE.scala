package anniversaire
object Translation_DE extends Translation{

  def intro_button : String = "They are back."
  def title : String = "La Tente'aine"
  def count_down(numberOfDays: Int) : String = s"Noch $numberOfDays Tage"

  //Menu informations
  def menu_info : String = """Hoyé hoyé !

    Pour toi, cher ami.e choisis entre tous pour célébrer nos 30 ans, voici quelques informations utiles pour préparer l'évènement tant attendu.

    Tout d'abord la date : les festivités se dérouleront du Samedi 8 au Lundi 10 Juin. Tu es attendu en fin d'après midi le Samedi (disons vers 17h) et nous quitterons les lieux le Lundi en fin de matinée. 

    Pour le lieu, nous pouvons te dire que ça se passe dans la magnifique bourgade de St Colomban (44), à 30 minutes au Sud de Nantes. La localisation précise du site te sera communiquée d'ici là. 
    Nous te conseillons de miser sur le co-voiturage depuis Nantes, qui pourra être organisé via ce site en temps et en heure. 
    Pour les non-nantais, un billet pour Nantes est à ce stade largement suffisant.

    Pour le couchage, un champ sera mis à disposition pour planter les tentes. Pense donc à prendre ta tente ;-)

Si tu souhaites arriver plus tôt / partir plus tard, n'hésite pas à nous contacter afin que l'on puisse t'accueillir chez l'un d'entre nous.

  Non-french speaker : keep calm and don't panic, you can ask us for more explanations or..."""
  def title_menu_info : String = "Informationen"

  //Menu costume
  def menu_costume : String = """Pas grand chose à préparer pour nous rejoindre si ce n'est...ta tenue !
    La grande roue ci-après te dévoilera dans quelques mois un déguisement à revêtir le Samedi.

    Ton personnage appartient à un duo et tu devras lors de cette première soirée retrouver ton binôme parmi les invités.

    Pas de stress cependant pour les allergiques aux déguisements : tu peux te contenter d'arborer l'un des accessoires fétiches du personnage en question ou au contraire le jouer à fond, l'important c'est de retrouver ta moitié. #love 

  Pour savoir ce que le hasard te réserve, reviens donc checker cette page au printemps!"""
  def menu_costume_button_wheel : String = "Qui suis-je?"
  def title_menu_costume : String = "Get dressed"

  //Menu fun
  def menu_fun : String = "please bring me back home"
  def title_menu_fun : String = "DO NOT CLICK HERE"

  //Menu photos
  def menu_photo : String = "UNDER CONSTRUCTION"
  def title_menu_photo : String = "Fotos"

  //Menu contacts
  def menu_contact : String = "Tu as une question? Ou tu veux simplement nous faire une déclaration d'amour? N'hésite pas!"
  def title_menu_contact : String = "Kontakt"

}
