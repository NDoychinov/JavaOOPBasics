package Ex3_StaticMembers.Problem5_AnimalClinic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Niki on 24.6.2016 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        List<Animal> animalList = new ArrayList<>();

        String input = sc.readLine();
        while (!input.equals("End")){
            String[] data = input.split("\\s+");
            String name = data[0];
            String breed = data[1];
            String action = data[2];

            animalList.add(new Animal(name, breed, action));

            input = sc.readLine();
        }
        System.out.printf("Total healed animals: %d%n", AnimalClinic.healedAnimals.size());
        System.out.printf("Total rehabilitated animals: %d%n", AnimalClinic.rehabilitedAnimals.size());

        input = sc.readLine();

        if (input.equals("heal")){
            for (Map.Entry<Integer,Animal> integerAnimalEntry : AnimalClinic.healedAnimals.entrySet()) {
                Animal currAnimal = AnimalClinic.healedAnimals.get(integerAnimalEntry.getKey());
                System.out.printf("%s %s%n", currAnimal.name, currAnimal.breed);
            }

        } else {
            for (Map.Entry<Integer,Animal> integerAnimalEntry : AnimalClinic.rehabilitedAnimals.entrySet()) {
                Animal currAnimal = AnimalClinic.rehabilitedAnimals.get(integerAnimalEntry.getKey());
                System.out.printf("%s %s%n", currAnimal.name, currAnimal.breed);
            }
        }
    }
}
