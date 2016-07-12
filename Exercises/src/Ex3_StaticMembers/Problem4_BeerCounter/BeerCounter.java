package Ex3_StaticMembers.Problem4_BeerCounter;

/**
 * Created by Niki on 24.6.2016 г..
 */
public class BeerCounter {
    public static int beerInStock = 0;
    public static int beersDrankCount = 0;

    public static void BuyBeer(int bottlesCount){
        beerInStock += bottlesCount;

    }

    public static void DrinkBeer(int bottlesCount) {
        if (bottlesCount > beerInStock){
            bottlesCount = beerInStock;
        }
        beerInStock -= bottlesCount;
        beersDrankCount += bottlesCount;

    }
}
