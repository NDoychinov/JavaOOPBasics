package Ex5_Inheritance.Problem1_Person;

/**
 * Created by Niki on 29.6.2016 г..
 */
public class Child extends Person {

    public Child(String name, int age) {
        super(name, age);
    }

    @Override
    protected void setAge(int age) {
        if (age > 15){
            throw new IllegalArgumentException("Child's age must be less than 15!");
        }
        super.setAge(age);
    }
}
