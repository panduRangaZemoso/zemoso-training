package StructuralPatterns;

public class FacadeDemo {

    public static void main(String[] args){
        BikeFacade facade = new BikeFacade();

        facade.ridePulsar();
        facade.rideSplendor();
    }
}


class BikeFacade{
    private Bike pulsarBike;
    private Bike splendorBike;

    public BikeFacade() {
        this.pulsarBike = new Pulsar();
        this.splendorBike = new Splendor();
    }

    public void ridePulsar(){
        pulsarBike.ride();
    }

    public void rideSplendor(){
        splendorBike.ride();
    }
}

interface Bike{
    void ride();
}

class Pulsar implements Bike {
    @Override
    public void ride(){
        System.out.println("Riding pulsar");
    }
}

class Splendor implements Bike {
    @Override
    public void ride(){
        System.out.println("Riding splendor");
    }
}