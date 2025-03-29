package anniversaire.resources

object GuestsAndCostumes {
  val guestsAndCostumes: List[((String, String), (String, String))] = List(
    (("foo@bar.com", "Jesus"), ("aaa@bbb.com", "Marie"))
  )
  val guestsEmails: Set[String] = guestsAndCostumes.flatMap {
    case ((email1, _), (email2, _)) => List(email1, email2)
  }.toSet
  assert((guestsAndCostumes.size * 2) == guestsEmails.size)

  val guestCostumes: Set[String] = guestsAndCostumes.flatMap {
    case ((_, costume1), (_, costume2)) => List(costume1, costume2)
  }.toSet
}
