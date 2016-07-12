import Animals.*;
import Foods.Food;
import Foods.Meat;
import Foods.Vegetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Niki on 4.7.2016 г..
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String input = sc.readLine();

        while (!input.equals("End")){
            String[] data = input.trim().split("\\s");
            String type = data[0];
            String name = data[1];
            Double weight = Double.parseDouble(data[2]);
            String region = data[3];

            if (data.length == 5){
                String breed = data[4];

                Animal animal = new Cat(name, type, weight, region, breed);
                String[] foodInfo = sc.readLine().split("\\s+");
                Food food = null;
                if (foodInfo[0].equals("Meat")){
                    food = new Meat(Integer.parseInt(foodInfo[1]));
                } else {
                    food = new Vegetable(Integer.parseInt(foodInfo[1]));
                }
                animal.makeSound();
                animal.eatFood(food);
                System.out.println(animal.toString());

            } else if (data.length == 4){
                Animal animal = null;
                switch (data[0]){
                    case "Tiger":
                        animal = new Tiger(name, type, weight, region);
                        break;
                    case "Mouse":
                        animal = new Mouse(name, type, weight, region);
                        break;
                    case "Zebra":
                        animal = new Zebra(name, type, weight, region);
                        break;
                }
                String[] foodInfo = sc.readLine().split("\\s+");
                Food food = null;
                if (foodInfo[0].equals("Meat")){
                    food = new Meat(Integer.parseInt(foodInfo[1]));
                } else {
                    food = new Vegetable(Integer.parseInt(foodInfo[1]));
                }
                animal.makeSound();
                animal.eatFood(food);
                System.out.println(animal.toString());
            }

            input = sc.readLine();
        }
    }
}
