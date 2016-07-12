package Ex5_Inheritance.Problem6_Animals;

/**
 * Created by Niki on 30.6.2016 г..
 */
public class Tomcat extends Cat {

    protected Tomcat(String name, int age) {
        super(name, age, "Male");
    }

    @Override
    public void produceSound() {
        System.out.println("Give me one million b***h");
    }

    public String toString() {
        return String.format("Tomcat%n%s %d %s", super.getName(), super.getAge(), super.getGender());
    }
}
