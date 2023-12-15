import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);

        Utilities utilities = new Utilities();
        Standings standings = new Standings();
        RaceManager raceManager = new RaceManager();

        String reset = "\u001B[0m";
        String red = "\u001B[31m";
        String green = "\u001B[32m";
        String yellow = "\u001B[33m";
        String cyan = "\u001B[36m";

        String[] welcome = {
            " _    _      _                            _",
            "| |  | |    | |                          | |",
            "| |  | | ___| | ___ ___  _ __ ___   ___  | |_ ___",
            "| |/\\| |/ _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\",
            "\\  /\\  /  __/ | (_| (_) | | | | | |  __/ | || (_) |",
            " \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/",
            "",
            "",
            "______ __    _____ _               _  __ _           _   _               _____           _",
            "|  ___/  |  /  __ \\ |             (_)/ _(_)         | | (_)             /  ___|         | |",
            "| |_  `| |  | /  \\/ | __ _ ___ ___ _| |_ _  ___ __ _| |_ _  ___  _ __   \\ `--. _   _ ___| |_ ___ _ __ ___",
            "|  _|  | |  | |   | |/ _` / __/ __| |  _| |/ __/ _` | __| |/ _ \\| '_ \\   `--. \\ | | / __| __/ _ \\ '_ ` _ \\",
            "| |   _| |_ | \\__/\\ | (_| \\__ \\__ \\ | | | | (_| (_| | |_| | (_) | | | | /\\__/ / |_| \\__ \\ ||  __/ | | | | |",
            "\\_|   \\___/  \\____/_|\\__,_|___/___/_|_| |_|\\___\\__,_|\\__|_|\\___/|_| |_| \\____/ \\__, |___/\\__\\___|_| |_| |_|",
            "                                                                                __/ |",
            "                                                                               |___/",
            "",
            ""
        };

        // Adding colors to welcome message

        for (int i = 0; i < welcome.length; i++) {
            if (i < 4) {
                welcome[i] = red + welcome[i] + reset;
            } else if (i < 7) {
                welcome[i] = cyan + welcome[i] + reset;
            } else if (i < 12) {
                welcome[i] = green + welcome[i] + reset;
            } else if (i < 17) {
                welcome[i] = yellow + welcome[i] + reset;
            }
        }

        for (String line : welcome) {
            System.out.println(line);
        }


        // Check if setup exists and run setup if it doesn't
        
        File file = new File("teams.ser");
        File file2 = new File("drivers.ser");

        if (!file.exists() && !file2.exists()) {
            System.out.println("Setup not found! Running setup...");
            utilities.setup();
        }

        boolean exit = false; 

        // Main menu

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
