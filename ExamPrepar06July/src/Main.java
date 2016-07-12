import Families.*;
import Furnishings.Fridge;
import Furnishings.Laptop;
import Furnishings.Stove;
import Furnishings.TV;
import Homes.Home;
import Models.Children;
import Models.OldMan;
import Models.Toy;
import Models.YoungMan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Niki on 10.7.2016 г..
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        List<Home> homeList = new ArrayList<>();
        String regex = "\\((.*?)\\)";
        Pattern pattern = Pattern.compile(regex);

        String input = sc.readLine().trim();
        int monthCount = 0;
        while (!input.equals("Democracy")) {
            monthCount++;

            if (!input.equals("EVN bill") && !input.equals("EVN")) {
                String familyType = input.substring(0, input.indexOf('(')).trim();
                Home home = null;


                Matcher matcher = pattern.matcher(input);
                String[] data = null;
                switch (familyType) {
                    case "YoungCouple":
                        home = new YoungCouple();

                        matcher.find();
                        data = matcher.group(1).split("[, ]+");

                        home.addMember(new YoungMan(Double.parseDouble(data[0])));
                        home.addMember(new YoungMan(Double.parseDouble(data[1])));

                        matcher.find();
                        home.addFurnishing(new TV(Double.parseDouble(matcher.group(1))));
                        matcher.find();
                        home.addFurnishing(new Fridge(Double.parseDouble(matcher.group(1))));
                        matcher.find();
                        home.addFurnishing(new Laptop(Double.parseDouble(matcher.group(1))));
                        home.addFurnishing(new Laptop(Double.parseDouble(matcher.group(1))));

                        homeList.add(home);
                        break;

                    case "YoungCoupleWithChildren":
                        home = new YoungCoupleWithChildren();

                        matcher.find();
                        data = matcher.group(1).split("[, ]+");

                        home.addMember(new YoungMan(Double.parseDouble(data[0])));
                        home.addMember(new YoungMan(Double.parseDouble(data[1])));

                        matcher.find();
                        home.addFurnishing(new TV(Double.parseDouble(matcher.group(1))));
                        matcher.find();
                        home.addFurnishing(new Fridge(Double.parseDouble(matcher.group(1))));
                        matcher.find();
                        home.addFurnishing(new Laptop(Double.parseDouble(matcher.group(1))));
                        home.addFurnishing(new Laptop(Double.parseDouble(matcher.group(1))));

                        while (matcher.find()) {
                            data = matcher.group(1).split("[, ]+");
                            Children children = new Children(Double.parseDouble(data[0]));
                            for (int i = 1; i < data.length; i++) {
                                children.addToy(new Toy(Double.parseDouble(data[i])));
                            }
                            home.addChildren(children);
                        }
                        homeList.add(home);
                        break;

                    case "AloneYoung":
                        home = new AloneYoung();

                        matcher.find();
                        home.addMember(new YoungMan(Double.parseDouble(matcher.group(1))));

                        matcher.find();

                        home.addFurnishing(new Laptop(Double.parseDouble(matcher.group(1))));

                        homeList.add(home);
                        break;

                    case "OldCouple":
                        home = new OldCouple();

                        matcher.find();
                        data = matcher.group(1).split("[, ]+");

                        home.addMember(new OldMan(Double.parseDouble(data[0])));
                        home.addMember(new OldMan(Double.parseDouble(data[1])));

                        matcher.find();
                        home.addFurnishing(new TV(Double.parseDouble(matcher.group(1))));
                        matcher.find();
                        home.addFurnishing(new Fridge(Double.parseDouble(matcher.group(1))));
                        matcher.find();
                        home.addFurnishing(new Stove(Double.parseDouble(matcher.group(1))));
                        homeList.add(home);
                        break;

                    case "AloneOld":
                        home = new AloneOld();

                        matcher.find();

                        home.addMember(new OldMan(Double.parseDouble(matcher.group(1))));
                        homeList.add(home);
                        break;

                }
            }

            if (monthCount == 3) {
                for (int i = 0; i < homeList.size(); i++) {
                    homeList.get(i).paySalaries();
                }

                monthCount = 0;
            }

            if (input.equals("EVN")) {
                double totalConsumption = 0d;

                for (int i = 0; i < homeList.size(); i++) {
                    totalConsumption += homeList.get(i).getTotalConsumption();
                }
                DecimalFormat df = new DecimalFormat("0.0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
                df.setMaximumFractionDigits(340);
                System.out.printf("Total consumption: %s%n", df.format(totalConsumption));
            }

            if (input.equals("EVN bill")) {
                for (int i = 0; i < homeList.size(); i++) {
                    Home currHome = homeList.get(i);
                    try {
                        currHome.payBills();
                    } catch (IllegalArgumentException iae) {
                        homeList.remove(i);
                        i--;
                    }
                }
            }

            input = sc.readLine();
        }

        double totalPopulation = 0;
        for (int i = 0; i < homeList.size(); i++) {
            totalPopulation += homeList.get(i).livingPplCount();
        }
        System.out.printf("Total population: %.0f%n", totalPopulation);

    }
}
