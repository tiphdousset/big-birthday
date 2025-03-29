package anniversaire.resources

case class Guest(name: String, host: List[String], token: String)

object Guests {
  val guests: List[Guest] = List(
    Guest(
      "foo@bar.com",
      List("F"),
      "queen-chocolat-banana-bene-party"
    )
  )

  val emails: Set[String] =
    guests.map { _.name }.toSet
  // TODO: re-activate the assert
//   assert((guests.size - 1) == emails.size)
  val tokens: Set[String] = guests.map { _.token }.toSet
  // TODO: re-activate the assert
//   assert(guests.size == tokens.size)

  // val words = List("tiphanie", "bene", "francois", "penis", "boobs", "fuck", "love", "shit", "sheet", "fun", "dog", "france", "baguette", "god", "dad", "mom", "ass", "fat", "birthday", "chocolat", "trump", "banana", "tente", "old")
  // List.fill(100)(List.fill(5)(words(util.Random.nextInt(words.length))).mkString("-"))

}
