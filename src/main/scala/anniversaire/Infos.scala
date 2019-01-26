package anniversaire

import outwatch.dom._
import outwatch.dom.dsl._
import monix.execution.Scheduler.Implicits.global
import rx._
import util._

object Infos{

  def info(language : Var[Translation])(implicit ctx : Ctx.Owner) = div(
    Rx{
      language().menu_info
    },
    fontSize := "16px", 
    whiteSpace := "pre-line")
}

