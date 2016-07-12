package Ex1_DefiningClasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niki on 20.6.2016 г..
 */

class CargoCar {
    String model;
    Engine engine;
    Cargo cargo;
    Tire[] tires;

    CargoCar(String model, int engineSpeed, int enginePower, int cargoWeight,
             String cargoType, Double tire1Press, Double tire1Age, Double tire2Press, Double tire2Age,
             Double tire3Press, Double tire3Age, Double tire4Press, Double tire4Age) {
        this.model = model;
        this.engine = new Engine(engineSpeed, enginePower);
        this.cargo = new Cargo(cargoWeight, cargoType);
        this.tires = new Tire[4];
        this.tires[0] = new Tire(tire1Press, tire1Age);
        this.tires[1] = new Tire(tire2Press, tire2Age);
        this.tires[2] = new Tire(tire3Press, tire3Age);
        this.tires[3] = new Tire(tire4Press, tire4Age);
    }

}

class Engine {
    int speed;
    int power;

    Engine(int speed, int power) {
        this.speed = speed;
        this.power = power;
    }
}

class Cargo {
    int weight;
    String type;

    Cargo(int weight, String type) {
        this.weight = weight;
        this.type = type;
    }
}

class Tire {
    Double pressure;
    Double age;

    Tire(Double pressure, Double age) {
        this.pressure = pressure;
        this.age = age;
    }
}

public class Problem6_RawData {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        List<CargoCar> cargoCarList = new ArrayList<>();

        int lines = Integer.parseInt(sc.readLine());
        for (int i = 0; i < lines; i++) {
            String[] data = sc.readLine().split("\\s+");
            cargoCarList.add(new CargoCar(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]),
                    data[4], Double.parseDouble(data[5]), Double.parseDouble(data[6]), Double.parseDouble(data[7]),
                    Double.parseDouble(data[8]), Double.parseDouble(data[9]), Double.parseDouble(data[10]),
                    Double.parseDouble(data[11]), Double.parseDouble(data[12])));
        }

        String command = sc.readLine();

        if (command.equals("fragile")) {
            for (int i = 0; i < cargoCarList.size(); i++) {
                CargoCar currCar = cargoCarList.get(i);
                if (currCar.cargo.type.equals("fragile")){
                    if (currCar.tires[0].pressure < 1 || currCar.tires[1].pressure < 1 ||
                            currCar.tires[2].pressure < 1 &&currCar.tires[3].pressure < 1){
                        System.out.println(currCar.model);
                    }
                }
            }
        } else {
            for (int i = 0; i < cargoCarList.size(); i++) {
                CargoCar currCar = cargoCarList.get(i);
                if (currCar.cargo.type.equals("flamable")){
                    if (currCar.engine.power > 250){
                        System.out.println(currCar.model);
                    }
                }
            }
        }
    }
}
