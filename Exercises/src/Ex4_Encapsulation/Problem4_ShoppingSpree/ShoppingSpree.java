package Ex4_Encapsulation.Problem4_ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niki on 27.6.2016 г..
 */
public class ShoppingSpree {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        List<Person> personList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();

        String[] data = sc.readLine().trim().split(";");
        for (int i = 0; i < data.length; i++) {
            String[] splitted = data[i].trim().split("=");
            if (!splitted[0].equals("") && Double.parseDouble(splitted[1]) >= 0) {
                personList.add(new Person(splitted[0], Double.parseDouble(splitted[1])));
            } else if (splitted[0].equals("")){
                System.out.println("Name cannot be empty");
                return;
            } else {
                System.out.println("Money cannot be negative");
                return;
            }
        }

        data = sc.readLine().trim().split(";");
        for (int i = 0; i < data.length; i++) {
            String[] splitted = data[i].trim().split("=");
            if (Double.parseDouble(splitted[1]) >= 0) {
                productList.add(new Product(splitted[0], Double.parseDouble(splitted[1])));
            } else {
                System.out.println("Money cannot be negative");
                return;
            }
        }

        String input = sc.readLine();

        while (!input.equals("END")) {
            data = input.split("\\s+");

            for (int i = 0; i < personList.size(); i++) {
                Person currPerson = personList.get(i);
                if (currPerson.getName().equals(data[0])) {
                    Product boughtProduct = null;
                    for (int j = 0; j < productList.size(); j++) {
                        if (productList.get(j).getName().equals(data[1])) {
                            boughtProduct = productList.get(j);
                        }
                    }
                    if (boughtProduct != null) {
                        currPerson.buyProduct(boughtProduct);
                    }
                }
            }


            input = sc.readLine();
        }

        for (int i = 0; i < personList.size(); i++) {
            Person currPerson = personList.get(i);
            currPerson.printBagProducts();
        }
    }


    public static class Product {
        private String name;
        private Double cost;

        public Product(String name, Double cost) {
            this.name = name;
            this.cost = cost;
        }

        public String getName() {
            return name;
        }

        public Double getCost() {
            return cost;
        }
    }


    public static class Person {

        private String name;
        private Double money;
        private List<Product> bagProducts;

        public Person(String name, Double money) {
            this.name = name;
            this.money = money;
            this.bagProducts = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getMoney() {
            return money;
        }

        public void setMoney(Double money) {
            this.money = money;
        }

        public void buyProduct(Product product) {
            if (this.money >= product.getCost()) {
                this.bagProducts.add(product);
                this.money -= product.getCost();
                System.out.printf("%s bought %s%n", this.name, product.getName());
            } else {
                System.out.printf("%s can't afford %s%n", this.name, product.getName());
            }
        }

        public List<Product> getBagProducts() {
            return bagProducts;
        }

        public void printBagProducts() {
            StringBuilder output = new StringBuilder("");
            output.append(this.name + " - ");

            if (this.bagProducts.size() > 0) {
                for (int i = 0; i < this.bagProducts.size(); i++) {
                    output.append(this.bagProducts.get(i).getName() + ", ");
                }
                System.out.println(output.substring(0, output.length() - 2));
            } else {
                output.append("Nothing bought");
                System.out.println(output);
            }
        }
    }
}
