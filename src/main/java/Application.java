import org.springframework.web.client.RestTemplate;
import slack.Message;
import slack.SlackUser;
import slack.SlackUserListParser;

import java.util.ArrayList;

public class Application {

    public static void main(String[] args){
        System.out.println("Запуск TimeCrawler");

        String user = "maxim_nikitin";
        String token = "xoxb-18373787971-0b7ajI9mNSOnbswAwIK0sdvW";
        String text = "Hellow World";
        Message message = new Message();
        message.sendMessage(user,text,token);

//        String uri = "https://slack.com/api/chat.postMessage";
//        String body = "?token=xoxb-18373787971-0b7ajI9mNSOnbswAwIK0sdvW&channel=@alexander_volkov&text=Русский+текст";
        String uri = "https://slack.com/api/users.list?token=xoxb-18373787971-0b7ajI9mNSOnbswAwIK0sdvW&pretty=1";
        String str = "";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        SlackUserListParser slackUserListParser = new SlackUserListParser(result);
        ArrayList<SlackUser> slackUsers = new ArrayList<SlackUser>();  
        slackUsers.addAll(slackUserListParser.getListSlackUser());

        for (SlackUser slackUser: slackUsers) {
            System.out.println(slackUser.getId() + "\n" + slackUser.getTeamId() + "\n" + slackUser.getName() + "\n");
        }
    }
}
