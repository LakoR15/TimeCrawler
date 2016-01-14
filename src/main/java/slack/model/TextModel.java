package slack.model;

/**
 * Created by Gidro on 14.01.2016.
 */
public class TextModel {
    private String data;
    private String userName;
    private String taskName;
    private String taskValue;
    private String totalHours;
    private String markedHours;

    public TextModel(String data, String userName, String taskName, String taskValue, String totalHours, String markedHours) {
        this.data = data;
        this.userName = userName;
        this.taskName = taskName;
        this.taskValue = taskValue;
        this.totalHours = totalHours;
        this.markedHours = markedHours;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskname) {
        this.taskName = taskname;
    }
    public String getData() {

        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTaskValue() {
        return taskValue;
    }

    public void setTaskValue(String taskValue) {
        this.taskValue = taskValue;
    }

    public String getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(String totalHours) {
        this.totalHours = totalHours;
    }

    public String getMarkedHours() {
        return markedHours;
    }

    public void setMarkedHours(String markedHours) {
        this.markedHours = markedHours;
    }

    public TextModel() {

    }
}
