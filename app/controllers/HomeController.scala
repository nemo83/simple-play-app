package controllers

import javax.inject._
import org.joda.time.DateTime
import play.api._
import play.api.mvc._

@Singleton
class HomeController @Inject() extends InjectedController {

  private val Log = Logger(classOf[HomeController])

  def index() = Action {
    Log.info(s"Home Controller invoked ${DateTime.now()}")
    Ok
  }
}
