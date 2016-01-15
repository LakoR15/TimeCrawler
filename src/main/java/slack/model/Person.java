package slack.model;

public class Person {

    private String name;
    private String assemblaId;
    private String slackId;
    private String email;

    public Person(String name, String assemblaId, String slackId, String email) {
        this.name = name;
        this.assemblaId = assemblaId;
        this.slackId = slackId;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAssemblaId() {
        return assemblaId;
    }

    public void setAssemblaId(String assemblaId) {
        this.assemblaId = assemblaId;
    }

    public String getSlackId() {
        return slackId;
    }

    public void setSlackId(String slackId) {
        this.slackId = slackId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
