import java.io.*;

// Driver class

public class Driver implements Serializable {
    public String name;
    public String abv;
    public int totalPoints;
    public Team team;

    Driver (String name, String abv, int totalPoints, Team team) {
        this.name = name;
        this.abv = abv;
        this.totalPoints = 0;
        this.team = team;
    }

    public void addPoints(int points) {
        this.totalPoints += points;
    }
}
