package Ex2_Methods.Problem10_DateModifier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Niki on 23.6.2016 г..
 */

class DateModifier {

    private int dateDiff;
    String date1;
    String date2;

    DateModifier(String date1, String date2) throws ParseException {
        this.date1 = date1;
        this.date2 = date2;
    }

    public long getDifferenceDays() throws ParseException {
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        String[] data = date1.split("\\s+");
        start.set(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));

        data = date2.split("\\s+");
        end.set(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
        Date startDate = start.getTime();
        Date endDate = end.getTime();
        long startTime = startDate.getTime();
        long endTime = endDate.getTime();
        long diffTime = endTime - startTime;
        long diffDays = diffTime / (1000 * 60 * 60 * 24);
        DateFormat dateFormat = DateFormat.getDateInstance();
        return diffDays;
    }

}

public class Pr_DateModifier {

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String date1 = sc.readLine();
        String date2 = sc.readLine();
        DateModifier modifier = new DateModifier(date1, date2);

        System.out.println(Math.abs(modifier.getDifferenceDays()));

    }
}
