
package at.segv.akka.bootstrap

import akka.actor.ActorSystem
import akka.testkit._
import at.segv.play.broker.api.{PutOrder, Tick}
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}


class BrokerActorSpec(_system: ActorSystem) extends TestKit(_system) with ImplicitSender
with WordSpecLike with Matchers with BeforeAndAfterAll {

  def this() = this(ActorSystem("MySpec"))

  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }


  "BrokerActor" must {
        "always send PutOrder on Tick" in {
          val actorRef = TestActorRef(BrokerActor.props("test"))
          actorRef ! Tick(1,1,1,1)
          expectMsg(PutOrder(1))

        }
    }


}

