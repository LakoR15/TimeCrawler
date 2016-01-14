import com.fasterxml.jackson.core.JsonProcessingException;
import slack.message.UserReports;
import slack.model.TextModel;
import slack.model.Response;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) throws JsonProcessingException {

        System.out.println("Запуск TimeCrawler");

        Response response = UserReports.getUserList();
        List<TextModel> textModels = new ArrayList<TextModel>();
        textModels.add(new TextModel("14.01.16","maxim_nikitin","Кролики","здесь должно быть описание","12","34",response
                .getMembers()
                .get(3)
                .getProfile()
                .getImage24()));
        textModels.add(new TextModel("14.01.16","maxim_nikitin","Кролики","здесь должно быть описание","34","34",response
                .getMembers()
                .get(3)
                .getProfile()
                .getImage24()));


       new UserReports().sendUserReport("alexander_volkov",textModels);


        System.out.println("Завершение TimeCrawler");
    }


}
