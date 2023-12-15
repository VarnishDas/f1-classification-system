import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);

        Utilities utilities = new Utilities();
        Standings standings = new Standings();
        RaceManager raceManager = new RaceManager();

        File file = new File("teams.ser");
        File file2 = new File("drivers.ser");

        if (!file.exists() && !file2.exists()) {
            System.out.println("Setup not found! Running setup...");
            utilities.setup();
        }

        boolean exit = false; 

        while (!exit) {
            System.out.println("MENU\n1: New Race\n2: View Driver's Standings\n3: View Team's Standings\n4: Exit");            
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    raceManager.newRace();
                    break;
                case "2":
                    standings.viewDriverStandings();
                    break;
                case "3":
                    standings.viewTeamStandings();
                    break;
                case "4":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
