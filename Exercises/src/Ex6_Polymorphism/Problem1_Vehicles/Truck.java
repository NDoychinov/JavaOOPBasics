package Ex6_Polymorphism.Problem1_Vehicles;

/**
 * Created by Niki on 1.7.2016 г..
 */
public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        fuelConsumption += 1.6d;
        super.setFuelConsumption(fuelConsumption);
    }

    @Override
    public void refuel(Double amount) {
        amount = amount * 0.95d;
        super.refuel(amount);
    }
}
