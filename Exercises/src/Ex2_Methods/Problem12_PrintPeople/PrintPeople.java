package Ex2_Methods.Problem12_PrintPeople;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Niki on 23.6.2016 г..
 */
class Person {

    String name;
    int age;
    String occupation;

    public Person(String name, int age, String occupation) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }
}


public class PrintPeople {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String input = sc.readLine();
        List<Person> personList = new ArrayList<>();

        while (!input.equals("END")) {
            String[] data = input.split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            String occupation = data[2];
            personList.add(new Person(name, age, occupation));

            input = sc.readLine();
        }

        Collections.sort(personList, (s1, s2) -> Integer.compare(s1.age, s2.age));

        for (int i = 0; i < personList.size(); i++) {
            Person currPerson = personList.get(i);
            System.out.printf("%s - age: %d, occupation: %s%n", currPerson.name, currPerson.age, currPerson.occupation);
        }
    }
}
