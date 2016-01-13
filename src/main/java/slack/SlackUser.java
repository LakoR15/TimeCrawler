package slack;

public class SlackUser {

    String id;
    String teamId;
    String name;

    public SlackUser(String id, String teamId, String name) {
        this.id = id;
        this.teamId = teamId;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getTeamId() {
        return teamId;
    }

    public String getName() {
        return name;
    }
}
