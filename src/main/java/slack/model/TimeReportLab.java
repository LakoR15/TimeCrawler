package slack.model;

import java.util.ArrayList;
import java.util.List;

public class TimeReportLab {


    public static List<TimeReport> initializeData(){

        Project project = new Project("TimeCrawler", "it-support-ci.2");
        Project project1 = new Project("BigProject", "it-support-ci.1");

        Person person = new Person("Антон Шишов", "botovod", "alexander_volkov", "anton.shishov@codeinside.ru");
        Person person1 = new Person("Михаил Шпадырев", "shm", "alexander_volkov", "mihail.shpadirev@codeinside.ru");
        Person person2 = new Person("Александр Волков", "Alexander_Volkov", "alexander_volkov", "alexvolkov1994@gmail.com");
        Person person3 = new Person("Максим Никитин", "Gidroshvandel", "alexander_volkov", "Gidroshvandel@gmail.com");

        Task task = new Task("TimeCrawler", 67, project);
        Task task1 = new Task("Интеграция с системами оповещения", 72, project);
        Task task2 = new Task("Разарботка планировщика", 73, project);
        Task task3 = new Task("Интеграция архитектуры со spring-boot", 74, project);
        Task task4 = new Task("Добавление WebUI", 75, project1);
        Task task5 = new Task("Развертывание, CI", 76, project1);
        Task task6 = new Task("Интеграция с источниками данных", 70, project1);
        Task task7 = new Task("Разработка архитектуры", 68, project1);

        TimeReport timeReport = new TimeReport(task, person, 5, 1);
        TimeReport timeReport1 = new TimeReport(task1, person1, 8, 2);
        TimeReport timeReport2 = new TimeReport(task2, person2, 6, 3);
        TimeReport timeReport3 = new TimeReport(task3, person3, 4, 4);
        TimeReport timeReport4 = new TimeReport(task4, person, 12, 5);
        TimeReport timeReport5 = new TimeReport(task5, person1, 16, 6);
        TimeReport timeReport6 = new TimeReport(task6, person2, 10, 7);
        TimeReport timeReport7 = new TimeReport(task7, person3, 2, 8);

        List<TimeReport> timeReports = new ArrayList<>();
        timeReports.add(timeReport);
        timeReports.add(timeReport1);
        timeReports.add(timeReport2);
        timeReports.add(timeReport3);
        timeReports.add(timeReport4);
        timeReports.add(timeReport5);
        timeReports.add(timeReport6);
        timeReports.add(timeReport7);

        return timeReports;
    }

    public static List<String> initializeManagers(){

        List<String> managers = new ArrayList<>();
        managers.add("alexander_volkov");

        return managers;
    }

}
