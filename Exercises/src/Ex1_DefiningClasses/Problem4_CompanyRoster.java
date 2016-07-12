package Ex1_DefiningClasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Niki on 20.6.2016 г..
 */

class Employee {
    String name;
    double salary;
    String position;
    String department;
    String email;
    int age;

    Employee(String name, double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    Employee(String name, double salary, String position, String department, int age) {
        this(name, salary, position, department, "n/a", age);
    }

    Employee(String name, double salary, String position, String department, String email) {
        this(name, salary, position, department, email, -1);
    }

    Employee(String name, double salary, String position, String department) {
        this(name, salary, position, department, "n/a", -1);
    }
}

public class Problem4_CompanyRoster {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        List<Employee> employees = new ArrayList<>();

        int lines = Integer.parseInt(sc.readLine());
        for (int i = 0; i < lines; i++) {
            String[] data = sc.readLine().split("\\s+");
            if (data.length == 6) {
                employees.add(new Employee(data[0], Double.parseDouble(data[1]), data[2], data[3], data[4], Integer.parseInt(data[5])));
            } else if (data.length == 4) {
                employees.add(new Employee(data[0], Double.parseDouble(data[1]), data[2], data[3]));
            } else {
                try {
                    int age = Integer.parseInt(data[4]);
                    employees.add(new Employee(data[0], Double.parseDouble(data[1]), data[2], data[3], age));
                } catch (Exception e) {
                    employees.add(new Employee(data[0], Double.parseDouble(data[1]), data[2], data[3], data[4]));
                }
            }
        }

        HashMap<String, List<Double>> salaryCollect = new HashMap<>();
        for (int i = 0; i < employees.size(); i++) {
            String depart = employees.get(i).department;
            double salary = employees.get(i).salary;

            if (!salaryCollect.containsKey(depart)) {
                salaryCollect.put(depart, new ArrayList<>());
            }
            salaryCollect.get(depart).add(salary);
        }

        String highestDep = "";
        double highestSalary = 0;
        for (Map.Entry<String, List<Double>> entry : salaryCollect.entrySet()) {
            double currSalary = average(salaryCollect.get(entry.getKey()));
            if (currSalary > highestSalary){
                highestSalary = currSalary;
                highestDep = entry.getKey();
            }
        }

        Collections.sort(employees, (s1, s2) -> Double.compare(s2.salary, s1.salary));

        System.out.println("Highest Average Salary: " + highestDep);
        for (int i = 0; i < employees.size(); i++) {
            Employee currEm = employees.get(i);

            if (currEm.department.equals(highestDep)){
                System.out.printf("%s %.2f %s %d%n", currEm.name, currEm.salary, currEm.email, currEm.age);
            }
        }
    }

    public static double average(List<Double> list){
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum / list.size();
    }
}
