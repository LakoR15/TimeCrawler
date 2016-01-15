package slack.model;

public class Project {

    private String title;
    private String assemblaId;

    public Project(String title, String assemblaId) {
        this.title = title;
        this.assemblaId = assemblaId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAssemblaId() {
        return assemblaId;
    }

    public void setAssemblaId(String assemblaId) {
        this.assemblaId = assemblaId;
    }
}
