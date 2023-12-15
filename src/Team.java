import java.io.*;

// Team class

public class Team implements Serializable {
    public String name;
    public String abv;
    public int totalPoints;

    Team (String name, String abv, int totalPoints) {
        this.name = name;
        this.abv = abv;
        this.totalPoints = 0;
    }

    public void addPoints(int points) {
        this.totalPoints+=points;
    }
}
