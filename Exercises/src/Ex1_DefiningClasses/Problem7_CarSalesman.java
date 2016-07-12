package Ex1_DefiningClasses;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

/**
 * Created by Niki on 21.6.2016 г..
 */
class Car1 {
    String model;
    String engine;
    int weight;
    String color;

    Car1(String model, String engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    Car1(String model, String engine, int weight) {
        this(model, engine, weight, "n/a");
    }

    Car1(String model, String engine, String color) {
        this(model, engine, -1, color);
    }

    Car1(String model, String engine) {
        this(model, engine, -1, "n/a");
    }
}

class Engine1 {
    String model;
    int power;
    int displacement;
    String efficiency;

    Engine1(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    Engine1(String model, int power, int displacement) {

        this(model, power, displacement, "n/a");
    }

    Engine1(String model, int power, String efficiency) {

        this(model, power, -1, efficiency);
    }

    Engine1(String model, int power) {

        this(model, power, -1, "n/a");
    }


}

public class Problem7_CarSalesman {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        List<Engine1> engineList = new ArrayList<>();
        List<Car1> carList = new ArrayList<>();

        int lines = Integer.parseInt(sc.readLine());
        for (int i = 0; i < lines; i++) {
            String[] data = sc.readLine().split("\\s+");

            if (data.length == 3) {
                try {
                    int displacement = Integer.parseInt(data[2]);
                    engineList.add(new Engine1(data[0], Integer.parseInt(data[1]), displacement));
                } catch (Exception e) {
                    engineList.add(new Engine1(data[0], Integer.parseInt(data[1]), data[2]));
                }
            } else if (data.length == 2) {
                engineList.add(new Engine1(data[0], Integer.parseInt(data[1])));
            } else if (data.length == 4) {
                engineList.add(new Engine1(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), data[3]));
            }
        }

        lines = Integer.parseInt(sc.readLine());
        for (int i = 0; i < lines; i++) {
            String[] data = sc.readLine().split("\\s+");

            if (data.length == 4) {
                carList.add(new Car1(data[0], data[1], Integer.parseInt(data[2]), data[3]));
            } else if (data.length == 2) {
                carList.add(new Car1(data[0], data[1]));
            } else {
                try {
                    int weight = Integer.parseInt(data[2]);
                    carList.add(new Car1(data[0], data[1], Integer.parseInt(data[2])));

                } catch (Exception e) {
                    carList.add(new Car1(data[0], data[1], data[2]));
                }
            }
        }

        for (int i = 0; i < carList.size(); i++) {
            Car1 currCar = carList.get(i);
            System.out.println(currCar.model + ":");
            System.out.printf("  %s:%n", currCar.engine);
            for (int j = 0; j < engineList.size(); j++) {
                Engine1 currEngine = engineList.get(j);
                if (currEngine.model.equals(currCar.engine)) {
                    System.out.printf("    Power: %d%n", currEngine.power);
                    if (currEngine.displacement != -1) {
                        System.out.printf("    Displacement: %d%n", currEngine.displacement);
                    } else {
                        System.out.printf("    Displacement: n/a%n");
                    }
                    System.out.printf("    Efficiency: %s%n", currEngine.efficiency);
                }
            }
            if (currCar.weight != -1) {
                System.out.printf("  Weight: %s%n", currCar.weight);
            } else {
                System.out.printf("  Weight: n/a%n");
            }
            System.out.printf("  Color: %s%n", currCar.color);
        }
    }
}
