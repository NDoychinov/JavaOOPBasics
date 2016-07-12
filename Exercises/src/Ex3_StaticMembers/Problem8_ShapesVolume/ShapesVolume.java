package Ex3_StaticMembers.Problem8_ShapesVolume;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Niki on 24.6.2016 г..
 */
public class ShapesVolume {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String input = sc.readLine();

        while (!input.equals("End")) {
            String[] data = input.split("\\s+");

            if (data.length == 2) {
                System.out.printf("%.3f%n",
                        VolumeCalculator.VolumeCube(new Cube(Double.parseDouble(data[1]))));
            } else if (data.length == 3) {
                System.out.printf("%.3f%n",
                        VolumeCalculator.CylinderVolume(new Cylinder(Double.parseDouble(data[1]),
                                Double.parseDouble(data[2]))));
            } else if (data.length == 4){
                System.out.printf("%.3f%n",
                        VolumeCalculator.TrianglePrismVolume(new TriangularPrism(Double.parseDouble(data[1]),
                                Double.parseDouble(data[2]), Double.parseDouble(data[3]))));
            }

            input = sc.readLine();
        }
    }
}
