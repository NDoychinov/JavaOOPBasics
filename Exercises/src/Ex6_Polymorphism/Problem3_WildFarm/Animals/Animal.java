package Ex6_Polymorphism.Problem3_WildFarm.Animals;

import Ex5_Inheritance.Problem6_Animals.SoundProducible;
import Ex6_Polymorphism.Problem3_WildFarm.Foods.Food;
import Ex6_Polymorphism.Problem3_WildFarm.Interfaces.Edible;

/**
 * Created by Niki on 4.7.2016 г..
 */
public abstract class Animal implements SoundProducible, Edible {
    private String name;
    private String type;
    private Double weight;
    private Integer eaten;

    protected Animal(String name, String type, Double weight) {
        this.setName(name);
        this.setType(type);
        this.setWeight(weight);
        this.eaten = 0;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setType(String type) {
        this.type = type;
    }

    private void setWeight(Double weight) {
        this.weight = weight;
    }

    protected String getName() {
        return name;
    }

    protected String getType() {
        return type;
    }

    protected Double getWeight() {
        return weight;
    }

    protected Integer getEaten() {
        return eaten;
    }

    @Override
    public void produceSound() {

    }

    @Override
    public void eatFood(Food food) {
        this.eaten += food.getQuantity();
    }
}
