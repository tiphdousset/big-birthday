package anniversaire

import outwatch.dom._
import outwatch.dom.dsl._
import monix.execution.Scheduler.Implicits.global
import rx._
import util._
import monix.reactive._

object Infos {

  def info(language: Observable[Translation])(implicit ctx: Ctx.Owner) =
    div(language.map(
          _.menu_info
        ),
        fontSize := "16px",
        whiteSpace := "pre-line")
}
