package Ex2_Methods.Problem3_LastDigitName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Niki on 22.6.2016 г..
 */
class Number{
    private long num;
    Number(long num){
        this.num = num;
    }

    String lastDigitName(){
        long lastDigit = Math.abs(this.num % 10l);

        switch ((int)lastDigit){
            case 0:
                return "zero";
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            default:
                return "";
        }
    }
}

public class LastDigitName {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        long number = Long.parseLong(sc.readLine().trim());

        Number num = new Number(number);
        System.out.println(num.lastDigitName());
    }
}
