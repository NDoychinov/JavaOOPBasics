package Ex2_Methods.Problem9_PizzaTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Niki on 23.6.2016 г..
 */
class Pizza {
    private String name;
    private int group;

    public Pizza(String name, int group) {
        this.name = name;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public int getGroup() {
        return group;
    }
}


public class PizzaTime {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String regex = "([0-9]+)(.*)";
        Pattern pattern = Pattern.compile(regex);
        List<Pizza> pizzaList = new ArrayList<>();

        String[] data = sc.readLine().split("\\s+");
        for (int i = 0; i < data.length; i++) {
            Matcher matcher = pattern.matcher(data[i]);
            if (matcher.find()) {
                int group = Integer.parseInt(matcher.group(1));
                String pizzaName = matcher.group(2);
                pizzaList.add(new Pizza(pizzaName, group));
            }
        }
        
        Map<Integer, List<String>> occurrences = getOccurrences(pizzaList);

        for (Map.Entry<Integer, List<String>> integerListEntry : occurrences.entrySet()) {
            System.out.printf("%d - %s%n", integerListEntry.getKey(), String.join(", ", integerListEntry.getValue()));
        }
    }

    public static Map<Integer, List<String>> getOccurrences(List<Pizza> pizzaList){
        HashMap<Integer, List<String>> map = new HashMap<>();

        for (int i = 0; i < pizzaList.size(); i++) {
            Pizza currPizza = pizzaList.get(i);
            if (!map.containsKey(currPizza.getGroup())){
                map.put(currPizza.getGroup(), new ArrayList<>());
            }
            map.get(currPizza.getGroup()).add(currPizza.getName());
        }
        return map;
    }

}
