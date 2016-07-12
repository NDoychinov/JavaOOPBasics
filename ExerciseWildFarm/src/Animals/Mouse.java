package Animals;

import Foods.Food;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Niki on 4.7.2016 г..
 */
public class Mouse extends Mammal {
    private List<String> edibleFood;

    public Mouse(String name, String type, Double weight, String livingRegion) {
        super(name, type, weight, livingRegion);
        this.initializeEdibleFood();
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eatFood(Food food) {
        if (this.edibleFood.contains(food.toString())){
            super.eatFood(food);
            System.out.println("A cheese was just eaten!");
        } else {
            System.out.println("Mouses are not eating that type of food!");
        }
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        df.setMaximumFractionDigits(340);
        return String.format("Mouse[%s, %s, %s, %d]",
                super.getName(),
                df.format(super.getWeight()),
                super.getLivingRegion(), super.getEaten());
    }

    private void initializeEdibleFood(){
        this.edibleFood = new ArrayList<>();
        this.edibleFood.add("Vegetable");
    }
}
