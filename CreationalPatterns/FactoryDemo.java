package CreationalPatterns;

public class FactoryDemo {
    public static void main(String[] args){

        // ANY OBJECT OF TYPE BIKE CAN BE EXTRACTED FROM BIKEFACTORY
        new BikeFactory().getBike("Pulsar").ride();
        new BikeFactory().getBike("Splendor").ride();
    }
}

interface Bike{
    void ride();
}

class Pulsar implements Bike{
    @Override
    public void ride(){
        System.out.println("Riding pulsar");
    }
}

class Splendor implements Bike{
    @Override
    public void ride(){
        System.out.println("Riding splendor");
    }
}

// FACTORY DESIGN PATTERN
class BikeFactory{
    public Bike getBike(String type){
        if(type.equalsIgnoreCase("PULSAR")){
            return new Pulsar();
        }
        else if(type.equalsIgnoreCase("SPLENDOR")){
            return new Splendor();
        }
        else{
            return null;
        }
    }
}
