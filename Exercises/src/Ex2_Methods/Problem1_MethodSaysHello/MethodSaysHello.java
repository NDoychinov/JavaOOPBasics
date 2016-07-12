package Ex2_Methods.Problem1_MethodSaysHello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Niki on 22.6.2016 г..
 */
public class MethodSaysHello {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String name = sc.readLine();
        Person person = new Person(name);
        System.out.println(person.greetPpl());

        Field[] fields = Class.forName("Person").getDeclaredFields();
        Method[] methods = Class.forName("Person").getDeclaredMethods();
        if (fields.length != 1 || methods.length != 1) {
            throw new ClassFormatError();
        }

    }
}

class Person {
    String name;

    Person(String name){
        this.name = name;
    }

    String greetPpl(){
        return String.format("%s says \"Hello\"!", this.name);
    }
}

