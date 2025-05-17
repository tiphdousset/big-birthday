package anniversaire
import outwatch.VDomModifier
import outwatch._
import outwatch.dsl._
object Translation_EN extends Translation {

  def intro_button: String = "They are back."

  def title: String = "Last Call For 35!"

  def count_down(numberOfDays: String): String = s"D - $numberOfDays"
  def count_downNow: String = s"Have Fun!"
  def count_downAfter: String = s"See you in 4 years!"

  def menu_info(whatsappLink: Option[String]): String = {
    val whatsappLinkMessage = whatsappLink match {
      case Some(link) =>
        s"""<center><a href="$link" target="_blank">Whatsapp group</a></center>"""
      case None =>
        "<center>Please provide a valid token to access the WhatsApp group</center>"
    }
    s"""
  <h2>Yo yo yo!</h2>

  For you, dear friend, chosen among all to celebrate our 35th anniversary, here is some useful information to prepare for the long-awaited event.

  <h2>When?</h2>
  The festivities will take place from <b>Saturday 7 to Monday 9 June 2025</b>. You are expected in the late afternoon on Saturday (say around 5pm) and we will leave on Monday in the late morning.

  <h2>Where?</h2>
  We can tell you that it is happening in the magnificent village of <b>St Colomban (44)</b>, in a field of <a href="https://maps.app.goo.gl/7LrY3YEMv25wooiU7" target="_blank">la ferme de Rublé</a>, 30 minutes south of Nantes. The exact location of the field will be cleverly indicated when you arrive at the farm, don't worry.
  
  <h2>How?</h2>
  We recommend that you take advantage of carpooling from Nantes.<br />
  For non-Nantes people, a train or flight ticket to Nantes is more than enough at this stage.<br />
  For sleeping, a field will be provided for tents. So don't forget to take your tent ;-)
  <br></br>
  To stay up to date on the event, we recommend that you join the special <b>WhatsApp group</b>, where you will find a sub-group dedicated to carsharing. 
  <br></br>
  $whatsappLinkMessage
  <br></br>
  If you haven't already done so, tell one of the hosts which meal(s) (Saturday evening, Sunday Brunch, Sunday evening) you'd like to attend.
  <br></br>

  If you didn't understand a word because you think my English is too unclear...go get French lessons and come back to read the French version."""
  }

  def title_menu_info: String = "Information"

  def menu_costume: String =
    """Not much to prepare to join us except... your outfit for Saturday!

  For those who are allergic to costumes, there is no stress: you can simply wear one of the character's favorite accessories, or alternatively, play it to the fullest.

  To know what awaits you, come back at the beginning of May and have a look at this page!"""

  def menu_costume_button_wheel: String = "Reveal my costume"

  def title_menu_costume: String = "Dresscode"

  def menu_fun: String = "please bring me back home"

  def title_menu_fun: String = "DO NOT CLICK HERE"

  def menu_photo: String = "UNDER CONSTRUCTION"
  def menu_photo_before_party =
    "Go, dance and come back in July (to download the pictures of the party)!"

  def title_menu_photo: String = "Photos"

  def menu_contact: String =
    "You have a question? Or you just want to make us a declaration of love? Don't hesitate, we are looking forward to receive your message!"

  def title_menu_contact: String = "Contacts"

  def display_costume(
      guestName: String,
      costume: String,
      costumePartner: String
  ): VDomModifier =
    VDomModifier(
      div("You are: "),
      div(b(s"$costume"), fontSize := "35px"),
      div("Look for: "),
      div(b(s"$costumePartner "), fontSize := "35px"),
      div(
        "You don't know how they look like? No excuse, ",
        a(
          "ask Google! ",
          href := s"http://lmgtfy.com/?t=i&q=$costume+et+$costumePartner",
          target := "_blank"
        )
      )
    )

  def display_waiting_for_costume: VDomModifier =
    VDomModifier(
      div(
        b("Just a little more patience, it's almost ready..."),
        fontSize := "20px"
      )
    )

  def display_intro_costume: String =
    """
    Because you're all beloved members of our chosen families, we're bringing you together for a weekend of family-themed festivities. 

    <i>But what really makes a family?</i>

    Traditional models didn't work for us, so we're offering new ones where everyone can be the member they wish.

    For those not keen on costumes, the rule remains: no pressure, just simple accessories or details will do.
    For the rest: let your imagination run wild.

    One goal for Saturday night: <u>gather your family</u> for <b>the ultimate family photo</b>!
    """

  def family_poisson(familySize: Int): String =
    s"""
    You're part of the <b>FISH</b> family!
    There are <b>$familySize</b> fish in your family.

    Let the vibes of "Under the Sea" from The Little Mermaid inspire you on Saturday, June 7th! 
    If you've ever dreamed of exploring the ocean's depths, now's your chance to dive in.
    Bring out your scales and join the school of fish for an oceanic adventure.
    """

  def family_fleurs(familySize: Int): String =
    s"""
    You're part of the <b>FLOWERS</b> family!
    There are <b>$familySize</b> flowers in your family.

    Join us on Saturday, June 7th, to celebrate in full bloom!
    Whether you wear your best floral prints or transform into a giant sunflower, let your inner flower shine. 
    Connect with other petals in the garden to create a one-night-only bouquet!
    """

  def family_legumes(familySize: Int): String =
    s"""
    You're part of the <b>FRUITS & VEGGIES</b> family!
    There are <b>$familySize</b> fruits and veggies in your family.

    On Saturday, June 7th, get ready to celebrate in style!
    Whether you dress as a juicy strawberry,
    or a vibrant carrot,
    let your colorful side shine! 
    Gather with other fruits and veggies for a fun and healthy party!
    """

  def family_paillettes(familySize: Int): String =
    s"""
    You're part of the <b>SPARKLE</b> family!
    There are <b>$familySize</b> sparkles in your family.

    <center><i>"Remember when you were young, you shon like the sun. Shine on you crazy diamond"</i></center>

    Let the vibe of "Shine On You Crazy Diamond" by Pink Floyd inspire you on Saturday, June 7th!
    Whether you add a bit of glitter to your eyes,
    or dress up like a disco ball,
    the idea is to glow. 
    Join your fellow glitter fans for a night of bright fun!
  """

  def family_felins(familySize: Int): String =
    s"""
    You're part of the <b>CATS</b> family!
    There are <b>$familySize</b> cats in your family.

    <center><i>"Everybody, everybody, everybody wants to be cat"</i></center>

    On Saturday, June 7th, unleash your inner feline!
    Whether you wear a leopard print outfit,
    or style your hair like a lion's mane,
    the key is to embrace your wild side and find your pack!
    """

  def family_oiseaux(familySize: Int): String =
    s"""
    You're part of the <b>BIRDS</b> family!
    There are <b>$familySize</b> birds in your family.

    On Saturday, June 7th, let your inner bird take flight!
    Whether you show off your feathers, beak, or claws, 
    it's time to spread your wings and join the flock!
    """

  def family_rayures(familySize: Int): String =
    s"""
    You're part of the <b>STRIPES</b> family!
    There are <b>$familySize</b> stripes in your family.

    Bob Dylan might have predicted your Saturday night look with 
    
      <center><i>"Stripes on your shoulders, stripes on your back and on your hands."</i></center>
    
    Whether you transform into a zebra,
    embody Sonia Rykiel's motto "beauty will always be striped",
    or simply pull out your striped sailor shirt, 
    the mission is clear: reunite with your stripe-loving family!
    """

  def family_couleurs(familySize: Int): String =
    s"""  
    You're part of the <b>COLORS</b> family!
    There are <b>$familySize</b> colors in your family.

    <center><i>"Moon is yellow silver
    Oh, the things that summer brings
    It's a love you'd kill for 
    And all the world is green"</i></center>

    Like Tom Waits, you'll see the world in color this Saturday, June 7th. 
    Pick your favorite plain color and wear it proudly. 
    Join your colorful family to create a one-of-a-kind palette!
    """

  def family_formes_geometriques(familySize: Int): String =
    s"""
    You're part of the <b>GEOMETRIC PATTERNS</b> family!
    There are <b>$familySize</b> geometric patterns in your family.

    <i><center>"God always does geometry"...</center></i>
    
    ...said a certain guy named Plato a long time ago.

    So, this is your lucky day, dear member of this family, because you get to feel like God for an evening! 
    Whether you want to draw all the perfect shapes on your clothes or skin using a compass and a set square, wear your polka dot skirt or your square-patterned shirt (a relative of the usual plaid shirt), the rule is simple: reconnect with your geometric family.
    """

  def display_not_a_saturday_guest: String =
    """
    Unfortunately, you won't be with us on Saturday, that means you don't need to prepare a dress code.
    """
  def guest_book: String = "Guest book"
  def duo: String = "Pairs"
  def appareil_jetable: String = "Disposable cameras"

}
