package Ex4_Encapsulation.Problem6_FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niki on 28.6.2016 г..
 */
public class FootballTeam {

    private List<Player> teamPlayers;
    private String name;
    private int rating;

    public FootballTeam(String name) {
        this.name = name;
        this.teamPlayers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (!name.equals("") && !name.equals(" ")) {
            this.name = name;
        } else {
            throw new NumberFormatException("A name should not be empty.");
        }
    }

    public void addPlayer(Player player) {
        this.teamPlayers.add(player);
    }

    public int getTeamRating() {
        if (teamPlayers.size() > 0) {
            int sum = 0;
            for (int i = 0; i < this.teamPlayers.size(); i++) {
                sum += teamPlayers.get(i).getPlayerRating();
            }

            return sum / teamPlayers.size();
        }
        return 0;
    }

    public List<Player> getTeamPlayers() {
        return this.teamPlayers;
    }
}
