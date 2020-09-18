package BehaviouralPatterns;

import java.util.ArrayList;
import java.util.List;

public class ObserverDemo {
    public static void main(String[] args) {
        Subject ch = new Channel("JavaBrains");
        Observer obs1 = new User("Chiranjeevi");
        Observer obs2 = new User("Pawan");

        ch.subscribe(obs1);
        ch.subscribe(obs2);
        ch.notifySubs();

        ch.unsubscribe(obs2);
        ch.notifySubs();
    }
}


interface Subject{
    void subscribe(Observer obs);
    void unsubscribe(Observer obs);
    void notifySubs();
}

interface Observer{
    void notifyMe(String channel);
}

class Channel implements Subject{

    private String channelName;
    private List<Observer> mySubs = new ArrayList<>();

    public Channel(String channelName) {
        this.channelName = channelName;
    }

    @Override
    public void subscribe(Observer obs) {
        mySubs.add(obs);
    }

    @Override
    public void unsubscribe(Observer obs) {
        mySubs.remove(obs);
    }

    @Override
    public void notifySubs() {
        mySubs.forEach( o -> o.notifyMe(channelName));
    }
}

class User implements Observer{

    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void notifyMe(String channel) {
        System.out.println("Hey "+name+", you have a notification from "+channel);
    }
}