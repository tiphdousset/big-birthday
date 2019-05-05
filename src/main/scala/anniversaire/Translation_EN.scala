package anniversaire
object Translation_EN extends Translation {

  def intro_button: String = "They are back."
  def title: String = "La Tente'aine"
  def count_down(numberOfDays: Int): String = s"D - $numberOfDays"

  def menu_info: String =
    """Hello world!

  For you, dear friend, chosen among all to celebrate our 30th anniversary, here is some useful information to prepare for the long-awaited event.

  First of all the date: the festivities will take place from Saturday 8 to Monday 10 June. You are expected in the late afternoon on Saturday (say around 5pm) and we will leave on Monday in the late morning.

  For the place, we can tell you that it is happening in the magnificent village of St Colomban, 30 minutes south of Nantes. The exact location of the site will be communicated to you by then.
  We recommend that you take advantage of carpooling from Nantes, which can be organized via this site in due course.
  For non-Nantes people, a train or flight ticket to Nantes is more than enough at this stage.

  For sleeping, a field will be provided for tents. So don't forget to take your tent ;-)

  If you wish to arrive earlier / leave later, do not hesitate to contact us so that we can welcome you to one of our homes.

  If you didn't understand a word because you think my English is too unclear...go get French lessons and come back to read the French version."""

  def title_menu_info: String = "Information"

  def menu_costume: String =
    """Not much to prepare to join us except... your outfit!
  In a few months the following wheel will reveal to you a costume to wear on Saturday.

  Your character is part of a pair and you have to find your partner among the guests on this first evening.

  For those who are allergic to costumes, there is no stress: you can simply wear one of the character's favorite accessories, or alternatively, play it to the fullest. The most important thing is to find your half. #love 

  To know what awaits you, come back in spring and have a look at this page!"""

  def menu_costume_button_wheel: String = "Who am I?"
  def title_menu_costume: String = "Get dressed"

  def menu_fun: String = "please bring me back home"
  def title_menu_fun: String = "DO NOT CLICK HERE"

  def menu_photo: String = "UNDER CONSTRUCTION"
  def title_menu_photo: String = "Photos"

  def menu_contact: String =
    "You have a question? Or you just want to make us a declaration of love? Don't hesitate, we are looking forward to receive your message!"
  def title_menu_contact: String = "Contacts"

  def display_costume(guestName: String, costume: String): String =
    s"Congratulation $guestName! Your costume for Saturday is: $costume"

}
