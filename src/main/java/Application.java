import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.client.RestTemplate;
import slack.message.Message;
import slack.message.MessageTemplate;
import slack.response.Response;

public class Application {

    public static void main(String[] args) throws JsonProcessingException {

        System.out.println("Запуск TimeCrawler");

        getUserList();

        new Message().sendMessage("alexander_volkov","Привет");

//        String user = "maxim_nikitin";
//        String token = "xoxb-18373787971-0b7ajI9mNSOnbswAwIK0sdvW";

//        do {
//            System.out.print("Введите сообщение: ");
//            Scanner scanner = new Scanner(System.in);
//            String text = scanner.nextLine();
//            Message message = new Message();
//            message.sendMessage(user, text, token);
//        }while (true);

//        String user = "maxim_nikitin";
//        String token = "xoxb-18373787971-0b7ajI9mNSOnbswAwIK0sdvW";
//        String text = "Hellow World";
//        Message message = new Message();
//        message.sendMessage(user,text,token);
//
//        String uri = "https://slack.com/api/chat.postMessage";
//        String body = "?token=xoxb-18373787971-0b7ajI9mNSOnbswAwIK0sdvW&channel=@alexander_volkov&text=Русский+текст";
//        String uri = "https://slack.com/api/users.list?token=xoxb-18373787971-0b7ajI9mNSOnbswAwIK0sdvW&pretty=1";
    }

    public static void getUserList(){

        String url = "https://slack.com/api/users.list?token=xoxb-18373787971-0b7ajI9mNSOnbswAwIK0sdvW&pretty=1";

        RestTemplate restTemplate = new RestTemplate();
        Response response = restTemplate.getForObject(url, Response.class);
        System.out.println(response.getMembers().get(1).getName());
        System.out.println(response.getMembers().get(1).getProfile().getEmail());

    }
}
