package slr203tp;

import akka.actor.Props;
import akka.actor.ActorRef;
import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import slr203tp.messages.Stop;
import slr203tp.messages.Message;

public class FirstActor extends UntypedAbstractActor {

    private LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    public FirstActor() {}

    public static Props createActor() {
        return Props.create(FirstActor.class, () -> {
            return new FirstActor();
        });
    }

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof Message) {
            Message m = (Message) message;
            log.info("[" + getSelf().path().name() + "] received: " + m.getMessage());
        }
        else if (message instanceof Stop) {
            getContext().stop(getSelf());
            log.info("[" + getSelf().path().name() + "] Stopped");
        }
    }

    public static void wait(int timeMillis) {
        try {
            Thread.sleep(timeMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }   
    }

}