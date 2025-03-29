package anniversaire

import outwatch._
import outwatch.dsl._
import colibri._

object Infos {

  def info(
      language: Observable[Translation],
      decryptedLink: Option[String]
  ): VMod =
    language.map(l =>
      div.thunk("content rendering")(l.menu_info(decryptedLink))(
        VMod(
          fontSize := "16px",
          innerHTML := UnsafeHTML(l.menu_info(decryptedLink))
        )
      )
    )
}
