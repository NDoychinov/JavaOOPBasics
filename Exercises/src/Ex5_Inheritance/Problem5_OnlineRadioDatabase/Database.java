package Ex5_Inheritance.Problem5_OnlineRadioDatabase;

import java.util.List;

/**
 * Created by Niki on 30.6.2016 г..
 */
public class Database {

    private String artistName;
    private String songName;
    private long lengthInSecs;

    public Database(String artistName, String songName, String time) {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setLengthInSecs(formatTimeToSeconds(time));
    }

    private void setArtistName(String artistName) {
        if (artistName == null || artistName.length() < 3 || artistName.length() > 20) {
            throw new IllegalArgumentException("Artist name should be between 3 and 20 symbols.");
        }
        this.artistName = artistName;
    }

    private void setSongName(String songName) {
        if (songName == null || songName.length() < 3 || songName.length() > 30) {
            throw new IllegalArgumentException("Song name should be between 3 and 30 symbols.");
        }
        this.songName = songName;
    }

    private void setLengthInSecs(long lengthInSecs) {
        this.lengthInSecs = lengthInSecs;
    }

    private static long formatTimeToSeconds(String time) {
        String[] data = time.trim().split(":");
        int minutes = 0;
        int seconds = 0;
        try {
            minutes = Integer.parseInt(data[0]);
            seconds = Integer.parseInt(data[1]);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Invalid song length.");
        }

        if (minutes < 0 || minutes > 14) {
            throw new IllegalArgumentException("Song minutes should be between 0 and 14.");
        }
        if (seconds < 0 || seconds > 59) {
            throw new IllegalArgumentException("Song seconds should be between 0 and 59.");
        }

        long totalSeconds = (minutes * 60) + seconds;
        return totalSeconds;
    }

    private long getLengthInSecs() {
        return lengthInSecs;
    }

    public static String getListLength(List<Database> songs) {
        long totalSeconds = 0l;

        for (int i = 0; i < songs.size(); i++) {
            totalSeconds += songs.get(i).getLengthInSecs();
        }

        long minutes = totalSeconds / 60;
        totalSeconds = totalSeconds - (minutes * 60);
        long hours = minutes / 60;
        minutes = minutes - (hours * 60);

        return String.format("%sh %sm %ss", hours, minutes, totalSeconds);
    }
}
