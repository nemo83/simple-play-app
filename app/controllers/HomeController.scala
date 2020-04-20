package controllers

import javax.inject._
import org.joda.time.DateTime
import play.api._
import play.api.mvc._
import sun.misc.{Signal, SignalHandler}

@Singleton
class HomeController @Inject() extends InjectedController {

  private val Log = Logger(classOf[HomeController])

  var flag = true

  def index() = Action {
    Log.info(s"Home Controller invoked ${DateTime.now()}")
    if (flag) {
      Ok
    } else {
      Forbidden
    }
  }

  Signal.handle(new Signal("TERM"), new SignalHandler {
    override def handle(signal: Signal): Unit = {
      flag = false
      Log.info(s"Received $signal")
    }
  })

}
