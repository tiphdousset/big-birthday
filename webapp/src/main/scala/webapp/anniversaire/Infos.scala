package anniversaire

import outwatch._
import outwatch.dsl._
import colibri._

object Infos {

  def info(language: Observable[Translation]) =
    div(language.map(
          _.menu_info
        ),
        fontSize := "16px",
        whiteSpace := "pre-line")
}
