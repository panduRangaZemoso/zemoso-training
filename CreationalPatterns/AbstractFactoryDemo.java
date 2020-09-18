package CreationalPatterns;

public class AbstractFactoryDemo {
    public static void main(String[] args){
        new BikeFactory2().getHighEndFactory(true).getBike("Pulsar").ride();
        new BikeFactory2().getHighEndFactory(false).getBike("splendor").ride();
    }
}

// ABSTRACT FACTORY DEMO
interface BikeTypeFactory {
    Bike getBike(String bikeType) ;
}

class BikeFactory2 {
    public static BikeTypeFactory getHighEndFactory(boolean highEnd){
        if(highEnd){
            return new HighEndFactory();
        }else{
            return new LowEndFactory();
        }
    }
}

class HighEndFactory implements BikeTypeFactory{
    public Bike getBike(String type){
        if(type.equalsIgnoreCase("PULSAR")){
            return new Pulsar200();
        }
        else if(type.equalsIgnoreCase("SPLENDOR")){
            return new Splendor150();
        }
        else{
            return null;
        }
    }
}

class LowEndFactory implements BikeTypeFactory{
    public Bike getBike(String type){
        if(type.equalsIgnoreCase("PULSAR")){
            return new Pulsar150();
        }
        else if(type.equalsIgnoreCase("SPLENDOR")){
            return new Splendor125();
        }
        else{
            return null;
        }
    }
}

class Pulsar150 implements Bike{
    @Override
    public void ride(){
        System.out.println("Riding pulsar 150cc");
    }
}

class Splendor125 implements Bike{
    @Override
    public void ride(){
        System.out.println("Riding splendor 125cc");
    }
}

class Pulsar200 implements Bike{
    @Override
    public void ride(){
        System.out.println("Riding pulsar 200cc");
    }
}

class Splendor150 implements Bike{
    @Override
    public void ride(){
        System.out.println("Riding splendor 150cc");
    }
}



