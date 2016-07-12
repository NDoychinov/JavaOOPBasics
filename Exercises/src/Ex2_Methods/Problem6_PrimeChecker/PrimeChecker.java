package Ex2_Methods.Problem6_PrimeChecker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Niki on 22.6.2016 г..
 */
class Number{
    Integer number;
    boolean isPrime;

    Number(Integer number){
        this.number =  number;
        this.isPrime = isPrime(number);
    }

    boolean isPrime(int num) {
        if (num == 2 || num == 1 || num == 0) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
    }

    int nextPrime(){
        int currNumber = this.number;
        while (true){
            currNumber++;
            if (isPrime(currNumber)){
                return currNumber;
            }
        }
    }
}

public class PrimeChecker {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(sc.readLine());

        Number num = new Number(number);

        System.out.printf("%d, %s", num.nextPrime(), num.isPrime);
    }

}
