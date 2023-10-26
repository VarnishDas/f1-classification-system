public class Team {
    String name;
    int totalPoints;
    Driver driver1, driver2;

    Team (String name, int totalPoints, Driver driver1, Driver driver2) {
        this.name = name;
        this.totalPoints = totalPoints;
    }

    public void setDriver1(Driver driver1) {
        this.driver1 = driver1;
    }

    public void setDriver2(Driver driver2) {
        this.driver2 = driver2;
    }
}
