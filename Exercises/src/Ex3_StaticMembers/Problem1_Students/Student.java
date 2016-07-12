package Ex3_StaticMembers.Problem1_Students;

/**
 * Created by Niki on 24.6.2016 г..
 */
public class Student {
    String name;
    static int instancesCreated = 0;

    public Student(String name) {
        this.name = name;
        instancesCreated++;
    }
}
