package Ex4_Encapsulation.Problem1_ClassBox;

/**
 * Created by Niki on 27.6.2016 г..
 */
public class Box {
    private double length;
    private double width;
    private double height;
    private boolean unvalidBox = false;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length) {
        if (length < 0){
            System.out.println("Length cannot be zero or negative.");
            unvalidBox = true;
            return;
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if (width < 0){
            System.out.println("Width cannot be zero or negative.");
            unvalidBox = true;
            return;
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if (height < 0){
            System.out.println("Height cannot be zero or negative.");
            unvalidBox = true;
            return;
        }
        this.height = height;
    }

    public double getSurfaceArea(){
        return (2 * this.length * this.width) + (2 * this.length * this.height) + (2 * this.width * this.height);
    }

    public double getLateralSurfaceArea(){
        return (2 * this.length * this.height) + (2 * this.width * this.height);
    }

    public double getVolume(){
        return this.length * this.height * this.width;
    }

    public boolean isUnvalidBox() {
        return unvalidBox;
    }
}
