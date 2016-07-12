package Ex3_StaticMembers.Problem1_Students;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niki on 24.6.2016 г..
 */
public class Students {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        List<Student> studentList = new ArrayList<>();
        String name = sc.readLine();

        while (!name.equals("End")){
            studentList.add(new Student(name));
            name = sc.readLine();
        }

        System.out.println(Student.instancesCreated);
    }
}
