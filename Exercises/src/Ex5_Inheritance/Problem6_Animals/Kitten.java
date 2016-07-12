package Ex5_Inheritance.Problem6_Animals;

/**
 * Created by Niki on 30.6.2016 г..
 */
public class Kitten extends Cat {

    protected Kitten(String name, int age) {
        super(name, age, "Female");
    }

    @Override
    public void produceSound() {
        System.out.println("Miau");
    }

    public String toString() {
        return String.format("Kitten%n%s %d %s", super.getName(), super.getAge(), super.getGender());
    }
}
