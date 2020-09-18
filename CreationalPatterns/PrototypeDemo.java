package CreationalPatterns;

import java.util.HashMap;
import java.util.Map;

public class PrototypeDemo {
    public static void main(String[] args) {
        VehicleStore vehicleStore = new VehicleStore();
        vehicleStore.addVehicle(new Car());
        vehicleStore.addVehicle(new Bus());

        vehicleStore.getVehicle("Bus").ride();
        vehicleStore.getVehicle("car").ride();
    }
}

abstract class Vehicle implements Cloneable{
    private String name;

    abstract void ride();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object clone(){
        Object clone = null;
        try{
            clone = super.clone();
        }
        catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return clone;
    }
}

class Bus extends Vehicle{
    Bus(){
        super.setName("bus");
    }

    @Override
    void ride() {
        System.out.println("Riding Bus");
    }
}

class Car extends Vehicle{
    Car(){
        super.setName("car");
    }

    @Override
    void ride() {
        System.out.println("Riding car");
    }
}

class VehicleStore{
    public static Map<String, Vehicle> vehicleMap = new HashMap<>();

    public void addVehicle(Vehicle vehicle){
        vehicleMap.put(vehicle.getName().toLowerCase(), vehicle);
    }

    public Vehicle getVehicle(String vehicleName){
        return (Vehicle) vehicleMap.get(vehicleName.toLowerCase()).clone();
    }
}
