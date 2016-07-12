package Ex3_StaticMembers.Problem3_TemperatureConverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Niki on 24.6.2016 г..
 */
class Convert {
    public static void CelsiusToFahrenheit(Double degrees) {
        System.out.printf("%.2f Fahrenheit%n", degrees * 1.8d + 32);
    }

    public static void FahrenheitToCelsius(Double degrees) {
        System.out.printf("%.2f Celsius%n", (degrees - 32) / 1.8);
    }

}

public class TemperatureConverter {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String input = sc.readLine();

        while (!input.equals("End")){
            String[] data = input.split("\\s+");
            Double degrees = Double.parseDouble(data[0]);
            String unit = data[1];

            if (unit.equals("Celsius")){
                Convert.CelsiusToFahrenheit(degrees);
            }else if (unit.equals("Fahrenheit")){
                Convert.FahrenheitToCelsius(degrees);
            }

            input = sc.readLine();
        }
    }
}
