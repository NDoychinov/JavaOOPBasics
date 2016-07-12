package Ex5_Inheritance.Problem6_Animals;

/**
 * Created by Niki on 30.6.2016 г..
 */
public class Animal implements SoundProducible {

    private String name;
    private int age;
    private String gender;

    protected Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    private void setName(String name) {
        if (name.equals("")){
            throw new IllegalArgumentException("Invalid input!");
        }

        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0){
            throw new IllegalArgumentException("Invalid input!");
        }

        this.age = age;
    }

    private void setGender(String gender) {
        if (!gender.toLowerCase().equals("male") && !gender.toLowerCase().equals("female")){
            throw new IllegalArgumentException("Invalid input!");
        }

        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public void produceSound() {
        System.out.println("Not implemented!");
    }

    @Override
    public String toString() {
        return String.format("Animal%n%s %d %s", getName(), getAge(), getGender());
    }
}
