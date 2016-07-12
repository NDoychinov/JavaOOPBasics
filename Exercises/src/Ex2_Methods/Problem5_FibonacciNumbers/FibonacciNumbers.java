package Ex2_Methods.Problem5_FibonacciNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niki on 22.6.2016 г..
 */
class Fibonacci{
    List<Long> numbers;

    Fibonacci(int n){
        this.numbers = new ArrayList<>();

        numbers.add(0l);

        long first = 1;
        numbers.add(first);

        long second = 1;
        numbers.add(second);

        long total = 1;
        for (int i = 0; i < n - 1; i++) {
            total = first + second;
            first = second;
            second = total;
            numbers.add(total);
        }
    }

    List<Long> getNumbersInRange(int startPosition, int endPosition){
        List<Long> rangeNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (i >= startPosition && i < endPosition){
                rangeNumbers.add(numbers.get(i));
            }
            if (i > endPosition){
                break;
            }
        }
        return rangeNumbers;
    }
}

public class FibonacciNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int start = Integer.parseInt(sc.readLine());
        int end = Integer.parseInt(sc.readLine());

        Fibonacci fibonacci = new Fibonacci(end);

        List<Long> rangeNumbers = fibonacci.getNumbersInRange(start, end);
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < rangeNumbers.size(); i++) {
            output.append(String.valueOf(rangeNumbers.get(i)) + ", ");
        }
        System.out.println(output.substring(0, output.length() - 2));
    }
}
