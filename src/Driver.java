public class Driver {
    String name;
    int totalPoints;
    Team team;

    Driver (String name, int totalPoints) {
        this.name = name;
        this.totalPoints = totalPoints;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
