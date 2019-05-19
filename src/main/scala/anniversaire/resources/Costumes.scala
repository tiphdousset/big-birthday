package anniversaire.resources

object Costumes {
  val costumes: List[(String, String)] =
    GuestsAndCostumes.guestsAndCostumes.map{
      case ((_,costume1),(_,costume2)) => (costume1, costume2)
    }

// Costumes not yet distributed
//    ("Olive", "Tom"),
//    ("Jeanne", "Serge"),
//    ("G. de Montmirail", "Jacquouille la Fripouille"),
//    ("Sartre", "Beauvoir"),
//    ("Danny Zuko", "Dandy Olsson (Grease)"),
//    ("Tomtom", "Nana"),
//    ("Lenon", "Mccartney"),
//    ("Thelma", "Louise"),
//    ("Austin power", "La copine de Austin power"),
//    ("Veronique", "Davina"),
//    ("Igor Bogdanoff", "Grichka Bogdanoff"),
//    ("tic", "tac")
//    ("power ranger rouge", "power ranger bleu")

  val names: Set[String] = costumes.flatMap{case (costume1, costume2) => List(costume1,costume2)}.toSet

}
