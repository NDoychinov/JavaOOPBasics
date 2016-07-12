package Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niki on 9.7.2016 г..
 */
public class Children {

    private double foodCost;
    private List<Toy> toys;

    public Children(double foodCost) {
        this.setFoodCost(foodCost);
        this.toys = new ArrayList<>();
    }

    public double getFoodCost() {
        return foodCost;
    }

    private void setFoodCost(double foodCost) {
        this.foodCost = foodCost;
    }

    public void addToy(Toy toy) {
        this.toys.add(toy);
    }

    public double getConsumption(){
        double consumption = 0;
        consumption += this.foodCost;
        for (int i = 0; i < this.toys.size(); i++) {
            consumption += this.toys.get(i).getPrice();
        }
        return consumption;
    }
}
