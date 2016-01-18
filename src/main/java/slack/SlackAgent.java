package slack;

import slack.controller.UserReports;
import slack.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SlackAgent {

    public void sendTimeReport(List<TimeReport> timeReports, List<String> managers){
        List<TextModel> textModels = prepareData(timeReports);

        UserReports userReports = new UserReports();

        for (String mng: managers){
            userReports.sendReport(mng, textModels);
        }

        for (TextModel textModel: textModels){
            userReports.sendReport(textModel.getSlackId(), textModel);
        }
    }

    private List<TextModel> prepareData(List<TimeReport> timeReports){

        Collections.sort(timeReports, (o1, o2) -> o1.getPerson().toString().compareTo(o2.getPerson().toString()));

        List<TextModel> textModels = new ArrayList<>();
        Person person = timeReports.get(0).getPerson();
        List<List> list = new ArrayList();
        list.add(new ArrayList<FieldsTextModel>());
        int count = 0;
        for (int i = 0; i < timeReports.size(); i++) {
            if (person.equals(timeReports.get(i).getPerson())) {
                list.get(count).add(new FieldsTextModel(timeReports.get(i).getTask().getTitle(), timeReports.get(i).getTask().getProject().getTitle(), timeReports.get(i).getHoursLogged()));
                if (i == timeReports.size() - 1) {
                    textModels.add(new TextModel(timeReports.get(i).getDate(), timeReports.get(i).getPerson().getName(), "", timeReports.get(i).getPerson().getSlackId(), list.get(count)));
                }
            } else {
                textModels.add(new TextModel(timeReports.get(i - 1).getDate(), timeReports.get(i - 1).getPerson().getName(), "", timeReports.get(i - 1).getPerson().getSlackId(), list.get(count)));
                count++;
                person = timeReports.get(i).getPerson();
                list.add(new ArrayList<FieldsTextModel>());
                i = i - 1;
            }
        }

        return textModels;
    }

    public List<TimeReport> getTimeReports(){
        //TODO: Заменить на запрос к базе
        return TimeReportLab.initializeData();
    }

    public List<String> getManagers(){
        //TODO: Заменить на запрос к базе
        return TimeReportLab.initializeManagers();

    }

}
