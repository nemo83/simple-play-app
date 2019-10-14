package controllers

import javax.inject._
import kamon.Kamon
import org.joda.time.DateTime
import play.api._
import play.api.mvc._

@Singleton
class HomeController @Inject() extends InjectedController {

  private val Log = Logger(classOf[HomeController])

  def index() = Action {
    Log.info(s"Home Controller invoked ${DateTime.now()}")
    Kamon.counter("my_counter").withoutTags().increment()
    Ok
  }
}
