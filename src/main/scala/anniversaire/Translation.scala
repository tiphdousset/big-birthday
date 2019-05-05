package anniversaire
trait Translation {

  def intro_button: String
  def title: String
  def count_down(numberOfDays: Int): String

  def menu_info: String
  def title_menu_info: String

  def menu_costume: String
  def menu_costume_button_wheel: String
  def title_menu_costume: String

  def menu_fun: String
  def title_menu_fun: String

  def menu_photo: String
  def title_menu_photo: String

  def menu_contact: String
  def title_menu_contact: String

  def display_costume(guestName: String, costume: String): String
}
