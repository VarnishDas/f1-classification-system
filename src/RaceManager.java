import java.io.*;
import java.util.*;

public class RaceManager {
    public void newRace() throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        
        Utilities utilities = new Utilities();

        ArrayList<Team> teams = utilities.fromFiles("teams.ser");
        ArrayList<Driver> drivers = utilities.fromFiles("drivers.ser");

        utilities.Sync(drivers, teams);      

        int points[] = {25, 18, 15, 12, 10, 8, 6, 4, 2, 1};

        System.out.println("Enter abbreviation/name of driver who got the fastest lap: ");
        String fastestLap = scanner.nextLine();

        Driver fastestDriver = null;

        boolean displayNotExistMessage = true; 

        while (fastestDriver == null) {
            fastestDriver = utilities.doesDriverExist(drivers, fastestLap);

            if (fastestDriver == null) {

                if (displayNotExistMessage) {
                    System.out.println("Driver does not exist!");
                }

                System.out.println("1: Add new driver\n2: Try again");

                switch (scanner.nextLine()) {
                    case "1":
                        fastestDriver = utilities.addDriver(drivers, teams);
                        break;
                    case "2":
                        System.out.println("Enter abbreviation/name of driver who got the fastest lap: ");
                        scanner.nextLine();
                        fastestLap = scanner.nextLine();
                        break;
                    default:
                        System.out.println("Invalid choice!");
                        displayNotExistMessage = false;
                        break;
                }
                fastestLap = scanner.nextLine();
            }
        }

        boolean displayNotExistMessage2 = true;

        HashSet<String> selectedDrivers = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter abbreviation/name of driver who came " + (i+1) + ": ");
            String driver = scanner.nextLine();

            Driver foundDriver = null;

            while (foundDriver == null) {
                foundDriver = utilities.doesDriverExist(drivers, driver);

                if (foundDriver != null) {
                    if (selectedDrivers.contains(foundDriver.abv)) {
                        System.out.println("Driver already selected! Enter a different driver: ");
                        foundDriver = null;
                        displayNotExistMessage2 = false;
                    }       
                }

                if (foundDriver == null) {

                    if (displayNotExistMessage2) {
                        System.out.println("Driver does not exist!");
                    }

                    displayNotExistMessage2 = true;

                    System.out.println("1: Add new driver\n2: Try again");

                    switch (scanner.nextLine()) {
                        case "1":
                            foundDriver = utilities.addDriver(drivers, teams);
                            break;
                        case "2":
                            System.out.println("Enter abbreviation/name of driver who came " + (i+1) + ": ");
                            scanner.nextLine();
                            driver = scanner.nextLine();
                            break;
                        default:
                            System.out.println("Invalid choice!");
                            displayNotExistMessage2 = false;
                            break;
                    }
                }
            }

            selectedDrivers.add(foundDriver.abv);

            foundDriver.addPoints(points[i]);
            foundDriver.team.addPoints(points[i]);

            if (fastestLap.equalsIgnoreCase(driver) || fastestLap.equalsIgnoreCase(driver)) {
                foundDriver.addPoints(1);
                foundDriver.team.addPoints(1);
            }
        }

        utilities.toFiles("teams.ser", teams);
        utilities.toFiles("drivers.ser", drivers);


    }
}
