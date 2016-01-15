package slack.model;

public class Task {

    private String title;
    private int assemblaId;
    private Project project;

    public Task(String title, int assemblaId, Project project) {
        this.title = title;
        this.assemblaId = assemblaId;
        this.project = project;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAssemblaId() {
        return assemblaId;
    }

    public void setAssemblaId(int assemblaId) {
        this.assemblaId = assemblaId;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
