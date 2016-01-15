package slack.model;

import java.time.LocalDate;

public class TimeReport {

    private int assemblaId;
    private LocalDate date = LocalDate.ofEpochDay(0);
    private float hoursLogged;
    private Person person;
    private Task task;

    public TimeReport(Task task, Person person, float hoursLogged, int assemblaId) {
        this.task = task;
        this.person = person;
        this.hoursLogged = hoursLogged;
        this.assemblaId = assemblaId;
    }

    public int getAssemblaId() {
        return assemblaId;
    }

    public void setAssemblaId(int assemblaId) {
        this.assemblaId = assemblaId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public float getHoursLogged() {
        return hoursLogged;
    }

    public void setHoursLogged(float hoursLogged) {
        this.hoursLogged = hoursLogged;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
