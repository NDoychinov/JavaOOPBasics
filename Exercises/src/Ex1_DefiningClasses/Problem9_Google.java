package Ex1_DefiningClasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niki on 21.6.2016 г..
 */
//        •	“<Name> company <companyName> <department> <salary>”
//        •	“<Name> pokemon <pokemonName> <pokemonType>”
//        •	“<Name> parents <parentName> <parentBirthday>”
//        •	“<Name> children <childName> <childBirthday>”
//        •	“<Name> car <carModel> <carSpeed>”

class Person4 {
    String name;
    List<String> companyList = new ArrayList<>();
    List<String> pokemonList = new ArrayList<>();
    List<String> parentsList = new ArrayList<>();
    List<String> childerList = new ArrayList<>();
    List<String> carList = new ArrayList<>();

    Person4(String name) {
        this.name = name;
        this.companyList = new ArrayList<>();
        this.pokemonList = new ArrayList<>();
        this.parentsList = new ArrayList<>();
        this.childerList = new ArrayList<>();
        this.carList = new ArrayList<>();
    }
}


public class Problem9_Google {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        List<Person4> personList = new ArrayList<>();
        List<String> names = new ArrayList<>();

        String input = sc.readLine();
        while (!input.equals("End")) {
            String[] data = input.split("\\s+");

            if (!names.contains(data[0])) {
                personList.add(new Person4(data[0]));
                names.add(data[0]);
            }

            for (int i = 0; i < personList.size(); i++) {
                Person4 currPerson = personList.get(i);
                if (currPerson.name.equals(data[0])) {
                    switch (data[1]) {
                        case "company":
                            if (currPerson.companyList.size() == 0) {
                                currPerson.companyList.add(String.format("%s %s %.2f", data[2], data[3], Double.parseDouble(data[4])));
                            }else {
                                currPerson.companyList = new ArrayList<>();
                                currPerson.companyList.add(String.format("%s %s %.2f", data[2], data[3], Double.parseDouble(data[4])));
                            }
                            break;
                        case "pokemon":
                            currPerson.pokemonList.add(String.format("%s %s", data[2], data[3]));
                            break;
                        case "parents":
                            currPerson.parentsList.add(String.format("%s %s", data[2], data[3]));
                            break;
                        case "children":
                            currPerson.childerList.add(String.format("%s %s", data[2], data[3]));
                            break;
                        case "car":
                            currPerson.carList.add(String.format("%s %s", data[2], data[3]));
                            break;
                        default:
                            break;
                    }
                }
            }

            input = sc.readLine();
        }

        input = sc.readLine();
        for (int i = 0; i < personList.size(); i++) {
            Person4 currPerson = personList.get(i);
            if (currPerson.name.equals(input)){
                System.out.println(currPerson.name);
                System.out.println("Company:");
                for (int j = 0; j < currPerson.companyList.size(); j++) {
                    System.out.println(currPerson.companyList.get(j));
                }
                System.out.println("Car:");
                for (int j = 0; j < currPerson.carList.size(); j++) {
                    System.out.println(currPerson.carList.get(j));
                }
                System.out.println("Pokemon:");
                for (int j = 0; j < currPerson.pokemonList.size(); j++) {
                    System.out.println(currPerson.pokemonList.get(j));
                }
                System.out.println("Parents:");
                for (int j = 0; j < currPerson.parentsList.size(); j++) {
                    System.out.println(currPerson.parentsList.get(j));
                }
                System.out.println("Children:");
                for (int j = 0; j < currPerson.childerList.size(); j++) {
                    System.out.println(currPerson.childerList.get(j));
                }
            }
        }
    }
}
