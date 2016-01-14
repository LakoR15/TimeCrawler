import com.fasterxml.jackson.core.JsonProcessingException;
import slack.controller.UserReports;
import slack.model.FieldsTextModel;
import slack.model.TextModel;
import slack.model.json.Response;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) throws JsonProcessingException {

        System.out.println("Запуск TimeCrawler");

        List<FieldsTextModel> fieldsTextModels = new ArrayList<FieldsTextModel>();
        fieldsTextModels.add(new FieldsTextModel("Таск1","Проект1","2"));
        fieldsTextModels.add(new FieldsTextModel("Таск2","Проект3","3"));
        fieldsTextModels.add(new FieldsTextModel("Таск3","Проект2","4"));

        Response response = UserReports.getUserList();
        List<TextModel> textModels = new ArrayList<TextModel>();
        for(int i=0;i<response.getMembers().size();i++) {
            textModels.add(new TextModel("14.16.16",
                    response
                            .getMembers().get(i)
                            .getName(),
                    response
                            .getMembers().get(i)
                            .getProfile()
                            .getImage24()
                    ,fieldsTextModels));
        }

       new UserReports().sendUserReport("maxim_nikitin",textModels);


        System.out.println("Завершение TimeCrawler");
    }


}
