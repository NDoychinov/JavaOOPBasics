package Furnishings;

/**
 * Created by Niki on 9.7.2016 г..
 */
public abstract class Furnishing {
    private double elCost;

    protected Furnishing(double elCost) {
        this.setElCost(elCost);
    }

    private void setElCost(double elCost) {
        this.elCost = elCost;
    }

    public double getElCost() {
        return elCost;
    }
}
