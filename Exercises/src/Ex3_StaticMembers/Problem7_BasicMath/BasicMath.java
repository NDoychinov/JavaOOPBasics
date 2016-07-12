package Ex3_StaticMembers.Problem7_BasicMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Niki on 24.6.2016 г..
 */
public class BasicMath {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String input = sc.readLine();
        while (!input.equals("End")){
            String[] data = input.split("\\s+");
            String action = data[0];
            Double num1 = Double.parseDouble(data[1]);
            Double num2 = Double.parseDouble(data[2]);

            Double result = 0d;
            if (action.equals("Sum")){
                result = MathUtil.Sum(num1, num2);
            } else if (action.equals("Subtract")){
                result = MathUtil.Subtract(num1, num2);
            }  else if (action.equals("Multiply")){
                result = MathUtil.Multiply(num1, num2);
            } else if (action.equals("Divide")){
                result = MathUtil.Divide(num1, num2);
            } else if (action.equals("Percentage")){
                result = MathUtil.Percentage(num1, num2);
            }
            System.out.printf("%.2f%n", result);

            input = sc.readLine();
        }
    }
}
