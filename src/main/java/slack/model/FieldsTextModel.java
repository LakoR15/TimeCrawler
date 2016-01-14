package slack.model;

public class FieldsTextModel {

    private String taskName;
    private String projectName;
    //    private String totalHours;
    private String markedHours;

    public FieldsTextModel(String taskName, String projectName, String markedHours) {
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

    public String getMarkedHours() {
        return markedHours;
    }

    public void setMarkedHours(String markedHours) {
        this.markedHours = markedHours;
    }
}
