import scala.collection.mutable
import scala.util.Random

case class Guest(
    name: String,
    token: String,
    sha256: String,
    host: List[String]
)

val guests: List[Guest] = List[Guest](
  Guest(
    "Antoine",
    "foo-bar",
    "1233999",
    List("B")
  )
)

val families = List(
  "oiseaux",
  "poissons",
  "rayures",
  "couleurs",
  "formes_geometriques",
  "paillettes",
  "legumes",
  "fleurs",
  "felins"
)
val numberOfFamilies = families.size

val buckets = Vector.fill(numberOfFamilies)(mutable.ArrayBuffer[Guest]())

def mostMissingFromBucket(bucket: mutable.ArrayBuffer[Guest]): List[String] = {
  val counts = mutable.HashMap[String, Int]() // [(F,5), (B,3), (T,4)]
  counts("F") = 0
  counts("B") = 0
  counts("T") = 0
  bucket.foreach { guest =>
    guest.host.foreach { host =>
      counts(host) = counts(host) + 1
    }
  }
  val l = counts.toList.sortBy { case (host, count) => count }
  return l.map { case (host, _) => host }
}

def guestOfType(guests: Iterable[Guest], hosts: List[String]): Guest = {
  for (host <- hosts) {
    guests.find(guest => guest.host.contains(host)) match {
      case Some(guest) => return guest
      case None        => ()
    }
  }
  guests.head
}

def fillBuckets(guests: List[Guest]) = {
  val availableListOfGuests = collection.mutable.ArrayBuffer[Guest]()
  availableListOfGuests ++= Random.shuffle(guests)
  var bucketIndex: Int = 0

  while (availableListOfGuests.nonEmpty) {
    val bucket = buckets(bucketIndex)
    val guest =
      guestOfType(
        availableListOfGuests,
        mostMissingFromBucket(bucket)
      )
    bucket += guest
    availableListOfGuests -= guest
    bucketIndex = (bucketIndex + 1) % buckets.size
  }
}

case class GuestAndFamily(
    name: String,
    sha256: String,
    family: String,
    familySize: Int
)

def mapBucketToFamily(
    buckets: Vector[mutable.ArrayBuffer[Guest]],
    families: List[String]
): Vector[GuestAndFamily] = {
  buckets.zip(families).flatMap { case (bucket, family) =>
    bucket.map(guest =>
      GuestAndFamily(guest.sha256, guest.name, family, bucket.size)
    )
  }
}

buckets(0) += guests(0)
// println(mostMissingFromBucket(buckets(0)))
// println(guestOfType(guests, "U"))

fillBuckets(guests)
// buckets.foreach { bucket =>
//   println(bucket.sortBy(_.host.toString).mkString("\n"))
//   println()
// }
val familiesGuest = mapBucketToFamily(buckets, families)

println(familiesGuest.mkString("\n"))
