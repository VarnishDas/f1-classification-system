import java.io.*;
import java.util.*;

public class Utilities implements Serializable {

    private ArrayList<Team> teams = new ArrayList<Team>();
    private ArrayList<Driver> drivers = new ArrayList<Driver>();

    public void setup() throws IOException {
        Scanner scanner = new Scanner(System.in);

        boolean done = false;

        while (!done) {
            System.out.println("1: Create custom setup\n2: Create automic setup (2024 Grid)");

            switch (scanner.nextLine()) {
                case "1":
                    customSetup();
                    done = true;
                    break;
                case "2":
                    automaticSetup();
                    done = true;
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }

    public void customSetup() throws IOException {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter name of Team: ");
            String teamName = scanner.nextLine();
            System.out.println("Enter abbreviation of Team: ");
            String teamAbv = scanner.nextLine();

            Team team = new Team(teamName, teamAbv.toUpperCase(), 0);
            teams.add(team);

            for (int j = 0; j < 2; j++) {
                System.out.println("Enter name of Driver " + (j+1) + ": ");
                String driverName = scanner.nextLine();
                System.out.println("Enter abbreviation of Driver " + (j+1) + ": ");
                String driverAbv = scanner.nextLine();

                Driver driver = new Driver(driverName, driverAbv.toUpperCase(), 0, team);
                drivers.add(driver);
            }
        }

        toFiles("teams.ser", teams);
        toFiles("drivers.ser", drivers);

        System.out.println("Setup complete!");
    }

    public void automaticSetup() throws IOException {
        String[] teamNames = {"McLaren", "Ferrari", "Red Bull", "Mercedes", "Alpine", "AlphaTauri", "Aston Martin", "Alfa Romeo", "Williams", "Haas"};
        String[] teamAbvs = {"MCL", "FER", "RBR", "MER", "ALP", "ATR", "AMR", "ARO", "WIL", "HAS"};

        for (int i = 0; i < 10; i++) {
            Team team = new Team(teamNames[i], teamAbvs[i], 0);
            teams.add(team);
        }

        String[] driverNames = {"Lando Norris", "Oscar Piastri", "Charles Leclerc", "Carlos Sainz", "Max Verstappen", "Sergio Perez", "Lewis Hamilton", "George Russell", "Pierre Gasly", "Esteban Ocon", "Yuki Tsunoda", "Daniel Ricciardo", "Fernando Alonso", "Lance Stroll", "Valtteri Bottas", "Guanyu Zhou", "Logan Sargeant", "Alex Albon", "Kevin Magnussen", "Nico Hülkenberg"};
        String[] driverAbvs = {"NOR", "PIA", "LEC", "SAI", "VER", "PER", "HAM", "RUS", "GAS", "OCO", "TSU", "RIC", "ALO", "STR", "BOT", "ZHO", "SAR", "ALB", "MAG", "HUL"};

        int index = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 2; j++) {
                Driver driver = new Driver(driverNames[index], driverAbvs[index], 0, teams.get(i));
                drivers.add(driver);
                index++;
            }
        }

        toFiles("teams.ser", teams);
        toFiles("drivers.ser", drivers);

    }

    public Driver doesDriverExist(ArrayList<Driver> drivers, String input) {
        for (Driver driver : drivers) {
            if (driver.abv.equalsIgnoreCase(input) || driver.name.equalsIgnoreCase(input)) {
                return driver;
            }
        }
        return null;
    }

    public Team doesTeamExist(ArrayList<Team> teams, String input) {
        for (Team team : teams) {
            if (team.abv.equalsIgnoreCase(input) || team.name.equalsIgnoreCase(input)) {
                return team;
            }
        }
        return null;
    }

    public void Sync(ArrayList<Driver> drivers, ArrayList<Team> teams) {
        for (Driver driver : drivers) {
            for (Team team : teams) {
                if (driver.team.abv.equals(team.abv)) { 
                    driver.team = team;
                    break;
                }
            }
        }
    }

    public Driver addDriver(ArrayList<Driver> drivers, ArrayList<Team> teams) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name of driver: ");
        String name = scanner.nextLine();

        System.out.println("Enter abbreviation of driver: ");
        String abv = scanner.nextLine();

        System.out.println("Enter name/abbreviation of team: ");
        String team = scanner.nextLine();

        Team foundTeam = null;

        boolean displayNotExistMessage = true;

        while (foundTeam == null) {
            foundTeam = doesTeamExist(teams, team);

            if (foundTeam == null) {

                if (displayNotExistMessage) {
                    System.out.println("Team does not exist!");
                }

                System.out.println("1: Add new team\n2: Try again");

                switch (scanner.nextInt()) {
                    case 1:
                        foundTeam = addTeam(teams);
                        break;
                    case 2:
                        System.out.println("Enter name/abbreviation of team: ");
                        team = scanner.nextLine();
                        break;
                    default:
                        System.out.println("Invalid choice!");
                        displayNotExistMessage = false;
                        break;
                }
            }
        }

        Driver driver = new Driver(name, abv, 0, foundTeam);
        drivers.add(driver);
        return driver;
    }

    public Team addTeam(ArrayList<Team> teams) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name of team: ");
        String name = scanner.nextLine();

        System.out.println("Enter abbreviation of team: ");
        String abv = scanner.nextLine();

        Team team = new Team(name, abv, 0);
        teams.add(team);

        return team;
    }

    public void toFiles(String fileName, Object object) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(fileName);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(object);
        out.close();
        fileOut.close();
    }

    public <T> ArrayList<T> fromFiles(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(fileName);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        @SuppressWarnings("unchecked")
        ArrayList<T> object = (ArrayList<T>) in.readObject();
        in.close();
        fileIn.close();
        return object;
    }
}
