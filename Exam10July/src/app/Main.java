package app;

import app.Commands.CommandInterpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Niki on 10.7.2016 г..
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Configuration configuration = new Configuration();
        CommandInterpreter interpreter = new CommandInterpreter(configuration);

        String input = sc.readLine().trim();

        while (!input.equals("System Split")) {
            String command = input.substring(0, input.indexOf('(')).trim();
            String parameters = input.substring(input.indexOf('(') + 1, input.indexOf(')')).trim();
            String[] data = parameters.split("[, ]+");

            interpreter.command(command, data);

            input = sc.readLine().trim();
        }

        configuration.printSystemSplit();
    }
}
