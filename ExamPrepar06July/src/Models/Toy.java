package Models;

/**
 * Created by Niki on 9.7.2016 г..
 */
public class Toy {

    private double price;

    public Toy(double price) {
        this.setPrice(price);
    }

    private void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
