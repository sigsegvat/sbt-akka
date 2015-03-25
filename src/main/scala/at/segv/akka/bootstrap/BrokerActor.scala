package at.segv.akka.bootstrap

import akka.actor.{ActorRef, Props, Actor}
import akka.actor.Actor.Receive
import akka.event.Logging
import at.segv.play.broker.api.{Register, PutOrder, Tick}


class BrokerActor(name:String, ref:String)  extends Actor{

  val log = Logging(context.system, this)

  override  def receive = {
    case s:Tick => sender ! PutOrder(1)

  }


  override def preStart = {
    ActorRef
    context.system.actorFor(ref).tell(Register(name),self)
  }

}

object BrokerActor {
  def props(name:String, ref:String) = Props(new BrokerActor(name, ref))
}
