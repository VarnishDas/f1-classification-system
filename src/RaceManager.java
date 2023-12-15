import java.io.*;
import java.util.*;

public class RaceManager {
    public void newRace() throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        
        Utilities utilities = new Utilities();

        ArrayList<Team> teams = utilities.fromFiles("teams.ser");
        ArrayList<Driver> drivers = utilities.fromFiles("drivers.ser");

        for (Driver driver : drivers) {
            for (Team team : teams) {
                if (driver.team.abv.equals(team.abv)) { 
                    driver.team = team;
                    break;
                }
            }
        }        

        int points[] = {25, 18, 15, 12, 10, 8, 6, 4, 2, 1};

        System.out.println("Enter abbreviation/name of driver who got the fastest lap: ");
        String fastestLap = scanner.nextLine();

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter abbreviation/name of driver who came " + (i+1) + ": ");
            String driver = scanner.nextLine();

            for (int j = 0; j < drivers.size(); j++) {
                if (drivers.get(j).abv.equalsIgnoreCase(driver) || drivers.get(j).name.equalsIgnoreCase(driver)) {
                    drivers.get(j).addPoints(points[i]);
                    drivers.get(j).team.addPoints(points[i]);

                    if (fastestLap.equalsIgnoreCase(driver) || fastestLap.equalsIgnoreCase(driver)) {
                        drivers.get(j).addPoints(1);
                        drivers.get(j).team.addPoints(1);
                    }
                }
            }
        }

        utilities.toFiles("teams.ser", teams);
        utilities.toFiles("drivers.ser", drivers);


    }
}
