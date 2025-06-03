package anniversaire.resources

case class GuestAndFamily(
    sha256: String,
    name: String,
    family: String,
    familySize: Int
)

object GuestsAndFamilies2025 {
  // Set of valid guest names from GuestsSaturdayAll.sc (local file)
  private val validGuestNames = Set(
    "Lilie",
    "VincentLetelier",
    "Maxou",
    "Mitri",
    "Dédé",
    "Juliette",
    "Lulu",
    "Robin",
    "Nono",
    "Audrey",
    "Felix",
    "ManonMartins",
    "Coco",
    "Raph",
    "FloCreutin",
    "GuiF",
    "Arne",
    "Michael",
    "Darya",
    "Hans",
    "SebDec",
    "JulieBoulanger",
    "Clemi",
    "Gaelle",
    "PierreLuc",
    "Emeline",
    "Gaux",
    "CaroleLeGall",
    "Theo",
    "FloChevalier",
    "AlexNevski",
    "Julius",
    "Eva",
    "Isa",
    "Jerem",
    "Thomas",
    "Saena",
    "Mayou",
    "AlexRaud",
    "Mamat",
    "LiliZapater",
    "Claire",
    "BaptisteFanch",
    "ArthurCreff",
    "Gégé",
    "Barbie",
    "Laure",
    "Hugo",
    "Manon",
    "Katie",
    "Smitty",
    "Winnie",
    "AlexFanch",
    "Damien",
    "Maud",
    "Remi",
    "Dona",
    "Dona+1",
    "MarieFanch",
    "MargauxFanch",
    "Cecile",
    "Chandra",
    "Youri",
    "Yoan",
    "VincentBéné",
    "Valentine",
    "Nagi",
    "MarionSev",
    "MarineGuignebert",
    "MarieGermain",
    "LucasPonton",
    "LucasCombret",
    "LouiseGuerin",
    "JulienNaud",
    "FloGourdon",
    "Ferid",
    "Elsa",
    "Denis",
    "Dekel",
    "Caro",
    "Antoine",
    "Cycy",
    "Guillaume(Darya+1)",
    "Katrin",
    "Kieren",
    "Jasmine"
  )

  // Verify no valid names are missing and no duplicates exist
  private def verifyGuestNames(
      guests: List[GuestAndFamily]
  ): (Set[String], Set[String]) = {
    val guestNames = guests.map(_.name)
    println(
      s"[DEBUG] Checking for duplicates in guestsAndFamilies list (${guestNames.size} names)"
    )

    val missingNames = validGuestNames.filter(!guestNames.toSet.contains(_))
    val duplicates = guestNames.groupBy(identity).filter(_._2.size > 1).keySet

    if (duplicates.nonEmpty) {
      println(
        s"[DEBUG] Found duplicates in guestsAndFamilies: ${duplicates.mkString(", ")}"
      )
    }

    (missingNames, duplicates)
  }

  private def verifyFamilySizeConsistency(
      guests: List[GuestAndFamily]
  ): Map[String, List[GuestAndFamily]] = {
    println(
      s"[DEBUG] Checking for family size consistency in guestsAndFamilies list (${guests.size} guests)"
    )
    guests
      .groupBy(_.family)
      .filter { case (_, familyMembers) =>
        familyMembers.map(_.familySize).distinct.size > 1
      }
  }

  private def verifyFamilySizeMatchesMemberCount(
      guests: List[GuestAndFamily]
  ): Map[String, (Int, Int)] = {
    println(
      s"[DEBUG] Checking for family size matching member count in guestsAndFamilies list (${guests.size} guests)"
    )
    guests
      .groupBy(_.family)
      .map { case (familyName, familyMembers) =>
        val recordedFamilySize =
          familyMembers.head.familySize // Assuming consistency is already checked
        val actualMemberCount = familyMembers.size
        (familyName, recordedFamilySize, actualMemberCount)
      }
      .filter { case (_, recordedFamilySize, actualMemberCount) =>
        recordedFamilySize != actualMemberCount
      }
      .map { case (familyName, recordedFamilySize, actualMemberCount) =>
        familyName -> (recordedFamilySize, actualMemberCount)
      }
      .toMap
  }

  private def verifySumOfFamilySizesMatchesTotalGuests(
      guests: List[GuestAndFamily]
  ): Option[(Int, Int)] = {
    println(
      s"[DEBUG] Checking if sum of family sizes matches total guest count (${guests.size} guests)"
    )
    val sumOfDeclaredFamilySizes = guests
      .groupBy(_.family)
      .map {
        case (_, familyMembers) if familyMembers.nonEmpty =>
          familyMembers.head.familySize // Relies on familySize being consistent within the family
        case _ =>
          0 // Should not happen with valid data where families have members
      }
      .sum

    val totalActualGuests = guests.size

    if (sumOfDeclaredFamilySizes != totalActualGuests) {
      Some((sumOfDeclaredFamilySizes, totalActualGuests))
    } else {
      None
    }
  }

  val guestsAndFamilies = List(
    GuestAndFamily(
      "b1d9e50519508291d49ee320ac6a33cd67929be84cafc710a9cfd8aee239d6f0",
      "Lilie",
      "oiseaux",
      10
    ),
    GuestAndFamily(
      "5c09df14701aac702ddbc939a2f7fdd01af767aec5168dad035a1ccf821305ba",
      "Lulu",
      "oiseaux",
      10
    ),
    GuestAndFamily(
      "1e1020ad0f29875f8181a9c82dc4ae692a59172401fb48c631ff3cce96ebf223",
      "Nagi",
      "oiseaux",
      10
    ),
    GuestAndFamily(
      "da8633cbde4bc6fee40afaa6e5c241e65d0fce53a84b4e9a87fce92fb209bfb3",
      "Saena",
      "oiseaux",
      10
    ),
    GuestAndFamily(
      "96f03edf56cf0aff6df527b62e0b0bd0415c99ca0431a4041eea78f13414cf8b",
      "Youri",
      "oiseaux",
      10
    ),
    GuestAndFamily(
      "46814677a64084f950674427403b1b75edd35bfa5e054257c75882be75f9396a",
      "Michael",
      "oiseaux",
      10
    ),
    GuestAndFamily(
      "9c9d169f27df283e22dc7eb76204b22ceae31ed0310726d89042e53466441f35",
      "Maud",
      "oiseaux",
      10
    ),
    GuestAndFamily(
      "4af364df9324189595d122819da6848934d6b0683a596c3e51f95b1cd6c33911",
      "MarineGuignebert",
      "oiseaux",
      10
    ),
    GuestAndFamily(
      "fd31311b1bf2a310490a68748dbd9c9928124ea312c8db3f9f7ef348c04a5b0a",
      "Winnie",
      "oiseaux",
      10
    ),
    GuestAndFamily(
      "d63c5f90045e95af64d3d0638d07e7e31491d815244d48b55becea80e4467333",
      "ArthurCreff",
      "oiseaux",
      10
    ),
    GuestAndFamily(
      "ffc20895548b27ba476fbc6031318389ecdc612eff265fdd7d3040f0ccef1cdd",
      "VincentBéné",
      "poissons",
      10
    ),
    GuestAndFamily(
      "0e6793a4f149cb0fa2a00bf451e9ed904ebe49cd5739f25b3c57c04678a03913",
      "FloCreutin",
      "poissons",
      10
    ),
    GuestAndFamily(
      "e8f0758b1eccbb7e04d4d1e04997d9b0cf0ba07889a88c2ff4f69281b782e199",
      "LiliZapater",
      "poissons",
      10
    ),
    GuestAndFamily(
      "127522106ecadb86a2b8a19550a2ffa57a6cac7bf8560b91c0c2cf67c234d492",
      "Maxou",
      "poissons",
      10
    ),
    GuestAndFamily(
      "dfb47b9bb19c3c42f8974dec944bf182f01fd74e1d3a41a0569e5d15b7307070",
      "VincentLetelier",
      "poissons",
      10
    ),
    GuestAndFamily(
      "0f39e8eef77e7216b01de2a1f5a4b4c7fbcf1e681d4262978fd7d659085bd79b",
      "Mitri",
      "poissons",
      10
    ),
    GuestAndFamily(
      "6420c905b58f8f5006559d05da85f3067e017bf824c996dc403575b36f18b47a",
      "Coco",
      "poissons",
      10
    ),
    GuestAndFamily(
      "17e62e949ba07aeff70c8dbfc7c372c620430df344b9419f29620ec5aee3095f",
      "Gaux",
      "poissons",
      10
    ),
    GuestAndFamily(
      "276079e1ef7f5460b7070229641da62c8c2553c0469c8c9aeb391bc7ac7c07ff",
      "Laure",
      "poissons",
      10
    ),
    GuestAndFamily(
      "770fb63fea2da9d03ee4e7157264de5bc7822be76b39ec1a8808107f3893d55a",
      "Guillaume(Darya+1)",
      "poissons",
      10
    ),
    GuestAndFamily(
      "7e859959b4257572431c18c36fd9185381713edaa91a25d66598f6b997e19d19",
      "Ferid",
      "rayures",
      10
    ),
    GuestAndFamily(
      "b0456f685ad2611ed39900bfd608f5917e59727007210ed92982f6d6559825c2",
      "JulieBoulanger",
      "rayures",
      10
    ),
    GuestAndFamily(
      "950cc41e005825ba7c834301c781a50c55488085298d37211ee8eeb2fdeddbdc",
      "Remi",
      "rayures",
      10
    ),
    GuestAndFamily(
      "6ac09d08ef5f761f120054d15a3ebb9c2778cdb734d46899296dd2d5cb3b1615",
      "Yoan",
      "rayures",
      10
    ),
    GuestAndFamily(
      "9110cc9ab5814dfaa4b42c6b4b44a29ac95ea6bf169b1dfc838b00b5c7f61c95",
      "Hans",
      "rayures",
      10
    ),
    GuestAndFamily(
      "39d489a3c03081758bb673f2c8376bd847ce05fe0cd015fe7ea7745c223dc136",
      "Barbie",
      "rayures",
      10
    ),
    GuestAndFamily(
      "bd46552e90bd75c4fb9996db4ccc6583ccf330d5bf6c019b5d3fda780b98aee7",
      "MarionSev",
      "rayures",
      10
    ),
    GuestAndFamily(
      "7b64cb08943b300fd61ed17b954d4ba59a4a3a034898c2c911b41a7cbe3929a0",
      "Gaelle",
      "rayures",
      10
    ),
    GuestAndFamily(
      "1d7423b7c92ee563827bdba024b80dbbd95f11e1c4d1eec016ceffbaef6db913",
      "LouiseGuerin",
      "rayures",
      10
    ),
    GuestAndFamily(
      "27d7397bab8b00c04af768831257e607d3d63aec4ecac912cc77b78be1938d51",
      "Jasmine",
      "rayures",
      10
    ),
    GuestAndFamily(
      "0ed3dace4134e9c806f06406545ab6203ce2a38fa6e9e59993a9d875231677dc",
      "Dekel",
      "couleurs",
      9
    ),
    GuestAndFamily(
      "eceb18fc9e38cadbcec6ede1493e80a93f90fb72885a4b2d6992ff95b79378c9",
      "CaroleLeGall",
      "couleurs",
      9
    ),
    GuestAndFamily(
      "cd4f17cfb5c5abfbf2f48201dd5b381ee97cf2e5a03cf6326fedc20942b56299",
      "Mamat",
      "couleurs",
      9
    ),
    GuestAndFamily(
      "9836d3f939878cdeb7c93068b92e1661546af4d72578de6d8b8b354b1c341d4a",
      "PierreLuc",
      "couleurs",
      9
    ),
    GuestAndFamily(
      "d29357f5440bee5c300b657e04d379d711c828044ad47130deb8efce6a66f22f",
      "Juliette",
      "couleurs",
      9
    ),
    GuestAndFamily(
      "6ef251e2dc410fe9a667da54a21c6d2f085313396187535841d041c33def6d3b",
      "Clemi",
      "couleurs",
      9
    ),
    GuestAndFamily(
      "d38747e5f8f29b9e0c48a6a38e3728fc8b66e68c1b499c1a2c8e6e5257a9914b",
      "Manon",
      "couleurs",
      9
    ),
    GuestAndFamily(
      "de4de5f2490abeac1357b76f3de6b0d15c87f57e1dfbc56621967bca5a02c420",
      "MarieFanch",
      "couleurs",
      9
    ),
    GuestAndFamily(
      "a3cae5c51183112ae82b77219f4b07b21db025fab3428b2d0a20e0a00c42d9fb",
      "Theo",
      "couleurs",
      9
    ),
    GuestAndFamily(
      "a7cee4b7c45a94f693e7c6698ff2e6bb3ac16dc1d9d0ed4ca1eb96fc012497db",
      "JulienNaud",
      "formes_geometriques",
      9
    ),
    GuestAndFamily(
      "7baaf6473aab8728a0140cf0d4d6c3bfa5f9cecf868c8500bef023e49341ab9c",
      "Robin",
      "formes_geometriques",
      9
    ),
    GuestAndFamily(
      "13f04ccab2f9015cde8176c8487b735d73225694370f3fba87684f73d74ded84",
      "AlexFanch",
      "formes_geometriques",
      9
    ),
    GuestAndFamily(
      "44e927c0e546a4deeb9bd7bde86409b79ec44a6135e3013cfa99e9a896e03403",
      "Valentine",
      "formes_geometriques",
      9
    ),
    GuestAndFamily(
      "67bae8ec681a30fea615a74ebd759cac36c7da990832c760539ddf8d6306a0a0",
      "Julius",
      "formes_geometriques",
      9
    ),
    GuestAndFamily(
      "53cf9f18365234fe98b346d5e12ac78b94eadc7c694a64bd0529e3c6b2802269",
      "Jerem",
      "formes_geometriques",
      9
    ),
    GuestAndFamily(
      "ed5634b345039ffce1006c8190520ec096ec4f02784b4343f0c9bded2fd408e5",
      "BaptisteFanch",
      "formes_geometriques",
      9
    ),
    GuestAndFamily(
      "4573109672500a400d55842474aec85cbd878ca38e6da79c3ebbb9c9eceae5a2",
      "Darya",
      "formes_geometriques",
      9
    ),
    GuestAndFamily(
      "20126e28e1c5927ce92f32ab853b146b8ce3a69e4e1ab8496a4d1f9df4e1bb66",
      "Dona",
      "formes_geometriques",
      9
    ),
    GuestAndFamily(
      "5a7749b70464747ea46a61d12df45bc1b6ac7b1646001a4bed5530c825eafd3e",
      "FloGourdon",
      "paillettes",
      10
    ),
    GuestAndFamily(
      "cfc5c26267a2a44c5283b15dc2932b17ac667256374deb1365de4e8fc1fd3056",
      "ManonMartins",
      "paillettes",
      10
    ),
    GuestAndFamily(
      "24598bf32a8fc28dda270baec690e51b4a0fe03a6a45fbe4284fcc87e43fa43c",
      "Cecile",
      "paillettes",
      10
    ),
    GuestAndFamily(
      "956a3f04ca199d1e49534c53d1f73be201d4311bfc7647e08ddd876dd25bf7c0",
      "Elsa",
      "paillettes",
      10
    ),
    GuestAndFamily(
      "747d2ed0d5e6e19f9fc4b7379c35a1e06a7e1df64b6027a6b1c73b913f9aecac",
      "Raph",
      "paillettes",
      10
    ),
    GuestAndFamily(
      "9be84c692209bf2234f88a42fca1f0970c03babb5a152dac0b1a2dff66e80081",
      "AlexRaud",
      "paillettes",
      10
    ),
    GuestAndFamily(
      "5e27e1235c559d95d46dbef8f46eb8b26ca831fe8ff2c7da81a566b8c4df7d55",
      "LucasPonton",
      "paillettes",
      10
    ),
    GuestAndFamily(
      "e419bb25c3581ada514ee7cb8339a61c22e2f669f37813a3a073432eaf0eb33a",
      "Emeline",
      "paillettes",
      10
    ),
    GuestAndFamily(
      "a75c1a27b76e88a3a7635c5588efad63d316cd073cac221ba2964720245eeeb0",
      "Gégé",
      "paillettes",
      10
    ),
    GuestAndFamily(
      "fa079780d5242affbd1cc59ac5bae437fda2268dd1c665c61bac349571569e1b",
      "Kieren",
      "paillettes",
      10
    ),
    GuestAndFamily(
      "1f25b7c9726c897ab4534660457ad33474932c9fe3114861d21cdb84ee2df4dc",
      "Katrin",
      "legumes",
      10
    ),
    GuestAndFamily(
      "1a9c4c13e305eaa5e799912867904da6c226b2d8624fea3a9b76f78ea7c20d2f",
      "Caro",
      "legumes",
      10
    ),
    GuestAndFamily(
      "9e97766a8b1ebd109c475ac4dcadaed9d091b5ba13c273f68367181e1515e713",
      "FloChevalier",
      "legumes",
      10
    ),
    GuestAndFamily(
      "4543756da7045e27738d04fc0f79fd539eca1ed5270f7ffa35c2cad44fab79dc",
      "AlexNevski",
      "legumes",
      10
    ),
    GuestAndFamily(
      "0f60fa43b6bbea38b55be9c5950e5dcbf9887cec61e30284c997410f3705f911",
      "Nono",
      "legumes",
      10
    ),
    GuestAndFamily(
      "f66ed0360002e0ffc595f6a63d146e7345421075a7ade2a08699f56bfc41cd66",
      "MarieGermain",
      "legumes",
      10
    ),
    GuestAndFamily(
      "77d5d9d7da8a16a4e3fc9cfe8689e259e39d4f500c7a565a6a70f5972fb6c9dc",
      "SebDec",
      "legumes",
      10
    ),
    GuestAndFamily(
      "04a29c68ba8239ec711f5c56b34e0980873238211b0fed3806aacbacd353a750",
      "Mayou",
      "legumes",
      10
    ),
    GuestAndFamily(
      "7cb483894f46ed4f88fcbacc6e59f007cd76d9317e48e9d93d456fd87eec8a4e",
      "Chandra",
      "legumes",
      10
    ),
    GuestAndFamily(
      "b3bc0aeb88197dcf3e307f6172761488c1dfca7776ce72ba4175825dc42fd6df",
      "MargauxFanch",
      "legumes",
      10
    ),
    GuestAndFamily(
      "ad182135c5442f866084550c024a441a851ed8d4d67ef48f8d8faaae706441c6",
      "LucasCombret",
      "fleurs",
      9
    ),
    GuestAndFamily(
      "3b455c223d360305f8f9b304bbd6315a14c79e4e7c22424e555dede537c88e69",
      "Eva",
      "fleurs",
      9
    ),
    GuestAndFamily(
      "6e71addc2cf6b99849778fe1ecd914016afa42beecdab3f84de23dbaaaf183d8",
      "Audrey",
      "fleurs",
      9
    ),
    GuestAndFamily(
      "79db1912ea97391804077e9e468f4ded395775cb6d4d0bca639baf5bbf7f39da",
      "Hugo",
      "fleurs",
      9
    ),
    GuestAndFamily(
      "b208f0306edb8a37e63607a27dfbc1be52e20c518983f390cc22679676b7c769",
      "Antoine",
      "fleurs",
      9
    ),
    GuestAndFamily(
      "1a5379e401671fe316f35b9180e5c0dc15e9a575b989f22946955964a02787ad",
      "Arne",
      "fleurs",
      9
    ),
    GuestAndFamily(
      "4082aaca2ecf5a19ec06137c8cca48df0adb6c244b62688266e34ebeeffad5d1",
      "Katie",
      "fleurs",
      9
    ),
    GuestAndFamily(
      "c99232be895fbe3b7e7896c9d0c1dfdebd9965e70c2b2167459fac5a91053ed9",
      "Thomas",
      "fleurs",
      9
    ),
    GuestAndFamily(
      "49b481ae45d411b88c4efbe8438c02adf6b718ed4d55322f2f894640d7cdc454",
      "Dona+1",
      "fleurs",
      9
    ),
    GuestAndFamily(
      "eea99735f7ecf81c3484298514c3bb57326a5a1ec95a75de9498cc5bdee7284a",
      "Denis",
      "felins",
      9
    ),
    GuestAndFamily(
      "3865ce8871d4003da0f48d1ef4b556373e8ed353ab474778a26948e3866a16c0",
      "Isa",
      "felins",
      9
    ),
    GuestAndFamily(
      "4bcf2ab8b07cb32b399ed5cff96dfe415fccdb3d32ef3a999c17bfc08f297672",
      "Dédé",
      "felins",
      9
    ),
    GuestAndFamily(
      "2cc770a1d8049e58dd014702af30f74a94a5c5c97471d8aba22dda3f40ec6e2c",
      "Cycy",
      "felins",
      9
    ),
    GuestAndFamily(
      "1582523c0a8193950b4e5a7cb9704cae395c95ce00a4f2c8d54fb1d9da19bb12",
      "Felix",
      "felins",
      9
    ),
    GuestAndFamily(
      "4417cbd3b7c1ea5440dedcd67c909f39aad46c2314c4476b3a7435e513055b16",
      "Damien",
      "felins",
      9
    ),
    GuestAndFamily(
      "e33a3b615e136d8336927edf53cea2ec0da90e5a091fc2efd7a2210c9b739abe",
      "Smitty",
      "felins",
      9
    ),
    GuestAndFamily(
      "da5210f9ecbc35b0c07003c1cec082d359544eccbee659ef31e356fb62f111e2",
      "Claire",
      "felins",
      9
    ),
    GuestAndFamily(
      "8f1357a4c522a488977e95bbdd66ccacbf5c0d8c659f2482b86029deced8cf9d",
      "GuiF",
      "felins",
      9
    )
  )

//   // Verify all guest names at initialization
//   val (missing, duplicates) = verifyGuestNames(guestsAndFamilies)
//   val familySizeInconsistencies = verifyFamilySizeConsistency(guestsAndFamilies)
//   val familyMemberCountMismatches = verifyFamilySizeMatchesMemberCount(
//     guestsAndFamilies
//   )
//   val sumOfFamilySizesMismatch = verifySumOfFamilySizesMatchesTotalGuests(
//     guestsAndFamilies
//   )

//   def main(args: Array[String]): Unit = {
//     if (missing.nonEmpty) {
//       println(s"Missing guest names: ${missing.mkString(", ")}")
//     }

//     if (duplicates.nonEmpty) {
//       println(s"Duplicate guest names: ${duplicates.mkString(", ")}")
//     }

//     if (familySizeInconsistencies.nonEmpty) {
//       println(
//         "Family size internal inconsistencies found (different familySize values within the same family):"
//       )
//       familySizeInconsistencies.foreach { case (family, members) =>
//         println(s"  Family '$family':")
//         members.foreach(member =>
//           println(s"    ${member.name} - familySize: ${member.familySize}")
//         )
//       }
//     }

//     if (familyMemberCountMismatches.nonEmpty) {
//       println("Family size does not match actual member count for:")
//       familyMemberCountMismatches.foreach {
//         case (family, (recordedSize, actualCount)) =>
//           println(
//             s"  Family '$family': Recorded size $recordedSize, Actual member count $actualCount"
//           )
//       }
//     }

//     sumOfFamilySizesMismatch.foreach { case (sumDeclared, actualTotal) =>
//       println(
//         s"Mismatch: Sum of declared family sizes ($sumDeclared) does not equal total actual guests ($actualTotal)."
//       )
//     }

//     if (
//       missing.isEmpty && duplicates.isEmpty && familySizeInconsistencies.isEmpty && familyMemberCountMismatches.isEmpty && sumOfFamilySizesMismatch.isEmpty
//     ) {
//       println(
//         "All guest names are present, no duplicates, family sizes are consistent, family sizes match member counts, and sum of family sizes matches total guests!"
//       )
//     }
//   }
}
