package anniversaire

import anniversaire.resources.{
  Guest,
  GuestsAndCostumes,
  Guests,
  Costumes,
  TokensHashes,
  GuestsAndFamilies2025,
  GuestAndFamily
}

import anniversaire.AESUtil
import anniversaire.HashUtil

object TokenLogic {

  val guests = Guests.guests

  val guestsNames = guests.map(guest => guest.name)

  val costumes: List[(String, String)] = Costumes.costumes

  def getListPairGuests(guests: List[Guest]): List[(Guest, Guest, Int)] = {
    val g = for (List(guest, guest2) <- guests.combinations(2)) yield {
      val x = guest.host.intersect(guest2.host).size
      (guest, guest2, x)
    }
    return g.toList.sortBy(i => i._3)
  }

  // println(getListPairGuests(guests).mkString("\n"))

  def getListBestPairGuests(
      listPairGuests: List[(Guest, Guest, Int)]
  ): Seq[(String, String)] = {
    val used = collection.mutable.HashSet[Guest]()
    val result = collection.mutable.ArrayBuffer[(String, String)]()

    for ((guest, guest2, _) <- listPairGuests) {
      if (!used(guest) && !used(guest2)) {
        used += (guest)
        used += (guest2)
        result += ((guest.name, guest2.name))
      }
    }
    return result.toSeq // ( (Felix, Manon), (Julie, Clemi) )
  }

  val listBestPairGuests = getListBestPairGuests(getListPairGuests(guests))
  // println(listBestPairGuests.mkString("\n"))
  val listBestPairGuestsName = listBestPairGuests.flatMap {
    case (name1, name2) => List(name1, name2)
  }

  def whoIsAlone(
      allGuestsNames: List[String],
      usedGuestsNames: List[String]
  ): List[String] = {
    allGuestsNames.diff(usedGuestsNames)
  }

  def findNameAndCostumePerToken(token: String): Option[(String, String)] = {

    val listAllGuests: List[Guest] = guests

    val listGuestAndCostume: Seq[((String, String), (String, String))] =
      GuestsAndCostumes.guestsAndCostumes

    val name: Option[String] =
      listAllGuests.find(guest => guest.token == token).map(guest => guest.name)
    println("name = " + name)
    name.flatMap { name =>
      val flatListGuestAndCostume = listGuestAndCostume.flatMap {
        case (tuple1, tuple2) => List(tuple1, tuple2)
      }
      flatListGuestAndCostume
        .find { case (guestName, costume) => guestName == name }
    }
  }

  def getSha256Costume(token: String): Option[String] = {
    val costume_token = extractCostumeToken(token)
    println(s"costume_token: $costume_token")
    costume_token.map(HashUtil.sha256(_))
  }

  def getFamily(token: String): Option[GuestAndFamily] = {
    val sha256Costume = getSha256Costume(token)
    sha256Costume.flatMap(sha256 =>
      GuestsAndFamilies2025.guestsAndFamilies.find(guestAndFamily =>
        guestAndFamily.sha256 == sha256
      )
    )
  }

  def isTokenValid(token: String) = {
    val hash_token = getSha256Costume(token)
    println(s"hash_token: $hash_token")
    val valid_tokens_hashes: List[String] = TokensHashes.hashes
    hash_token.exists(hash => valid_tokens_hashes.contains(hash))
  }

  def fromTupleToList(costumes: (String, String)): List[String] = {
    costumes match {
      case (a, b) => List(a, b)
    }
  }

  def findCostumePartner(costumeA: String): String = {
    val costumePair =
      costumes.find(x => fromTupleToList(x).contains(costumeA)).get
    println("costumePair= " + costumePair)
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

  def extractCostumeToken(token: String): Option[String] = {
    token.split("-", 2) match {
      case Array(_, rest) if rest.nonEmpty => Some(rest)
      case _                               => None
    }
  }

  def extractKey(token: String): Option[String] = {
    println(s"token: $token")
    token.split("-", 2) match {
      case Array(head, _) => Some(head)
      case _              => None
    }
  }

  def decryptWhatsappLink(
      whatsappLink: String,
      token: String
  ): Option[String] = {
    val key = extractKey(token)
    println(s"key: $key")
    key.flatMap(AESUtil.decryptAES(whatsappLink, _))
  }
}
