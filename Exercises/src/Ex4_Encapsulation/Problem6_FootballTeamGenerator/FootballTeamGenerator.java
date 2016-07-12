package Ex4_Encapsulation.Problem6_FootballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niki on 28.6.2016 г..
 */
public class FootballTeamGenerator {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        List<FootballTeam> teamList = new ArrayList<>();
        String input = sc.readLine().trim();

        while (!input.equals("END")) {
            String[] data = input.split(";");

            switch (data[0].toLowerCase()) {
                case "team":
                    try {
                        FootballTeam team = new FootballTeam(data[1]);
                        teamList.add(team);
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "add":
                    String teamName = data[1];
                    String playerName = data[2];
                    int playerEndurance = Integer.parseInt(data[3]);
                    int playerSprint = Integer.parseInt(data[4]);
                    int playerDribble = Integer.parseInt(data[5]);
                    int playerPassing = Integer.parseInt(data[6]);
                    int playerShooting = Integer.parseInt(data[7]);
                    boolean isTeamMissing = true;
                    for (int i = 0; i < teamList.size(); i++) {
                        FootballTeam currTeam = teamList.get(i);
                        if (currTeam.getName().equals(teamName)) {
                            isTeamMissing = false;
                            try {
                                Player player = new Player(playerName, playerEndurance,
                                        playerSprint, playerDribble,
                                        playerPassing, playerShooting);
                                currTeam.addPlayer(player);
                            } catch (NumberFormatException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                    if (isTeamMissing) {
                        System.out.printf("Team %s does not exist.%n", teamName);
                    }
                    break;

                case "remove":
                    teamName = data[1];
                    playerName = data[2];
                    boolean isPlayerMissing = true;
                    for (int i = 0; i < teamList.size(); i++) {
                        FootballTeam currTeam = teamList.get(i);
                        if (currTeam.getName().equals(teamName)) {
                            for (int j = 0; j < currTeam.getTeamPlayers().size(); j++) {
                                Player currPlayer = currTeam.getTeamPlayers().get(j);
                                if (currPlayer.getName().equals(playerName)) {
                                    isPlayerMissing = false;
                                    currTeam.getTeamPlayers().remove(j);
                                    j--;
                                }
                            }
                        }
                    }
                    if (isPlayerMissing) {
                        System.out.printf("Player %s is not in %s team.%n", playerName, teamName);
                    }
                    break;

                case "rating":
                    teamName = data[1];
                    boolean hasSuchTeam = teamList.
                            stream().anyMatch(t -> t.getName().equals(teamName));
                    if (hasSuchTeam) {
                        FootballTeam team = teamList.stream()
                                .filter(t -> t.getName().equals(teamName)).
                                        findFirst().get();
                        System.out.printf("%s - %d%n", teamName, team.getTeamRating());
                    } else {
                        System.out.printf("Team %s does not exist.%n", teamName);
                    }
                    break;
            }

            input = sc.readLine().trim();
        }
    }
}
