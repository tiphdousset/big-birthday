package anniversaire
import outwatch.dom._
import outwatch.dom.dsl._
import monix.execution.Scheduler.Implicits.global
import rx._
import util._

object Fun{
   val fun_gif = div(iframe( src := "https://giphy.com/embed/1fkAH3zEgJ6hwZFSp5" ,
                            attr("width") := "480",
                            attr("height") := "360",
                            attr("frame-border") := "0",
                            cls := "giphy-embed",
                            borderWidth := "0",
                            margin := "0 auto",
                            display := "block",
                            marginTop := "50px",
                          ) )

   def go_back_button(page: Var[String]) = button(id := "go_back_button",
                               "please bring me back home", 
                               cursor := "pointer",onClick("start") --> page)


  def fun(page: Var[String]) = div(justifyContent.center, alignItems.center,fontSize := "50px", fun_gif, go_back_button(page))

}


//youHadOneJob: "https://giphy.com/embed/3ohhwtpFc1WwxlVXfa"
//youFailed: "1fkAH3zEgJ6hwZFSp5" 


