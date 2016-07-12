package Ex4_Encapsulation.Problem5_PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niki on 27.6.2016 г..
 */
public class PizzaCalories {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String input = sc.readLine();
        String[] data = input.split("\\s+");
        if (data[0].toLowerCase().equals("pizza")) {
            Pizza myPizza = null;
            try {
                myPizza = new Pizza(data[1], Integer.parseInt(data[2]));
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                return;
            }

            input = sc.readLine();
            data = input.split("\\s+");
            try {
                myPizza.createDough(new Dough(data[1], data[2], Double.parseDouble(data[3])));
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                return;
            }


            input = sc.readLine();
            while (!input.equals("END")) {
                data = input.split("\\s+");

                try {
                    myPizza.addTopping(new Topping(data[1], Double.parseDouble(data[2])));
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                    return;
                }


                input = sc.readLine();

            }
            System.out.printf("%s - %.2f Calories.", myPizza.getName(), myPizza.totalCalories());
        } else {
            try {
                Dough dough = new Dough(data[1], data[2], Double.parseDouble(data[3]));
                System.out.printf("%.2f%n", dough.calculateCalories());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                return;
            }

            input = sc.readLine();
            while (!input.equals("END")) {
                data = input.split("\\s+");

                try {
                    Topping topping = new Topping(data[1], Double.parseDouble(data[2]));
                    System.out.printf("%.2f%n", topping.calculateCalories());
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                    return;
                }

                input = sc.readLine();
            }
        }
    }

    /**
     * Created by Niki on 27.6.2016 г..
     */
    public static class Pizza {

        private String name;
        private Dough dough;
        private int toppingsAmount;
        private List<Topping> toppings;

        public Pizza(String name, int toppingsAmount) {
            this.setName(name);
            this.setToppingsAmount(toppingsAmount);
            toppings = new ArrayList<>();
        }

        private void setName(String name) {
            if (!name.equals("") && name.length() <= 15) {
                this.name = name;
            } else {
                throw new NumberFormatException("Pizza name should be between 1 and 15 symbols");
            }
        }

        public String getName() {
            return name;
        }

        private int getToppingsAmount() {
            return toppingsAmount;
        }

        private void setToppingsAmount(int toppingsAmount) {
            if (toppingsAmount >= 1 && toppingsAmount <= 10) {
                this.toppingsAmount = toppingsAmount;
            } else {
                throw new NumberFormatException("Number of toppings should be in range [0..10].");
            }
        }

        public double totalCalories() {
            Double sum = 0d;

            sum += dough.calculateCalories();
            for (int i = 0; i < this.toppings.size(); i++) {
                sum += this.toppings.get(i).calculateCalories();
            }

            return sum;
        }

        public void addTopping(Topping topping) {
            this.toppings.add(topping);
        }

        public void createDough(Dough dough) {
            this.dough = dough;
        }
    }

    static class Topping {

        private String topingType;
        private double weight;

        public Topping(String topingType, double weight) {
            this.setTopingType(topingType);
            this.setWeight(weight);
        }

        private void setWeight(double weight) {
            if (weight >= 1 && weight <= 50) {
                this.weight = weight;
            } else {
                throw new NumberFormatException(String.format("%s weight should be in the range [1..50].", this
                        .topingType));
            }
        }

        private void setTopingType(String topingType) {
            if (topingType.toLowerCase().equals("meat") ||
                    topingType.toLowerCase().equals("veggies") ||
                    topingType.toLowerCase().equals("cheese") ||
                    topingType.toLowerCase().equals("sauce")) {
                this.topingType = topingType;
            } else {
                throw new NumberFormatException(String.format("Cannot place %s on top of your pizza.", topingType));
            }
        }

        public double calculateCalories() {
            Double result = this.weight * 2;

            switch (topingType.toLowerCase()) {
                case "meat":
                    result *= 1.2d;
                    break;
                case "veggies":
                    result *= 0.8d;
                    break;
                case "cheese":
                    result *= 1.1d;
                    break;
                case "sauce":
                    result *= 0.9d;
                    break;
            }

            return result;
        }

    }

    /**
     * Created by Niki on 27.6.2016 г..
     */

    static class Dough {

        private String flourType;
        private String bakingTechnique;
        private double weight;

        public Dough(String flourType, String bakingTechnique, double weight) {
            this.setFlourType(flourType);
            this.setBakingTechnique(bakingTechnique);
            this.setWeight(weight);
        }

        private void setWeight(double weight) {
            if (weight >= 1 && weight <= 200) {
                this.weight = weight;
            } else {
                throw new NumberFormatException("Dough weight should be in the range [1..200].");
            }
        }

        private void setFlourType(String flourType) {
            if (flourType.toLowerCase().equals("white") || flourType.toLowerCase().equals("wholegrain")) {
                this.flourType = flourType;
            } else {
                throw new NumberFormatException("Invalid type of dough.");
            }
        }

        private void setBakingTechnique(String bakingTechnique) {
            if (bakingTechnique.toLowerCase().equals("crispy") ||
                    bakingTechnique.toLowerCase().equals("chewy") ||
                    bakingTechnique.toLowerCase().equals("homemade")) {
                this.bakingTechnique = bakingTechnique;
            } else {
                throw new NumberFormatException("Invalid type of dough.");
            }
        }

        public double calculateCalories() {
            Double result = this.weight * 2;

            switch (flourType.toLowerCase()) {
                case "white":
                    result *= 1.5d;
                    break;
                case "wholegrain":
                    result *= 1d;
            }

            switch (this.bakingTechnique.toLowerCase()) {
                case "crispy":
                    result *= 0.9d;
                    break;
                case "chewy":
                    result *= 1.1d;
                    break;
                case "homemade":
                    result *= 1.0d;
                    break;
            }
            return result;
        }
    }
}
