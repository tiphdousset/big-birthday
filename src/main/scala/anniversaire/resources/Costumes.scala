package anniversaire.resources

object Costumes {
  val costumesList: List[(String, String)] =
    GuestsAndCostumes.listGuests.map{
      case ((_,costume1),(_,costume2)) => (costume1, costume2)
    }

//    ("Serena Williams", "Venus Williams"),
//    ("Bonnie", "Clyde"),
//    ("Olive", "Tom"),
//    ("Jeanne", "Serge"),
//    ("G. de Montmirail", "Jacquouille la Fripouille"),
//    ("Bébé (dirty dancing)", "Johnny"),
//    ("Vincent Vega", "Jules Winnfield"),
//    ("Sartre", "Beauvoir"),
//    ("Danny Zuko", "Dandy Olsson (Grease)"),
//    ("Tomtom", "Nana"),
//    ("Lenon", "Mccartney"),
//    ("Thelma", "Louise"),
//    ("Austin power", "La copine de Austin power"),
//    ("Veronique", "Davina"),
//    ("Igor Bogdanoff", "Grichka Bogdanoff"),
//    ("tic", "tac")

  val names: Set[String] = costumesList.flatMap{case (costume1, costume2) => List(costume1,costume2)}.toSet

}
