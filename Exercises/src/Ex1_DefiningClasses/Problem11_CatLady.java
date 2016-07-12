package Ex1_DefiningClasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niki on 21.6.2016 г..
 */

abstract class Cat {
    String name;
    List<Cat> catList;
    Cat(String name){
        this.name = name;
    }
}

class Siamese extends Cat {
    String earSize;

    public Siamese(String name, String earSize) {
        super(name);
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return String.format("Siamese %s %s", this.name, this.earSize);
    }
}

class Cymric extends Cat {
    String furLenght;

    Cymric(String name, String furLenght){
        super(name);
        this.furLenght = furLenght;
    }

    @Override
    public String toString() {
        return String.format("Cymric %s %s", this.name, this.furLenght);
    }
}

class StreetExtraordinaire extends Cat {
    String decibelsOfMeows;

    public StreetExtraordinaire(String name, String decibelsOfMeows) {
        super(name);
        this.decibelsOfMeows = decibelsOfMeows;
    }

    @Override
    public String toString() {
        return String.format("StreetExtraordinaire %s %s", this.name, this.decibelsOfMeows);
    }
}


public class Problem11_CatLady {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        List<Cat> catList = new ArrayList<>();
        String input = sc.readLine();

        while (!input.equals("End")){
            String[] data = input.split("\\s+");

            switch (data[0]){
                case "Siamese":
                    catList.add(new Siamese(data[1], data[2]));
                    break;
                case "Cymric":
                    catList.add(new Cymric(data[1], data[2]));
                    break;
                case "StreetExtraordinaire":
                    catList.add(new StreetExtraordinaire(data[1], data[2]));
                    break;
            }

            input = sc.readLine();
        }

        input = sc.readLine();
        for (int i = 0; i < catList.size(); i++) {
            if (catList.get(i).name.equals(input)){
                System.out.println(catList.get(i));
            }
        }
    }
}
