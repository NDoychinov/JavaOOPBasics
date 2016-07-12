package Ex5_Inheritance.Problem6_Animals;

/**
 * Created by Niki on 30.6.2016 г..
 */
public class Cat extends Animal  {

    protected Cat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public void produceSound() {
        System.out.println("MiauMiau");
    }

    public String toString() {
        return String.format("Cat%n%s %d %s", super.getName(), super.getAge(), super.getGender());
    }
}
