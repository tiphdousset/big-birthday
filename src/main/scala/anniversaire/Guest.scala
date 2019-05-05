package anniversaire

case class Guest(name:String , host:List[String], token:String)

object GuestCostume{

  val guests = List(
    Guest("Felix", List("T"), "A"),
    Guest("Julie", List("T", "B"), "B"),
    Guest("Manon", List("F"), "C"),
    Guest("Jeremy", List("T", "F", "B"), "D"),
    Guest("Clemi", List("T", "F" ), "E"!
  )

  val guestsNames = guests.map(guest => guest.name)

  val costumes = List(
    ("Mario", "Luigi"),
    ("Roméo", "Juliette"),
    ("Asterix", "Obelix")
  )


def getListPairGuests(guests: List[Guest]) : List[(Guest, Guest, Int)] = {
  val g = for (List(guest, guest2) <- guests.combinations(2)) yield 
  {
    val x = guest.host.intersect(guest2.host).size
    (guest, guest2, x)
  }
  return  g.toList.sortBy(i => i._3)
}

//println(getListPairGuests(guests).mkString("\n"))


def getListBestPairGuests(listPairGuests: List[(Guest, Guest, Int)]) : Seq[(String, String)] = {
  val used = collection.mutable.HashSet[Guest]()
  val result = collection.mutable.ArrayBuffer[(String, String)]()

  for ( (guest, guest2, _)  <- listPairGuests)
  {
    if (!used(guest) && !used(guest2))
    {
      used += (guest)
      used += (guest2)
      result += ((guest.name, guest2.name))
    }
  }
  return result // ( (Felix, Manon), (Julie, Clemi) )
}

val listBestPairGuests = getListBestPairGuests(getListPairGuests(guests))
//println(listBestPairGuests.mkString("\n"))
val listBestPairGuestsName = listBestPairGuests.flatMap{case (name1, name2) => List(name1, name2) }

def whoIsAlone(allGuestsNames : List[String], usedGuestsNames : List[String]): List[String] = {
  allGuestsNames.diff(usedGuestsNames)
}

def getListGuestAndCostume(listPairGuests : Seq[(String, String)], listCostumes : List[(String, String)]) : Seq[((String, String), (String, String))]= {
  val unzip_listCostumes = listCostumes.unzip
  val unzip_listPairGuests = listPairGuests.toList.unzip
  val unzip1 = unzip_listPairGuests._1.zip(unzip_listCostumes._1)
  val unzip2 = unzip_listPairGuests._2.zip(unzip_listCostumes._2)
  unzip1.zip(unzip2) // ( ((Felix,Mario),(Manon,Luigi)), ((Julie, Roméo),(Clemi, Juliette)) )
}

val listGuestAndCostume = getListGuestAndCostume(listBestPairGuests, costumes)
//println(listGuestAndCostume.mkString("\n"))

def findNameAndCostumePerToken(token : String) : Option[(String, String)] = {

 val listAllGuests: List[Guest] = guests

 val listGuestAndCostume: Seq[((String,String), (String, String))] = getListGuestAndCostume(listBestPairGuests, costumes);

  val name: Option[String] = listAllGuests.find(guest => guest.token == token).map(guest => guest.name)
  name.flatMap{name => 
    val flatListGuestAndCostume = listGuestAndCostume.flatMap{case (tuple1,tuple2) => List(tuple1,tuple2 ) }
    val costume: Option[String] = flatListGuestAndCostume.find{case (guestName, costume)=> guestName == name}.map{case (guestName, costume) => costume}
    costume.map{costume =>(name, costume)}
  }
}

def isTokenValid(token : String) = {
  //guests.exists(guest => guest.token == token)
  guests.exists(_.token == token)
}

}
