package anniversaire.resources

object GuestsAndCostumes {
  val listGuests: List[((String, String), (String, String))] = List(
    (("glescornet@gmail.com","Jesus"),("sml.vgr@gmail.com","Marie")),
  (("quentinburban@laposte.net","Astérix"),("Germain.marie@live.fr","Obélix")),
  (("marionmetivier86@gmail.com","César"),("Clemensbuschhoff@gmail.com","Brutus")),
  (("mattattoo79@yahoo.de","Gomez Addams"),("laure.chabrolle@gmail.com","Morticia Addamas")),
  (("kris.neugebauer@googlemail.com","Jasmine"),("lamberti.julien@gmail.com","Aladdin")),
  (("theotime.tetu@gmail.com","Titi"),("till.wohlfarth@faszinationeinrad.com","Gros minet")),
  (("Elodie.thines@gmail.com","Mitch"),("Gwenaelle.jolygj@gmail.com","Pamela")),
  (("caro_chevalier@hotmail.fr","Eve"),("Quentin.fabulet@gmail.com","Adam")),
  (("juliette.laurence@gmail.com","Roméo"),("boulanger.juli@gmail.com","Juliette")),
  (("hug.burban@gmail.com","Luigi"),("felixdietze@gmail.com","Mario")),
  (("Quentin.dumont59@gmail.com","Popeye"),("creff.arthur@gmail.com","La femme de popeye")),
  (("mgx.barbier@gmail.com","Superman"),("noelie.merlet@hotmail.fr","Superwoman")),
  (("raphael.colleau@gmail.com","118"),("Maiw.cadoret@gmail.com","218")),
  (("guillaume.axel.francois@hotmail.com","Cruella"),("alexraud@hotmail.com","Un dalmatien")),
  (("gregoireroux69@gmail.com","Ou est charlie"),("lindsay.kibuey@gmail.com","Charlène")),
  (("sandra.vagao@gmail.com","Rose (titanic)"),("Theophile.moreau@gmail.com","Jack (titanic)")),
  (("Heygreg@hotmail.fr","Shrek"),("choutet.isabelle@gmail.com","La princesse de Shrek")),
  (("rousselot.marie@orange.fr","Ketchup"),("boris.beillevaire@gmail.com","Mayo")),
  (("yannick.richard@hotmail.fr","Le bossu"),("sarah.beauvais@protonmail.com","Esmeralda")),
  (("Lea.reyx@yahoo.fr","Schtroumpf"),("Florence.gourdon@gmail.com","Schtroumpfette")),
  (("anais.rbt@gmail.com","Ange"),("Sayemoon@free.fr","Démon")),
  (("anais73@gmail.com","Mini"),("maxime.ezequel@laposte.net","Mickey")),
  (("aureliaguil@gmail.com","Hermione Granger"),("gourdon_denis@yahoo.fr","Harry Potter")),
  (("Matthiasrock@hotmail.fr","Tintin"),("sevmarion@hotmail.com","Milou")),
  (("stefano1.olivieri@gmail.com","Dupont"),("guerinlouise44@gmail.com","Dupont")),
  (("carole.legall89@gmail.com","Winnie"),("juliennaud@me.com","Porcinet")),
  (("ronan.laurans@laposte.net","M&M bleu"),("valentineheraud@hotmail.fr","M&M rouge")),
  (("gfrancois.mail@gmail.com","Sherlock"),("marioncle@hotmail.fr","Watson")),
  (("jjliguori@gmail.com","Le petit chaperon rouge"),("hugo.langlaisvignon@gmail.com","Le loup")),
  (("sebastien.decreme@gmail.com","Polochon"),("didi.el.zein@gmail.com","Ariel")),
  (("marie.rpch@gmail.com","Melania"),("mathias.peronne@gmail.com","Trump")),
  (("joel.mballa@gmail.com","Marge Simpson"),("champion.sophie@yahoo.com","Homer Simpson")),
  (("fabian-braun@mailbox.org","Tom"),("laulotte44@hotmail.com","Jerry")),
  (("margaux.peneau@gmail.com","Mrs Smith"),("Michel-lebourdonnec@live.fr","Mr Smith")),
  (("Florent.creutin@gmail.com","Minion"),("youri.corbineau@gmail.com","Gru")),
  (("florent.quilichini@gmail.com","Un des 7 nains"),("aurelierolland@hotmail.fr","Blanche neige")),
  (("Guillaume.chopin@neuf.fr","Luke Skywalker"),("hamon.matthieu@gmail.com","Princesse Leïa")),
  (("dimitri.fasquel@free.fr","Laurel"),("p.ganser@yahoo.de","Hardy")),
  (("letellier.avocat@laposte.net","César"),("martins.manon@gmail.com","Cléopatre")),
  (("jeanromainsignorelli@gmail.com","Batman"),("benjamin.reuche@gmail.com","Robin")),
  (("lolaalfonzo@gmail.com","Père Noel"),("eleonore.bondu@gmail.com","Mère Noël")),
  (("marine.bertucchi@gmail.com","Leeloo Dallas"),("jeremydousset@gmail.com","Korben Dallas")),
  (("g.muenkel@gmail.com","Dr Jekyll"),("lucie.rouland@gmail.com","Mr Hyde")),
  (("anthony-pacaud@laposte.net","Johnny"),("vivet.lucie@gmail.com","Bébé (dirty dancing)"))
  )
  val guestemails: Set[String] = listGuests.flatMap{
    case((email1,_), (email2,_)) => List(email1, email2)
  }.toSet
  assert((listGuests.size*2)==guestemails.size)

  val guestCostumes: Set[String] = listGuests.flatMap{
    case((_,costume1), (_,costume2)) => List(costume1, costume2)
  }.toSet
}



