package anniversaire
import rx._
import monix.execution.Cancelable
import monix.reactive.{Observable, OverflowStrategy}
import org.scalajs.dom
import outwatch.dom._
import outwatch.dom.dsl._
import util._

object Photos {

  val pictures = "http://tiph.einrad.eu/anniversaire/pictures"
  val showFullImage = Var(Option.empty[String])
  val daySelected = Var(Option.empty[String])

  def getList(day: String): Observable[Seq[String]] =
    Observable.create(OverflowStrategy.Unbounded) { observer =>
      val xhr = new dom.XMLHttpRequest()
      xhr.open("GET", s"${pictures}/${day}/getPicturesList.php")
      xhr.onload = { (e: dom.Event) =>
        if (xhr.status == 200) {
          observer.onNext(xhr.responseText.split("\n"))
        }
      }
      xhr.send()
      Cancelable(() => xhr.abort())
    }

  def getZip(day: String): String = {
    s"${pictures}/${day}/${day}.zip"
  }

  def getPic(day: String, fileName: String): String = {
    s"${pictures}/${day}/${fileName}"
  }

  def getThumb(day: String, fileName: String): String = {
    val pic = getPic(day, fileName)
    s"${pic}_thumb.jpg"
  }

  def renderFullImage(fileName: String) = div(
    backgroundImage := s"""url("$fileName")""",
    backgroundPosition := "center",
    backgroundRepeat := "no-repeat",
    backgroundSize := "contain",
    position.absolute,
    top := "0",
    left := "0",
    width := "100%",
    height := "100%",
    backgroundColor := "rgba(0,0,0,0.9)",
    onClick.foreach(showFullImage() = None)
  )
  def activeFolder(folder: String, x: VDomModifier)(implicit ctx: Ctx.Owner) =
    Rx {
      if (daySelected() == Some(folder)) {
        x
      } else {
        VDomModifier.empty
      }
    }

  def photos(language: Observable[Translation])(implicit ctx: Ctx.Owner) = div(
    div(
      marginBottom := "30px",
      div(
        div(
          cls := "picFolder",
          activeFolder("guestBook", cls := "picFolderActive"),
          language.map(_.guest_book),
          onClick.foreach(daySelected() = Some("guestBook"))
        ),
        activeFolder(
          "guestBook",
          div(
            textAlign.center,
            a("download all", cls := "downloadPic", href := getZip("guestBook"))
          )
        )
      ),
      div(
        div(
          activeFolder("duo", cls := "picFolderActive"),
          cls := "picFolder",
          language.map(_.duo),
          onClick.foreach(daySelected() = Some("duo"))
        ),
        activeFolder(
          "duo",
          div(
            textAlign.center,
            a("download all", cls := "downloadPic", href := getZip("duo"))
          )
        )
      ),
      div(
        div(
          activeFolder("appareilJetable", cls := "picFolderActive"),
          cls := "picFolder",
          language.map(_.appareil_jetable),
          onClick.foreach(daySelected() = Some("appareilJetable"))
        ),
        activeFolder(
          "appareilJetable",
          div(
            textAlign.center,
            a(
              "download all",
              cls := "downloadPic",
              href := getZip("appareilJetable")
            )
          )
        ),
      ),
      showFullImage.map(_.map(renderFullImage)),
      display.flex,
      justifyContent.center,
      alignItems.flexStart,
      fontSize := "25px",
    ),
    div(display.flex, flexWrap.wrap, justifyContent.center, Rx {
      daySelected().map { day =>
        val list = getList(day)
        list.map(l => l.map(x => showPicture(day, x)))
      }
    })
  )

  def showPicture(day: String, fileName: String): VNode = {
    img(
      src := getThumb(day, fileName),
      width := "100px",
      height := "100px",
      cursor.pointer,
      onClick.foreach(showFullImage() = Some(getPic(day, fileName)))
    )
  }
}
