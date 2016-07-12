package Ex2_Methods.Problem11_RectangleIntersection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by Niki on 23.6.2016 г..
 */
class Rectangle {

    private String id;
    private Double width;
    private Double height;
    private Double x;
    private Double y;

    public Rectangle(String id, Double width, Double height, Double xTop, Double yTop) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.x = xTop;
        this.y = yTop;
    }


    public boolean intersects(Rectangle r) {
        Double tw = this.width;
        Double th = this.height;
        Double rw = r.width;
        Double rh = r.height;

        Double tx = this.x;
        Double ty = this.y;
        Double rx = r.x;
        Double ry = r.y;
        rw += rx;
        rh += ry;
        tw += tx;
        th += ty;

        return ((rw <= rx || rw >= tx) &&
                (rh <= ry || rh >= ty) &&
                (tw <= tx || tw >= rx) &&
                (th <= ty || th >= ry));
    }

}

public class RectangleIntersection {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Rectangle> rectangleList = new HashMap<>();

        String[] input = sc.readLine().trim().split("\\s+");
        Integer n = Integer.parseInt(input[0]);
        Integer m = Integer.parseInt(input[1]);

        for (int i = 0; i < n; i++) {
            String[] data = sc.readLine().trim().split("\\s+");
            String id = data[0];
            Double width = Double.parseDouble(data[1]);
            Double height = Double.parseDouble(data[2]);
            Double topX = Double.parseDouble(data[3]);
            Double topY = Double.parseDouble(data[4]);

            rectangleList.put(id, new Rectangle(id, width, height, topX, topY));
        }

        for (int i = 0; i < m; i++) {
            String[] data = sc.readLine().trim().split("\\s+");
            String name1 = data[0];
            String name2 = data[1];

            Rectangle firstRec = rectangleList.get(name1);
            Rectangle secondRec = rectangleList.get(name2);

            System.out.println(firstRec.intersects(secondRec));
        }
    }
}