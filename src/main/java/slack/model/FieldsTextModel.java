package slack.model;

public class FieldsTextModel {

    private String taskName;
    private String projectName;
    //    private String totalHours;
    private float markedHours;

    public FieldsTextModel(String taskName, String projectName, float markedHours) {
        this.taskName = taskName;
        this.projectName = projectName;
        this.markedHours = markedHours;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public float getMarkedHours() {
        return markedHours;
    }

    public void setMarkedHours(float markedHours) {
        this.markedHours = markedHours;
    }
}
