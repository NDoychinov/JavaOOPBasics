package Ex1_DefiningClasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niki on 20.6.2016 г..
 */
class Car {
    String model;
    Double fuelAmount;
    Double fuelPerKm;
    Double traveledDistance;

    Car(String model, Double fuelAmount, Double fuelPerKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelPerKm = fuelPerKm;
        this.traveledDistance = 0d;
    }

    boolean hasEnoughFuel(Double kmToTravel) {
        double expensives = kmToTravel * this.fuelPerKm;
        if (expensives > this.fuelAmount) {
            return false;
        }
        return true;
    }
}

public class Problem5_SpeedRacing {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        List<Car> carList = new ArrayList<>();

        int carCount = Integer.parseInt(sc.readLine());
        for (int i = 0; i < carCount; i++) {
            String[] data = sc.readLine().split("\\s+");
            carList.add(new Car(data[0], Double.parseDouble(data[1]), Double.parseDouble(data[2])));
        }

        String input = sc.readLine();

        while (!input.equals("End")) {
            String[] data = input.split("\\s+");

            for (int i = 0; i < carList.size(); i++) {
                Car currCar = carList.get(i);
                if (currCar.model.equals(data[1])) {
                    if (currCar.hasEnoughFuel(Double.parseDouble(data[2]))) {
                        currCar.traveledDistance += Double.parseDouble(data[2]);
                        currCar.fuelAmount -= currCar.fuelPerKm * Double.parseDouble(data[2]);
                    } else {
                        System.out.println("Insufficient fuel for the drive");
                    }
                }
            }

            input = sc.readLine();
        }

        for (int i = 0; i < carList.size(); i++) {
            Car currCar = carList.get(i);
            System.out.printf("%s %.2f %.0f%n",currCar.model, currCar.fuelAmount, currCar.traveledDistance);
        }
    }
}
