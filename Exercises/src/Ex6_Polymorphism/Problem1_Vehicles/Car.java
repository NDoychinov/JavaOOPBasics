package Ex6_Polymorphism.Problem1_Vehicles;

/**
 * Created by Niki on 1.7.2016 г..
 */
public class Car extends Vehicle {


    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        fuelConsumption += 0.9d;
        super.setFuelConsumption(fuelConsumption);
    }
}
