import slack.Message;

import java.util.Scanner;

public class Application {

    public static void main(String[] args){
        System.out.println("Запуск TimeCrawler");

        String user = "maxim_nikitin";
        String token = "xoxb-18373787971-0b7ajI9mNSOnbswAwIK0sdvW";

        do {
            System.out.print("Введите сообщение: ");
            Scanner scanner = new Scanner(System.in);
            String text = scanner.nextLine();
            Message message = new Message();
            message.sendMessage(user, text, token);
        }while (true);

//        String user = "maxim_nikitin";
//        String token = "xoxb-18373787971-0b7ajI9mNSOnbswAwIK0sdvW";
//        String text = "Hellow World";
//        Message message = new Message();
//        message.sendMessage(user,text,token);
//
//        String uri = "https://slack.com/api/chat.postMessage";
//        String body = "?token=xoxb-18373787971-0b7ajI9mNSOnbswAwIK0sdvW&channel=@alexander_volkov&text=Русский+текст";
//        String uri = "https://slack.com/api/users.list?token=xoxb-18373787971-0b7ajI9mNSOnbswAwIK0sdvW&pretty=1";
//        String str = "";
//
//        ObjectMapper mapper = new ObjectMapper();
//        RestTemplate restTemplate = new RestTemplate();
//        String result = restTemplate.getForObject(uri, String.class);
//        try {
//            List<SlackUser> slackUsers = mapper.readValue(result, new TypeReference<List<SlackUser>>(){});
//            System.out.println(slackUsers.get(1).toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//
//        SlackUserListParser slackUserListParser = new SlackUserListParser(result);
//        ArrayList<SlackUser> slackUsers = new ArrayList<SlackUser>();
//        slackUsers.addAll(slackUserListParser.getListSlackUser());
//
//        for (SlackUser slackUser: slackUsers) {
//            System.out.println(slackUser.getId() + "\n" + slackUser.getTeamId() + "\n" + slackUser.getName() + "\n");
//        }
    }
}
