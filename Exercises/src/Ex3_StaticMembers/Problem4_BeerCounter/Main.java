package Ex3_StaticMembers.Problem4_BeerCounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Niki on 24.6.2016 г..
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String input = sc.readLine();

        while (!input.equals("End")){
            String[] data = input.split("\\s+");
            int buy = Integer.parseInt(data[0]);
            int drink = Integer.parseInt(data[1]);
            BeerCounter.BuyBeer(buy);
            BeerCounter.DrinkBeer(drink);

            input = sc.readLine();
        }

        System.out.printf("%s %s", BeerCounter.beerInStock, BeerCounter.beersDrankCount);
    }
}
