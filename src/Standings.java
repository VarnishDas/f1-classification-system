import java.io.*;
import java.util.*;

public class Standings {
    public void viewDriverStandings() throws IOException, ClassNotFoundException {
        Utilities utilities = new Utilities();

        ArrayList<Driver> drivers = utilities.fromFiles("drivers.ser");

        // Sort drivers by total points

        for (int i = 0; i < drivers.size()-1; i++) {
            for (int j = 0; j < drivers.size()-i-1; j++) {
                if (drivers.get(j).totalPoints < drivers.get(j+1).totalPoints) {
                    Driver temp = drivers.get(j);
                    drivers.set(j, drivers.get(j+1));
                    drivers.set(j+1, temp);
                }
            }
        }

        System.out.println("┌──────────┬────────────────────┬──────────┬────────────────────┐");
        System.out.println("│  Position│                Name│    Points│                Team│");
        System.out.println("├──────────┼────────────────────┼──────────┼────────────────────┤");

        for (int i = 0; i < drivers.size(); i++) {
            System.out.printf("│%10d│%20s│%10d│%20s│\n", i+1, drivers.get(i).name, drivers.get(i).totalPoints, drivers.get(i).team.name);
        }

        System.out.println("└──────────┴────────────────────┴──────────┴────────────────────┘");
    }

    public void viewTeamStandings() throws IOException, ClassNotFoundException {
        Utilities utilities = new Utilities();

        ArrayList<Team> teams = utilities.fromFiles("teams.ser");

        // Sort teams by total points

        for (int i = 0; i < teams.size()-1; i++) {
            for (int j = 0; j < teams.size()-i-1; j++) {
                if (teams.get(j).totalPoints < teams.get(j+1).totalPoints) {
                    Team temp = teams.get(j);
                    teams.set(j, teams.get(j+1));
                    teams.set(j+1, temp);
                }
            }
        }

        System.out.println("┌──────────┬────────────────────┬──────────┐");
        System.out.println("│  Position│                Name│    Points│");
        System.out.println("├──────────┼────────────────────┼──────────┤");

        for (int i = 0; i < teams.size(); i++) {
            System.out.printf("│%10d│%20s│%10d│\n", i+1, teams.get(i).name, teams.get(i).totalPoints);
        }

        System.out.println("└──────────┴────────────────────┴──────────┘");
    }
}
