package at.segv.akka.bootstrap

import java.io.{BufferedReader}
import java.util.logging.Logger


import akka.actor.{ActorRef, ActorSystem}
import akka.pattern.ask
import scala.util.{Failure, Success}
import akka.util.Timeout
import scala.concurrent.{ExecutionContext}
import scala.concurrent.duration._
import org.slf4j.LoggerFactory

object Main {

  def logger =  LoggerFactory.getLogger(Main.getClass)


  def main(args: Array[String]) = {

    val system = ActorSystem("botnet")
    val actor: ActorRef = system.actorOf(BrokerActor.props(args(0), args(1)),"BrokerActor")

    logger.info(actor.toString())




    def inputLoop(reader:BufferedReader):Unit = {
      reader.readLine() match {
        case "exit" => system.shutdown()
      }
    }

    inputLoop(io.Source.stdin.bufferedReader())


  }
}
