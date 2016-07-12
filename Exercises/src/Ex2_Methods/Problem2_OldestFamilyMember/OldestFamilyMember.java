package Ex2_Methods.Problem2_OldestFamilyMember;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niki on 22.6.2016 г..
 */
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Family {
    private List<Person> family;

    Family() {
        this.family = new ArrayList<>();
    }

    void addMember(Person person) {
        this.family.add(person);
    }

    Person getOldestMember() {
        Person currOldest = family.get(0);
        for (int i = 1; i < family.size(); i++) {
            if (family.get(i).getAge() > currOldest.getAge()) {
                currOldest = family.get(i);
            }
        }
        return currOldest;
    }
}

public class OldestFamilyMember {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int lines = Integer.parseInt(sc.readLine());
        Family family = new Family();

        for (int i = 0; i < lines; i++) {
            String line = sc.readLine().trim();
            String[] data = line.split("\\s+");
            family.addMember(new Person(data[0], Integer.parseInt(data[1])));
        }

        Person oldestMember = family.getOldestMember();
        System.out.printf("%s %d", oldestMember.getName(), oldestMember.getAge());
    }
}
