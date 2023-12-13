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

            switch (scanner.nextInt()) {
                case 1:
                    customSetup();
                    done = true;
                    break;
                case 2:
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
        String[] driverAbvs = {"NOR", "PIA", "LEC", "SAI", "VER", "PER", "HAM", "RUS", "GAS", "OCO", "TSU", "RIC", "FER", "STR", "BOT", "ZHO", "SAR", "ALB", "MAG", "HUL"};

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
