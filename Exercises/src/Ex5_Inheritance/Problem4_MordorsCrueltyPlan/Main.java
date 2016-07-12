package Ex5_Inheritance.Problem4_MordorsCrueltyPlan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Niki on 29.6.2016 г..
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String input = sc.readLine().replaceAll(";", "");
        String[] data = input.trim().split("\\s+");

        long points = 0;
        for (int i = 0; i < data.length; i++) {
            String currFood = data[i].trim();

            switch (currFood.toLowerCase()){
                case "cram":
                    points += 2l;
                    break;
                case "lembas":
                    points += 3l;
                    break;
                case "apple":
                    points += 1l;
                    break;
                case "melon":
                    points += 1l;
                    break;
                case "honeycake":
                    points += 5l;
                    break;
                case "mushrooms":
                    points += -10l;
                    break;
                default:
                    points -= 1l;
                    break;
            }
        }
        System.out.println(points);
        if (points < -5){
            System.out.println("Angry");
        } else if (points < 0){
            System.out.println("Sad");
        } else if(points <= 15){
            System.out.println("Happy");
        } else {
            System.out.println("JavaScript");
        }
    }
}
