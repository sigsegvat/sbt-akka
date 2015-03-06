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
    val actor: ActorRef = system.actorOf(EchoActor.props,"EchoActor")

    logger.info(actor.toString())

    def askEcho(ref: String) = {
      implicit val ec = ExecutionContext.global
      implicit val timeout = Timeout(2 seconds)

      system.actorSelection(ref) ? "hello" onComplete {
        case Success(s: String) => logger.info(s)
        case Failure(f) => logger.info("failed to receive: " + f)
      }

    }


    def inputLoop(reader:BufferedReader):Unit = {
      reader.readLine() match {
        case "exit" => {
          system.shutdown()
        }
        case input: String => {
          askEcho(input)
          inputLoop(reader)
        }
      }
    }

    inputLoop(io.Source.stdin.bufferedReader())


  }
}
