package Ex6_Polymorphism.Problem1_Vehicles;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Created by Niki on 1.7.2016 г..
 */
public class Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;
    private double travelled;
    private double tankCapacity;

    protected Vehicle(double fuelQuantity, double fuelConsumption) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.travelled = 0d;
    }

    private void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    protected double getFuelConsumption() {
        return fuelConsumption;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    protected double getTravelled() {
        return travelled;
    }

    protected void setTravelled(double travelled) {
        this.travelled = travelled;
    }

    public void refuel(Double amount) {
        fuelQuantity += amount;
    }

    public void travelDistance(Double distance) {
        if (fuelQuantity / fuelConsumption < distance) {
            System.out.printf("%s needs refueling%n", this.getClass().getSimpleName());
            return;
        }
        travelled += distance;
        fuelQuantity -= distance * fuelConsumption;
        DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        df.setMaximumFractionDigits(340);
        System.out.printf("%s travelled %s km%n", this.getClass().getSimpleName(), df.format(distance));
    }
}
