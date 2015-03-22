package at.segv.akka.bootstrap

import akka.actor.{Props, Actor}
import akka.actor.Actor.Receive
import at.segv.play.broker.api.{PutOrder, Tick}


class BrokerActor(name:String)  extends Actor{

  override  def receive = {
    case s:Tick => sender ! PutOrder(1)
  }



}

object BrokerActor {
  def props(name:String) = Props(new BrokerActor(name))
}
