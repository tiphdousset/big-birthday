package anniversaire
import outwatch.dom._
import outwatch.dom.dsl._
import monix.execution.Scheduler.Implicits.global
import rx._
import util._

object Infos{

  val info1 = div("""Hoyé hoyé !

Pour toi, cher ami.e choisis entre tous pour célébrer nos 30 ans, voici quelques informations utiles pour préparer l'évènement tant attendu.

Tout d'abord la date : les festivités se dérouleront du """, b("Samedi 8 au Lundi 10 Juin"),""". Tu es attendu en """, b("fin d'après midi le Samedi"),""" (disons vers 17h) et nous quitterons les lieux le Lundi en fin de matinée. 

Pour le lieu, nous pouvons te dire que ça se passe dans la """, b("magnifique bourgade de St Colomban (44)"),""", à 30 minutes au Sud de Nantes. La localisation précise du site te sera communiquée d'ici là. 
Nous te conseillons de miser sur le co-voiturage depuis Nantes, qui pourra être organisé via ce site en temps et en heure. 
Pour les non-nantais, """, b("un billet pour Nantes"),""" est à ce stade largement suffisant.

Pour le couchage, un champ sera mis à disposition pour planter """, b("les tentes"),""".  Pense donc à prendre ta tente ;-)

Si certains d'entre vous souhaitent arriver plus tôt / partir plus tard, n'hésitez pas à nous contacter afin que l'on puisse vous accueillir chez l'un d'entre nous.

Non-french speaker : keep calm and don't panic, you can ask us for more explanations """,
a(href := "https://translate.google.de/#view=home&op=translate&sl=fr&tl=en", "or"),""" """,
    
    fontSize := "20px", whiteSpace := "pre-line", fontFamily := "montserrat")


}

