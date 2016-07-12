package Ex5_Inheritance.Problem6_Animals;

/**
 * Created by Niki on 30.6.2016 г..
 */
public class Dog extends Animal {

    public Dog(String name, int age, String gender){
        super(name, age, gender);
    }


    @Override
    public void produceSound() {
        System.out.println("BauBau");
    }

    @Override
    public String toString() {
        return String.format("Dog%n%s %d %s", super.getName(), super.getAge(), super.getGender());
    }
}
