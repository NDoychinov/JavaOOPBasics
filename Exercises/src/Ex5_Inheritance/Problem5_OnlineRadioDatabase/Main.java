package Ex5_Inheritance.Problem5_OnlineRadioDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niki on 30.6.2016 г..
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int lineCount = Integer.parseInt(sc.readLine());
        List<Database> songData = new ArrayList<>();

        for (int i = 0; i < lineCount; i++) {
            String[] data = sc.readLine().trim().split(";");

            String artistName = data[0].trim();
            String songName = data[1].trim();
            String time = data[2].trim();

            try {
                Database database = new Database(artistName, songName, time);
                songData.add(database);
                System.out.println("Song added.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Songs added: " + songData.size());
        System.out.print("Playlist length: ");
        System.out.println(Database.getListLength(songData));
    }
}
