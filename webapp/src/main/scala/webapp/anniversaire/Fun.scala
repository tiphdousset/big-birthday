package anniversaire
import outwatch._
import outwatch.dsl._
import colibri._
import colibri.reactive._

object Fun {
  val fun_gif = div(
    iframe(
      src := "https://giphy.com/embed/1fkAH3zEgJ6hwZFSp5",
      attr("width") := "240",
      attr("height") := "180",
      attr("frame-border") := "0",
      cls := "giphy-embed",
      borderWidth := "0",
      margin := "0 auto",
      display := "block",
      marginTop := "25px",
    ))

  def go_back_button(
      page: Var[Option[String]],
      language: Observable[Translation]) =
    button(
      id := "go_back_button",
      language.map(_.menu_fun),
      cursor := "pointer",
      onClick.as(Some("start")) --> page
    )

  def fun(page: Var[Option[String]], language: Observable[Translation]) =
    div(justifyContent.center,
        alignItems.center,
        fontSize := "25px",
        fun_gif,
        go_back_button(page, language))

}
//youHadOneJob: "https://giphy.com/embed/3ohhwtpFc1WwxlVXfa"
//youFailed: "1fkAH3zEgJ6hwZFSp5"
