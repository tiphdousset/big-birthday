package anniversaire
import outwatch.dom._
import outwatch.dom.dsl._
import monix.execution.Scheduler.Implicits.global
import rx._
import util._

object Infos{

  val info1 = div("""Hoyé hoyé !

Pour toi, cher ami.e choisis entre tous pour célébrer nos 30 ans, voici quelques informations utiles pour préparer l'événement tant attendu.

Tout d'abord la date : les festivités se dérouleront du """, b("Samedi 8 au Lundi 10 Juin"),""". Vous êtes attendus en """, b("fin d'après midi le Samedi"),""" (disons vers 17h) et nous quitterons les lieux le Lundi en fin de matinée. 

Pour le lieu, nous pouvons vous dire que ça se passe dans la """, b("magnifique bourgade de St Colomban (44)"),""", à 30 min au Sud de Nantes. La localisation précise du site vous sera communiquée d'ici là. 
Nous vous conseillons de miser sur le co-voiturage depuis Nantes, qui pourra être organisé via ce site en temps et en heure. 
Pour les non-nantais, """, b("un billet pour Nantes"),""" est à ce stade largement suffisant.

Pour le couchage, un champ sera mis à disposition pour planter """, b("les tentes"),""".  Pensez donc à prendre votre tente ;)

Si certains d'entre vous souhaitent arriver plus tôt / partir plus tard, n'hésitez pas à nous contacter afin que l'on puisse vous accueillir chez l'un d'entre nous.

Non-french speaker : keep calm and don't panic, you can ask us for more explanations or...""",
    
    fontSize := "30px", whiteSpace := "pre-line", fontFamily := "monospace")


}

