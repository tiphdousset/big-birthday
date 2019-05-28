package anniversaire.resources

object Costumes {
  val costumes: List[(String, String)] =
    GuestsAndCostumes.guestsAndCostumes.map{
      case ((_,costume1),(_,costume2)) => (costume1, costume2)
    }

// Costumes not yet distributed
//    ("G. de Montmirail", "Jacquouille la Fripouille"),
//    ("Tomtom", "Nana"),
//    ("Olive", "Tom"),
//    ("Jeanne", "Serge"),
//    ("Sartre", "Beauvoir"),
//    ("Danny Zuko", "Dandy Olsson (Grease)"),
//    ("Lenon", "Mccartney"),
//    ("Thelma", "Louise"),
//    ("Austin power", "La copine de Austin power"),
//    ("Igor Bogdanoff", "Grichka Bogdanoff"),
//    ("tic", "tac")

  val names: Set[String] = costumes.flatMap{case (costume1, costume2) => List(costume1,costume2)}.toSet

}
