// FactoryPattern.java
interface Vehicle {
    void drive();
}

class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car.");
    }
}

class Bike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Riding a bike.");
    }
}

class VehicleFactory {
    public Vehicle getVehicle(String vehicleType) {
        if (vehicleType == null) {
            return null;
        }
        if (vehicleType.equalsIgnoreCase("CAR")) {
            return new Car();
        } else if (vehicleType.equalsIgnoreCase("BIKE")) {
            return new Bike();
        }
        return null;
    }
}

public class FactoryPatternDemo {
    public static void main(String[] args) {
        VehicleFactory factory = new VehicleFactory();
        Vehicle vehicle1 = factory.getVehicle("CAR");
        vehicle1.drive();

        Vehicle vehicle2 = factory.getVehicle("BIKE");
        vehicle2.drive();
    }
}
