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

  def display_no_costume: VDomModifier =
    VDomModifier(div(b("Come back early May!"), fontSize := "20px"))

  def guest_book: String = "Guest book"
  def duo: String = "Pairs"
  def appareil_jetable: String = "Disposable cameras"

}
