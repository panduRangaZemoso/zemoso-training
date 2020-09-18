package BehaviouralPatterns;

public class CommandDemo {
    public static void main(String[] args){
        // DEFINING DEVICES
        Device philipsBulb = new Bulb("philips");
        Device cromptonFan = new Fan("crompton");

        // DEFINING COMMANDS ON EACH DEVICE
        Command turnOnPhilipsBulb = new TurnOnCommand(philipsBulb);
        Command turnOnCromptonFan = new TurnOnCommand(cromptonFan);
        Command turnOffPhilipsBulb = new TurnOffCommand(philipsBulb);
        Command turnOffCromptonFan = new TurnOffCommand(cromptonFan);

        // COMMAND EXECUTION ON BULB
        CommandInvoker invoker = new CommandInvoker(turnOnPhilipsBulb);
        invoker.executeCommand();
        invoker.setCommand(turnOffPhilipsBulb);
        invoker.executeCommand();

        // COMMAND EXECUTION ON FAN
        invoker.setCommand(turnOnCromptonFan);
        invoker.executeCommand();
        invoker.setCommand(turnOffCromptonFan);
        invoker.executeCommand();

    }
}


// COMMAND DESIGN PATTERN
class CommandInvoker{
    Command command;

    CommandInvoker(Command command) {
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand(){
        command.execute();
    }
}


interface Command{
    void execute();
}

interface Device{
    void turnOn();
    void turnOff();
}

class TurnOnCommand implements Command{

    private Device device;

    TurnOnCommand(Device device){
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOn();
    }
}

class TurnOffCommand implements Command{

    private Device device;

    TurnOffCommand(Device device){
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOff();
    }
}

class Bulb implements Device{

    String name;
    Bulb(String name){
        this.name = name;
    }

    @Override
    public void turnOn() {
        System.out.println(name+" Bulb Turned ON");
    }

    @Override
    public void turnOff() {
        System.out.println(name+" Bulb Turned OFF");
    }
}

class Fan implements Device{

    String name;
    Fan(String name){
        this.name = name;
    }

    @Override
    public void turnOn() {
        System.out.println(name+" Fan Turned ON");
    }

    @Override
    public void turnOff() {
        System.out.println(name+" Fan Turned OFF");
    }
}