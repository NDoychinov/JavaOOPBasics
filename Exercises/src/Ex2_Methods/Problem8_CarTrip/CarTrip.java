package Ex2_Methods.Problem8_CarTrip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Niki on 22.6.2016 г..
 */
class Car {
    private Double speed;
    private Double fuel;
    private Double fuelEconomy;
    private Double traveledKm;
    private Double traveledMins;

    public Car(Double speed, Double fuel, Double fuelEconomy) {
        this.speed = speed;
        this.fuel = fuel;
        this.fuelEconomy = fuelEconomy;
        this.traveledKm = 0d;
        this.traveledMins = 0d;
    }

    void addTravel(double traveled){
        Double fuelToTravel = (fuel / fuelEconomy) * 100;

        if (fuelToTravel < traveled){
            traveled = fuelToTravel;
        }

        this.traveledKm += traveled;

        Double cost = fuelEconomy * (traveled / 100);
        this.fuel -= cost;
        if (this.fuel < 0d){
            this.fuel = 0d;
        }

        Double mins = (traveled / speed) * 60d;
        traveledMins += mins;
    }

    void refuel(double amount){
        this.fuel += amount;
    }

    public Double getSpeed() {
        return speed;
    }

    public Double getFuel() {
        return fuel;
    }

    public Double getFuelEconomy() {
        return fuelEconomy;
    }

    public Double getTraveledKm() {
        return traveledKm;
    }

    public Double getTraveledMins() {
        return traveledMins;
    }
}

public class CarTrip {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] inputData = sc.readLine().split("\\s+");
        Car myCar = new Car(Double.parseDouble(inputData[0]), Double.parseDouble(inputData[1]), Double.parseDouble(inputData[2]));

        String input = sc.readLine();

        while (!input.equals("END")){
            String[] data = input.split("\\s+");
            switch (data[0]){
                case "Travel":
                    myCar.addTravel(Double.parseDouble(data[1]));
                    break;
                case "Refuel":
                    myCar.refuel(Double.parseDouble(data[1]));
                    break;
                case "Distance":
                    System.out.printf("Total distance: %.1f kilometers%n", myCar.getTraveledKm());
                    break;
                case "Time":
                    Double time = myCar.getTraveledMins();
                    int hours = (int)(time / 60);
                    int minutes = (int)(time - (hours * 60));
                    System.out.printf("Total time: %d hours and %d minutes%n", hours, minutes);
                    break;
                case "Fuel":
                    System.out.printf("Fuel left: %.1f liters%n", myCar.getFuel());
                    break;
            }

            input = sc.readLine();
        }

    }
}
