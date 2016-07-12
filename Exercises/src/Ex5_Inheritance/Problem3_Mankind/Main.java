package Ex5_Inheritance.Problem3_Mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Niki on 29.6.2016 г..
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] data = sc.readLine().trim().split("\\s+");
        Student student = null;
        try {
            student = new Student(data[0], data[1], data[2]);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        data = sc.readLine().split("\\s+");
        Worker worker = null;
        try {
            worker = new Worker(data[0], data[1],
                    Double.parseDouble(data[2]), Double.parseDouble(data[3]));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("First Name: " + student.getFirstName());
        System.out.println("Last Name: " + student.getLastName());
        System.out.println("Faculty number: " + student.getFacultyNumber());
        System.out.println();
        System.out.println("First Name: " + worker.getFirstName());
        System.out.println("Last Name: " + worker.getLastName());
        System.out.printf("Week Salary: %.2f%n", worker.getWeekSalary());
        System.out.printf("Hours per day: %.2f%n", worker.getWorkHoursDaily());
        System.out.printf("Salary per hour: %.2f%n", worker.earnByHour());

    }
}
