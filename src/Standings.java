import java.io.*;
import java.util.*;

public class Standings {
    public void viewDriverStandings() throws IOException, ClassNotFoundException {
        Utilities utilities = new Utilities();

        ArrayList<Driver> drivers = utilities.fromFiles("drivers.ser");

        for (int i = 0; i < drivers.size()-1; i++) {
            for (int j = 0; j < drivers.size()-i-1; j++) {
                if (drivers.get(j).totalPoints < drivers.get(j+1).totalPoints) {
                    Driver temp = drivers.get(j);
                    drivers.set(j, drivers.get(j+1));
                    drivers.set(j+1, temp);
                }
            }
        }

        for (int i = 0; i < drivers.size(); i++) {
            System.out.println(drivers.get(i).name + " " + drivers.get(i).totalPoints);
        }
    }

    public void viewTeamStandings() throws IOException, ClassNotFoundException {
        Utilities utilities = new Utilities();

        ArrayList<Team> teams = utilities.fromFiles("teams.ser");

        for (int i = 0; i < teams.size()-1; i++) {
            for (int j = 0; j < teams.size()-i-1; j++) {
                if (teams.get(j).totalPoints < teams.get(j+1).totalPoints) {
                    Team temp = teams.get(j);
                    teams.set(j, teams.get(j+1));
                    teams.set(j+1, temp);
                }
            }
        }

        for (int i = 0; i < teams.size(); i++) {
            System.out.println(teams.get(i).name + " " + teams.get(i).totalPoints);
        }
    }
}
