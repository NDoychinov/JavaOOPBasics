package Ex5_Inheritance.Problem2_BookShop;

/**
 * Created by Niki on 29.6.2016 г..
 */
public class GoldenEditionBook extends Book {

    public GoldenEditionBook(String author, String title, double price) {
        super(author, title, price);
    }

    @Override
    protected double getPrice() {
        return super.getPrice() + (super.getPrice() * 0.3d);
    }
}
