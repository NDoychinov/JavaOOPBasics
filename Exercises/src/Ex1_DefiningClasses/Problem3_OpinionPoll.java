package Ex1_DefiningClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Niki on 20.6.2016 г..
 */
public class Problem3_OpinionPoll {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person3> persons = new ArrayList<>();
        int lines = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < lines; i++) {
            String[] data = sc.nextLine().split("\\s+");
            persons.add(new Person3(data[0], Integer.parseInt(data[1])));
        }


        Collections.sort(persons, (s1, s2) -> s1.name.compareTo(s2.name));
        for (int i = 0; i < lines; i++) {
            Person3 currPerson = persons.get(i);
            if (currPerson.age > 30) {
                System.out.printf("%s - %d%n", currPerson.name, currPerson.age);
            }
        }
    }

}

class Person3 {
    String name;
    int age;

    Person3(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
