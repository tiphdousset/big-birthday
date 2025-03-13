package anniversaire

import org.scalatest._
import org.scalajs.dom._

abstract class JSDomSpec extends FlatSpec with Matchers with BeforeAndAfterEach {

  implicit val scheduler = TrampolineScheduler(Scheduler.global, SynchronousExecution)

  override def beforeEach(): Unit = {

    document.body.innerHTML = ""

    // prepare body with <div id="app"></div>
    val root = document.createElement("div")
    root.id = "app"
    document.body.appendChild(root)
    ()
  }
}
