package anniversaire

import outwatch.VDomModifier
import outwatch._

trait Translation {

  def intro_button: String
  def title: String
  def count_down(numberOfDays: String): String
  def count_downNow: String
  def count_downAfter: String

  def menu_info(whatsappLink: Option[String]): String
  def title_menu_info: String

  def menu_costume: String
  def menu_costume_button_wheel: String
  def title_menu_costume: String

  def menu_fun: String
  def title_menu_fun: String

  def menu_photo: String
  def menu_photo_before_party: String
  def title_menu_photo: String

  def menu_contact: String
  def title_menu_contact: String

  def display_costume(
      guestName: String,
      costume: String,
      costumePartner: String
  ): VDomModifier

  def display_waiting_for_costume: VDomModifier

  def guest_book: String
  def duo: String
  def appareil_jetable: String
  def display_intro_costume: String
  def family_poisson(familySize: Int): String
  def family_fleurs(familySize: Int): String
  def family_legumes(familySize: Int): String
  def family_paillettes(familySize: Int): String
  def family_felins(familySize: Int): String
  def family_oiseaux(familySize: Int): String
  def family_rayures(familySize: Int): String
  def family_couleurs(familySize: Int): String
  def family_formes_geometriques(familySize: Int): String
  def display_not_a_saturday_guest: String
}
