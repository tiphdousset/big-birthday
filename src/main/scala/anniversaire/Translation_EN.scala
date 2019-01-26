package anniversaire
object Translation_EN extends Translation{

  def intro_button : String = "They are back."
  def title : String = "La Tente'aine"
  def count_down(numberOfDays : Int) : String = s"D - $numberOfDays"

  //Menu informations
  def menu_info : String = """Hello world!

  For you, dear friend, chosen among all to celebrate our 30th anniversary, here is some useful information to prepare for the long-awaited event.

  First of all the date: the festivities will take place from Saturday 8 to Monday 10 June. You are expected in the late afternoon on Saturday (say around 5pm) and we will leave the premises on Monday in the late morning.

  For the place, we can tell you that it is happening in the magnificent village of St Colomban, 30 minutes south of Nantes. The exact location of the site will be communicated to you by then.
  We recommend that you take advantage of carpooling from Nantes, which can be organized via this site in due course.
  For non-Nantes people, a train or flight ticket to Nantes is more than enough at this stage.

  For sleeping, a field will be provided for tents. So don't forget to take your tent ;-)

  If you wish to arrive earlier / leave later, do not hesitate to contact us so that we can welcome you to one of our homes.

  If you didn't understand a word because you think my English is too approximate...go get French lessons and read the French version."""
  
  def title_menu_info : String = "Informations"

  //Menu costume
  def menu_costume : String = """Not much to prepare to join us except... your outfit!
  The following wheel will reveal to you in a few months a costume to wear on Saturday.

  Your character belongs to a duo and you will have to find and meet your partner among the guests during this first evening.

  No stress, however, for those allergic to disguises: you can simply wear one of the character's favourite accessories or, on the contrary, play it to the fullest, the important thing is to find your half. #love

  To know what's in store for you, come back and check this page in the spring!"""
  def menu_costume_button_wheel : String = "Who am I ?"
  def title_menu_costume : String = "Get dressed"

  //Menu fun
  def menu_fun : String = "please bring me back home"
  def title_menu_fun : String = "DO NOT CLICK HERE"

  //Menu photos
  def menu_photo : String = "UNDER CONSTRUCTION"
  def title_menu_photo : String = "Photos"

  //Menu contacts
  def menu_contact : String = "You have a question ? Or you just want to let us know that you love us ? Do not hesitate to write to us!"
  def title_menu_contact : String = "Contacts"

}
