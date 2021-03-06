package slr203tp.messages;

import java.io.Serializable;
import java.util.ArrayList;
import akka.actor.ActorRef;

public class Hi implements Serializable {

    private final String message =  "Hi, friend!";
    private ArrayList<ActorRef> senders;

    public Hi() {}
    
    public Hi(ArrayList<ActorRef> senders) {
        this.senders = senders;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<ActorRef> getSenders() {
        return senders;
    }

    public void setSenders(ArrayList<ActorRef> senders) {
        this.senders = senders;
    }

}