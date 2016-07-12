package Ex1_DefiningClasses;

import java.lang.reflect.Field;

/**
 * Created by Niki on 20.6.2016 г..
 */
public class Problem1_DefineAClassPerson {
    public static void main(String[] args) throws Exception {
        Class person = Class.forName("Person");
        Field[] fields = person.getDeclaredFields();
        System.out.println(fields.length);
    }


}

class Person2 {
    String name;
    int age;
}