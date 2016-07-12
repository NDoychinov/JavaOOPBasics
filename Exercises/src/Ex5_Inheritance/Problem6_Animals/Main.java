package Ex5_Inheritance.Problem6_Animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Niki on 30.6.2016 г..
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while (!((input = sc.readLine().trim()).equals("Beast!"))) {
            String secInput = sc.readLine().trim();
            if (secInput.equals("Beast!")) {
                break;
            }
            String[] data = secInput.split("\\s+");

            String name = data[0].trim();
            int age;
            try {
                age = Integer.parseInt(data[1].trim());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                return;
            }
            String gender = null;
            if (data.length > 2) {
                gender = data[2].trim();
            }

            try {
                switch (input.toLowerCase()) {
                    case "cat":
                        Cat cat = new Cat(name, age, gender);
                        System.out.println(cat.toString());
                        cat.produceSound();
                        break;
                    case "dog":
                        Dog dog = new Dog(name, age, gender);
                        System.out.println(dog.toString());
                        dog.produceSound();
                        break;
                    case "frog":
                        Frog frog = new Frog(name, age, gender);
                        System.out.println(frog.toString());
                        frog.produceSound();
                        break;
                    case "kitten":
                        Kitten kitten = new Kitten(name, age);
                        System.out.println(kitten.toString());
                        kitten.produceSound();
                        break;
                    case "tomcat":
                        Tomcat tomcat = new Tomcat(name, age);
                        System.out.println(tomcat.toString());
                        tomcat.produceSound();
                        break;
                    case "animal":
                        Animal animal = new Animal(name, age, gender);
                        System.out.println(animal.toString());
                        animal.produceSound();
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

    }
}
