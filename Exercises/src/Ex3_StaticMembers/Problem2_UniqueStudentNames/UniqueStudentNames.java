package Ex3_StaticMembers.Problem2_UniqueStudentNames;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by Niki on 24.6.2016 г..
 */
public class UniqueStudentNames {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String name = sc.readLine();
        HashMap<String, Student> studentMap = new HashMap<>();

        while (!name.equals("End")){
            if (!studentMap.containsKey(name)){
                studentMap.put(name, new Student(name));
            }

            name = sc.readLine();
        }

        System.out.println(Student.instancesCreated);
    }
}
