package Ex6_Polymorphism.Problem3_WildFarm.Foods;

/**
 * Created by Niki on 4.7.2016 г..
 */
public abstract class Food {
    private Integer quantity;

    protected Food(Integer quantity) {
        this.setQuantity(quantity);
    }

    private void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
