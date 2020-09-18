package BehaviouralPatterns;

import java.util.HashMap;
import java.util.Map;

public class StateDemo {
    public static void main(String[] args) {
        Bike bike = new Bike();
        bike.displayState();

        bike.setCurrentGear(bike.getNextGear());
        bike.displayState();

        bike.setCurrentGear(bike.getNextGear());
        bike.displayState();

        bike.setCurrentGear(bike.getNextGear());
        bike.displayState();
    }
}

interface State{
    void moveTo();
    void stateName();
}

class GearN implements State{

    @Override
    public void moveTo() {
        System.out.println("Moved to Gear-Neutral");
    }

    @Override
    public void stateName() {
        System.out.println("In Neutral Gear");
    }
}

class Gear1 implements State{

    @Override
    public void moveTo() {
        System.out.println("Moved to Gear-1");
    }

    @Override
    public void stateName() {
        System.out.println("In 1st Gear");
    }
}

class Gear2 implements State{

    @Override
    public void moveTo() {
        System.out.println("Moved to Gear-2");
    }

    @Override
    public void stateName() {
        System.out.println("In 2nd Gear");
    }
}

class Gear3 implements State{

    @Override
    public void moveTo() {
        System.out.println("Moved to Gear-3");
    }

    @Override
    public void stateName() {
        System.out.println("In 3rd Gear");
    }
}

class Bike{

    private Map<State, State> possibleGearTransitions = new HashMap<>();
    private State currentGear;

    Bike(){
        State gearN = new GearN();
        State gear1 = new Gear1();
        State gear2 = new Gear2();
        State gear3 = new Gear3();

        possibleGearTransitions.put(gearN,gear1);
        possibleGearTransitions.put(gear1,gear2);
        possibleGearTransitions.put(gear2,gear3);

        currentGear = gearN;
    }

    public State getCurrentGear() {
        return currentGear;
    }

    public void setCurrentGear(State currentGear) {
        this.currentGear = currentGear;
    }

    public void displayState(){
        this.getCurrentGear().stateName();
    }

    public State getNextGear(){
        return this.possibleGearTransitions.get(this.getCurrentGear());
    }
}