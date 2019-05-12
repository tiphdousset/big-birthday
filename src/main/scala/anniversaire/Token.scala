package anniversaire

import anniversaire.resources.{Guest, GuestsAndCostumes, Guests, Costumes}

object TokenLogic {

  val guests = Guests.listGuests

  val guestsNames = guests.map(guest => guest.name)

  val costumes: List[(String, String)] = Costumes.costumesList

  def getListPairGuests(guests: List[Guest]): List[(Guest, Guest, Int)] = {
    val g = for (List(guest, guest2) <- guests.combinations(2)) yield {
      val x = guest.host.intersect(guest2.host).size
      (guest, guest2, x)
    }
    return g.toList.sortBy(i => i._3)
  }

  //println(getListPairGuests(guests).mkString("\n"))

  def getListBestPairGuests(
                             listPairGuests: List[(Guest, Guest, Int)]): Seq[(String, String)] = {
    val used = collection.mutable.HashSet[Guest]()
    val result = collection.mutable.ArrayBuffer[(String, String)]()

    for ((guest, guest2, _) <- listPairGuests) {
      if (!used(guest) && !used(guest2)) {
        used += (guest)
        used += (guest2)
        result += ((guest.name, guest2.name))
      }
    }
    return result // ( (Felix, Manon), (Julie, Clemi) )
  }

  val listBestPairGuests = getListBestPairGuests(getListPairGuests(guests))
  //println(listBestPairGuests.mkString("\n"))
  val listBestPairGuestsName = listBestPairGuests.flatMap {
    case (name1, name2) => List(name1, name2)
  }

  def whoIsAlone(allGuestsNames: List[String],
                 usedGuestsNames: List[String]): List[String] = {
    allGuestsNames.diff(usedGuestsNames)
  }


  def findNameAndCostumePerToken(token: String): Option[(String, String)] = {

    val listAllGuests: List[Guest] = guests

    val listGuestAndCostume: Seq[((String, String), (String, String))] = GuestsAndCostumes.listGuests

    val name: Option[String] =
      listAllGuests.find(guest => guest.token == token).map(guest => guest.name)
    println("name = "+name)
    name.flatMap { name =>
      val flatListGuestAndCostume = listGuestAndCostume.flatMap {
        case (tuple1, tuple2) => List(tuple1, tuple2)
      }
      flatListGuestAndCostume
        .find { case (guestName, costume) => guestName == name }
    }
  }

  def isTokenValid(token: String) = {
    //guests.exists(guest => guest.token == token)
    guests.exists(_.token == token)
  }

  def fromTupleToList(costumes: (String, String)): List[String] = {
    costumes match {
      case (a,b) => List(a,b)
    }
  }

  def findCostumePartner(costumeA: String) : String = {
    println("TEST")
    val costumePair = costumes.find( x => fromTupleToList(x).contains(costumeA)).get
    println("costumePair= "+costumePair)
    costumePair match {
      case (partner, `costumeA`) => partner
      case (`costumeA`, partner) => partner
    }
  }

  //  costumes.collectFirst{
  //    case (partner, `costumeA`) => partner
  //    case (`costumeA`, partner) => partner
  //  }
  //
  //  costumes.collectFirst{
  //    case (a,b) if List(a,b).contains(costumeA) => Set(a,b)-costumeA
  //  }

}
