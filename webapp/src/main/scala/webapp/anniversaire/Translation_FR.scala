package anniversaire
import outwatch.VDomModifier
import outwatch._
import outwatch.dsl._
object Translation_FR extends Translation {

  def intro_button: String = "They are back."
  def title: String = "Last Call For 35!"
  def count_down(numberOfDays: String): String = s"J - $numberOfDays"
  def count_downNow: String = s"Amuse toi bien!"
  def count_downAfter: String = s"Rendez-vous dans 4 ans!"

  def menu_info(whatsappLink: Option[String]): String = {
    val whatsappLinkMessage = whatsappLink match {
      case Some(link) =>
        s"""<center><a href="$link" target="_blank">Groupe WhatsApp</a></center>"""
      case None =>
        "<center>Veuillez fournir un token valide pour accéder au groupe WhatsApp</center>"
    }
    s"""
    <h2>Hoyé hoyé!</h2>
    Pour toi, cher ami.e choisis entre tous pour célébrer nos 35 ans, voici quelques informations utiles pour préparer l'évènement tant attendu.

    <h2>Quand?</h2>
    Les festivités se dérouleront du <b>Samedi 7 au Lundi 9 Juin 2025</b>. Tu es attendu en fin d'après midi le Samedi (disons vers 17h) et nous quitterons les lieux le Lundi en fin de matinée. 

    <h2>Où?</h2>
    Nous pouvons te dire que ça se passe dans la magnifique bourgade de <b>St Colomban (44)</b>, dans un champ de <a href="https://maps.app.goo.gl/7LrY3YEMv25wooiU7" target="_blank">la ferme de Rublé</a>, à 30 minutes au Sud de Nantes. La localisation précise du champ sera habilement indiquée à ton arrivée à la ferme, ne t'en fais pas.
    
    <h2>Comment?</h2>
    Nous te conseillons de miser sur le co-voiturage depuis Nantes.<br />
    Pour les non-nantais, un billet pour Nantes est à ce stade largement suffisant.<br /> 
    Pour le couchage, un champ sera mis à disposition pour planter les tentes. Pense donc à prendre ta tente ;-)
    <br></br>
    Pour être à jour sur l'évènement, nous te suggérons de <b>rejoindre le groupe WhatsApp</b> dédié, où tu trouveras entre autre un sous-groupe spécialement consacré au "&#128663; Covoiturage": 
    <br></br>
    $whatsappLinkMessage
    <br></br>
    Si tu ne l'as pas déjà fait, indique à l'un des hôtes à quel(s) repas (Samedi soir, Brunch du Dimanche, Dimanche soir) tu souhaites participer.
    <br></br>
    Non-french speaker : keep calm and don't panic, I'm sure you can find the transaltion icons yourself..."""
  }
  def title_menu_info: String = "Informations"

  def menu_costume: String =
    """Pas grand chose à préparer pour nous rejoindre si ce n'est...ta tenue du Samedi!
    Pour savoir ce que le hasard te réserve, reviens donc checker cette page début Mai.

    Pas de stress cependant pour les allergiques aux déguisements: tu peux te contenter d'arborer l'un des accessoires fétiches du personnage en question - ou au contraire le jouer à fond.
  """
  def menu_costume_button_wheel: String = "Révéler mon déguisement"
  def title_menu_costume: String = "Code vestimentaire"

  def menu_fun: String = "Please bring me back home"
  def title_menu_fun: String = "NE SURTOUT PAS CLIQUER ICI"

  def menu_photo: String = "EN CONSTRUCTION"
  def menu_photo_before_party =
    "Va, danse et reviens fin Juin (pour télécharger les photos du weekend)!"
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

  def display_waiting_for_costume: VDomModifier =
    VDomModifier(
      div(
        b("Encore un peu de patience, c'est presque prêt..."),
        fontSize := "20px"
      )
    )

  def display_intro_costume: String =
    """
    Parce que vous êtes toutes et tous les membres chéris de nos  <b>familles de cœur</b>, on vous rassemble en ce week-end festif <b>sous le signe des familles</b>. 

    <i>Mais qu'est-ce qu'une famille finalement ?</i>

    Les modèles conventionnels ne nous ayant pas satisfait, on vous en propose d'autres, dans lesquelles chacun est libre d'être le membre qu'il souhaite.

    Pour les allergiques aux déguisements, la consigne reste la même que toujours : pas de pression, de simples accessoires ou détails feront l'affaire.
    Pour les autres : on vous invite à laisser complètement libre cours à votre imagination, surprenez-nous !

    Ton objectif pour Samedi soir: <u>retrouver tous les membres de ta famille</u> pour nous faire <b>la plus belle photo de famille</b> qu'on puisse espérer garder sur notre buffet (comment ça plus personne n'a de buffet ??).
    """

  def family_poisson(familySize: Int): String =
    s"""
    Tu appartiens à la famille des <b>POISSONS</b>!
    (Il y a <b>$familySize</b> poissons dans ta famille)

    <center><i>"Les petits poissons dans l'eau
    Nagent, nagent, nagent, nagent, nagent
    Les petits poissons dans l'eau
    Nagent aussi bien que les gros."</i></center>

    Si toi aussi tu as chanté, re-chanté, re-re-chanté cette chanson dans ta baignoire, c'est que quelque part en toi un petit poisson tourne en rond et attend de s'exprimer au grand jour. 
    Le 7 Juin sera l'occasion idéale de sortir tes écailles et rejoindre le banc de poissons dans le grand bain.
    """

  def family_fleurs(familySize: Int): String =
    s"""
    Tu appartiens à la famille des <b>FLEURS</b>!
    (Il y a <b>$familySize</b> fleurs dans ta famille)

    <center><i>"C'était le temps des fleurs
    On ignorait la peur
    Les lendemains avaient un goût de miel."</i></center>

    Les paroles de Dalida seront ton hymne pour le Samedi 7 juin, cher membre de la famille des fleurs !
    Que tu passes tes plus beaux motifs et accessoires floraux, ou que tu te transformes en grand tournesol, l'important est de faire fleurir le bourgeon qui sommeille en toi ! 
    Retrouve d'autres brindilles égarés dans le mélange des motifs pour former un bouquet éphémère !
    """

  def family_legumes(familySize: Int): String =
    s"""
    Tu appartiens à la famille des <b>FRUITS & LÉGUMES</b> !
    (Il y a <b>$familySize</b> fruits et légumes dans ta famille)

    <center><i>"Salade de fruits, jolie, jolie, jolie"</i></center>

    Tel sera ton hymne pour inspirer ta parure, cher membre des fruits et légumes !
    Que tu veuilles revêtir ta plus belle chemisette à cerises ou donner corps à une nature morte flamande, laisse éclore le fruit ou le légume qui germe en toi et retrouve tes comparses pour une salade composée unique en son genre !
    """

  def family_paillettes(familySize: Int): String =
    s"""
    Tu appartiens à la famille des <b>PAILLETTES</b> !
    (Il y a <b>$familySize</b> paillettes dans ta famille)

    <center><i>"Remember when you were young, you shon like the sun. Shine on you crazy diamond"</i></center>

    Ces paroles de David Gilmour seront ton mantra pour la soirée, cher membre de la famille des paillettes ! 
    Que tu veuilles te parer de quelques paillettes au coin des yeux ou te transformer en véritable boule à facettes, tu auras compris l'idée, il s'agit de briller de mille feux et retrouver tes frères et sœurs de lumière dans la cacophonie des motifs !
  """

  def family_felins(familySize: Int): String =
    s"""
    Tu appartiens à la famille des <b>FÉLINS</b> !
    (Il y a <b>$familySize</b> félins dans ta famille)

    <center><i>"Everybody, everybody, everybody wants to be cat"</i></center>

    Chantent tes comparses les aristochats. Pour ce Samedi 7 Juin enfile ta combinaison léopard ou bien coiffe ta plus belle crinière, l'important est de réveiller le félin en toi et retrouver ta meute !
    """

  def family_oiseaux(familySize: Int): String =
    s"""
    Tu appartiens à la famille des <b>OISEAUX</b> !
    (Il y a <b>$familySize</b> oiseaux dans ta famille)

    <center><i>"Si j'étais un oiseau, 
    Je survolerais les villes,
    Je survolerais la campagne,
    Je survolerais des chantiers,
    Si j'étais un oiseau, 
    Même tout petit,
    Je survolerais le pays, 
    Avec le vent, avec les nuages..."</i></center>

    A défaut de pouvoir réellement décoller du sol (quoi que...), le Samedi 7 Juin sera l'occasion pour toi de révéler l'oiseau qui roucoule en toi. 
    Alors sors ton plumage, ton bec ou tes griffes, ajuste ton ramage et rejoins ta nuée !
    """

  def family_rayures(familySize: Int): String =
    s"""
    Tu appartiens à la famille des <b>RAYURES</b> !
    (Il y a <b>$familySize</b> rayures dans ta famille)

    <center><i>"Stripes on your shoulders, 
    Stripes on your back and on your hands"</i></center>

    Bob Dylan aurait-il vu à l'avance ta parure du Samedi soir ? Probablement. 
    Que tu veuilles te transformer en véritable zèbre, incarner l'adaje de Sonia Rykiel « la beauté sera toujours rayée », ou simplement sortir ta marinière du placard, la consigne est simple, il faut que tu retrouves ta famille rayée !
    """

  def family_couleurs(familySize: Int): String =
    s"""  
    Tu appartiens à la famille des <b>COULEURS</b> !
    (Il y a <b>$familySize</b> couleurs dans ta famille)

    <center><i>"Moon is yellow silver
    Oh, the things that summer brings
    It's a love you'd kill for 
    And all the world is green"</i></center>

    A l'instar de Tom Waits, tu verras le monde en couleur, façon monochrome en ce Samedi 7 juin. 
    Choisis celle que tu veux, et incarne la complètement. Retrouve ta famille de couleurs parmis le mélange des motifs et forme une palette unique en son genre.
    """

  def family_formes_geometriques(familySize: Int): String =
    s"""
    Tu appartiens à la famille des <b>MOTIFS GÉOMÉTRIQUES</b> !
    (Il y a <b>$familySize</b> motifs géométriques dans ta famille)

    <center><i>“Dieu, toujours, fait de la géométrie”</center></i> 
    
    a dit, un jour, il y a fort longtemps, un certain gars nommé Platon.

    C'est donc ton jour de chance, cher membre de cette famille !
    Car tu vas pouvoir te prendre pour Dieu le temps d'une soirée !
    Que tu veuilles tracer sur tes habits ou ta peau l'ensemble des formes parfaites au moyen d'un compas et d'une équerre, revêtir ta jupe à pois ou ta chemise à carrés (une cousine de la chemise à carreaux),
    la consigne est simple: retrouver ta famille géométrique.
    """

  def display_not_a_saturday_guest: String =
    """
    Tu ne seras malheureusement pas parmis nous le Samedi, tu n'as donc pas de code vestimentaire à préparer.
    """
  def guest_book: String = "Livre d'or"
  def duo: String = "Duo"
  def appareil_jetable: String = "Appareils jetables"
}
