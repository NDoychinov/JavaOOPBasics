package Ex4_Encapsulation.Problem6_FootballTeamGenerator;

/**
 * Created by Niki on 28.6.2016 г..
 */
public class Player {

    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    private void setName(String name) {
        if (!name.equals("") && !name.equals(" ")) {
            this.name = name;
        } else {
            throw new NumberFormatException("A name should not be empty.");
        }
    }

    private void setEndurance(int endurance) {
        if (endurance >= 0 && endurance <= 100) {
            this.endurance = endurance;
        } else {
            throw new NumberFormatException("Endurance should be between 0 and 100.");
        }
    }

    private void setSprint(int sprint) {
        if (sprint >= 0 && sprint <= 100) {
            this.sprint = sprint;
        } else {
            throw new NumberFormatException("Sprint should be between 0 and 100.");
        }
    }

    private void setDribble(int dribble) {
        if (dribble >= 0 && dribble <= 100) {
            this.dribble = dribble;
        } else {
            throw new NumberFormatException("Dribble should be between 0 and 100.");
        }
    }

    private void setPassing(int passing) {
        if (passing >= 0 && passing <= 100) {
            this.passing = passing;
        } else {
            throw new NumberFormatException("Passing should be between 0 and 100.");
        }
    }

    private void setShooting(int shooting) {
        if (shooting >= 0 && shooting <= 100) {
            this.shooting = shooting;
        } else {
            throw new NumberFormatException("Shooting should be between 0 and 100.");
        }
    }

    public int getPlayerRating() {
        Double sum = (endurance + sprint + shooting + passing + dribble) / 5d;
        return (int) Math.round(sum);
    }

    public String getName() {
        return name;
    }
}
