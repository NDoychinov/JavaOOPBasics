package Ex2_Methods.Problem4_NumberInReversedOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Niki on 22.6.2016 г..
 */

class DecimalNumber{
    String number;

    public DecimalNumber(String number) {
        this.number = number;
    }

    StringBuilder reversedDecimal(){
        StringBuilder reversed = new StringBuilder("");

        for (int i = number.length() - 1; i >= 0; i--) {
            reversed.append(number.charAt(i));
        }
        return reversed;
    }
}

public class NumberInReversedOrder {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        DecimalNumber number = new DecimalNumber(sc.readLine());
        System.out.println(number.reversedDecimal());
    }
}
