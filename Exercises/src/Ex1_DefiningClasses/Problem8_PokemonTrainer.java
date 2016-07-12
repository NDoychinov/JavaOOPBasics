package Ex1_DefiningClasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Niki on 21.6.2016 г..
 */
class Trainer {
    String name;
    int badgesAmount;
    List<Pokemon> pokemonList;

    Trainer(String name, Pokemon pokemon) {
        this.name = name;
        this.badgesAmount = badgesAmount;
        this.pokemonList = new ArrayList<>();
        this.pokemonList.add(pokemon);
        this.badgesAmount = 0;
    }

}

class Pokemon {
    String name;
    String element;
    int health;

    Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }
}

public class Problem8_PokemonTrainer {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        List<Trainer> trainerList = new ArrayList<>();
        List<String> names = new ArrayList<>();

        String input = sc.readLine();
        while (!input.equals("Tournament")) {
            String[] data = input.split("\\s+");

            if (!names.contains(data[0])) {
                trainerList.add(new Trainer(data[0], new Pokemon(data[1], data[2], Integer.parseInt(data[3]))));
                names.add(data[0]);
            } else {
                for (int i = 0; i < trainerList.size(); i++) {
                    Trainer currTrainer = trainerList.get(i);
                    if (currTrainer.name.equals(data[0])){
                        currTrainer.pokemonList.add(new Pokemon(data[1], data[2], Integer.parseInt(data[3])));
                    }
                }
            }
            input = sc.readLine();
        }
        
        input = sc.readLine();

        while (!input.equals("End")) {

            for (int i = 0; i < trainerList.size(); i++) {

                boolean hasElement = false;
                for (int j = 0; j < trainerList.get(i).pokemonList.size(); j++) {
                    if (trainerList.get(i).pokemonList.get(j).element.equals(input)){
                        trainerList.get(i).badgesAmount += 1;
                        hasElement = true;
                        break;
                    }
                }
                if (!hasElement){
                    for (int j = 0; j < trainerList.get(i).pokemonList.size(); j++) {
                        trainerList.get(i).pokemonList.get(j).health -= 10;
                        if (trainerList.get(i).pokemonList.get(j).health <= 0){
                            trainerList.get(i).pokemonList.remove(j);
                            j--;
                        }
                    }
                }
            }

            input = sc.readLine();
        }

        Collections.sort(trainerList, (s1, s2) -> Integer.compare(s2.badgesAmount, s1.badgesAmount));
        for (int i = 0; i < trainerList.size(); i++) {
            Trainer currTrainer = trainerList.get(i);
            System.out.printf("%s %d %d%n", currTrainer.name, currTrainer.badgesAmount, currTrainer.pokemonList.size());
        }
    }
}
