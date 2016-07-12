package Ex4_Encapsulation.Problem1_ClassBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Niki on 27.6.2016 г..
 */
public class ClassBox {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        double length = Double.parseDouble(sc.readLine());
        double width = Double.parseDouble(sc.readLine());
        double height = Double.parseDouble(sc.readLine());
        System.out.println(3);
        Box myBox = new Box(length, width, height);

        if (!myBox.isUnvalidBox()) {
            System.out.printf("Surface Area - %.2f%n", myBox.getSurfaceArea());
            System.out.printf("Lateral Surface Area - %.2f%n", myBox.getLateralSurfaceArea());
            System.out.printf("Volume - %.2f%n", myBox.getVolume());
        }
    }
}
