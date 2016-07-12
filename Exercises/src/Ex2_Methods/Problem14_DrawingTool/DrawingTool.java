package Ex2_Methods.Problem14_DrawingTool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Niki on 22.6.2016 г..
 */
public class DrawingTool {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String figure = sc.readLine();
        int width = Integer.parseInt(sc.readLine());
        int height = 0;

        if (figure.equals("Square")){
            height = width;
        } else {
            height = Integer.parseInt(sc.readLine());
        }

        for (int i = 0; i < height; i++) {
            if (i == 0 || i == height - 1){
                System.out.printf("|%s|%n", charRepeator('-', width));
            } else {
                System.out.printf("|%s|%n", charRepeator(' ', width));
            }
        }
    }

    public static String charRepeator(Character ch, int count){
        StringBuilder str = new StringBuilder("");
        for (int i = 0; i < count; i++) {
            str.append(ch);
        }
        return str.toString();
    }
}
