package anniversaire

import outwatch.VDomModifier

trait Translation {

  def intro_button: String
  def title: String
  def count_down(numberOfDays: String): String
  def count_downNow: String
  def count_downAfter: String

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

  def display_costume(guestName: String,
                      costume: String,
                      costumePartner: String): VDomModifier

  def display_no_costume: VDomModifier

  def guest_book: String
  def duo: String
  def appareil_jetable: String
}
