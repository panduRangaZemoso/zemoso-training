package BehaviouralPatterns;

import java.util.ArrayList;
import java.util.List;

public class MediatorDemo {

    public static void main(String[] args) {
        Mediator atc = new ATC();

        Component flight1 = new Flight("SpiceJet-SJ123",atc);
        Component flight2 = new Flight("Indigo-IG2355",atc);
        Component flight3 = new Flight("AirIndia-AI9900",atc);


        atc.register(flight1);
        atc.register(flight2);
        atc.register(flight3);

        flight1.send(atc,"We are entering Hyderabad air space");
        System.out.println("**************");
        flight2.send(atc, "We are leaving Hyderabad air space");
        System.out.println("**************");
        flight3.send(atc, "We are running 30mins late");
    }

}

interface Mediator{
    void notify(Component component, String message);
    void register(Component component);
}

abstract class Component{

    protected String name;
    protected Mediator mediator;

    public Component(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    abstract void send(Mediator mediator, String message);
    abstract void receive(String message);
}

class Flight extends Component{

    public Flight(String name, Mediator mediator) {
        super(name, mediator);
    }

    @Override
    void send(Mediator mediator, String message) {
        System.out.println(this.name +" has sent a message :"+message);
        mediator.notify(this, message);
    }

    @Override
    void receive(String message) {
        System.out.println(this.name +" has received a message :"+message);
    }
}

class ATC implements Mediator{

    List<Component> flights = new ArrayList<>();

    @Override
    public void notify(Component component, String message) {
        flights.forEach( flight->flight.receive(message));
    }

    @Override
    public void register(Component flight) {
        flights.add(flight);
    }
}