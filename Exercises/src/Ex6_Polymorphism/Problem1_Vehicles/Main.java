package Ex6_Polymorphism.Problem1_Vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Niki on 1.7.2016 г..
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));


        String[] data = sc.readLine().split("\\s+");
        Double fuelQuan = Double.parseDouble(data[1]);
        Double perKm = Double.parseDouble(data[2]);
        Vehicle myCar = new Car(fuelQuan, perKm);

        data = sc.readLine().split("\\s+");
        fuelQuan = Double.parseDouble(data[1]);
        perKm = Double.parseDouble(data[2]);
        Vehicle myTruck = new Truck(fuelQuan, perKm);

        int linesCount = Integer.parseInt(sc.readLine());

        for (int i = 0; i < linesCount; i++) {
            data = sc.readLine().split("\\s+");
            if (data.length == 3) {
                if (data[0].equals("Drive")) {
                    if (data[1].equals("Car")) {
                        myCar.travelDistance(Double.parseDouble(data[2]));
                    } else {
                        myTruck.travelDistance(Double.parseDouble(data[2]));
                    }
                } else {
                    if (data[1].equals("Car")) {
                        myCar.refuel(Double.parseDouble(data[2]));
                    } else {
                        myTruck.refuel(Double.parseDouble(data[2]));
                    }
                }
            }
        }

        System.out.printf("Car: %.2f%n", myCar.getFuelQuantity());
        System.out.printf("Truck: %.2f%n", myTruck.getFuelQuantity());
    }
}
