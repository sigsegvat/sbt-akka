package at.segv.akka.bootstrap

import akka.actor.{Props, Actor}
import akka.actor.Actor.Receive


class EchoActor  extends Actor{

  override  def receive = {

    case s:String => sender ! "echo: "+s
  }



}

object EchoActor {
  def props = Props(new EchoActor)
}
