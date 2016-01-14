import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.client.RestTemplate;
import slack.message.Message;
import slack.message.MessageTemplate;
import slack.response.Response;

public class Application {

    public static void main(String[] args) throws JsonProcessingException {

        System.out.println("Запуск TimeCrawler");

        Message message = new Message();
        message.sendMessage("alexander_volkov", "Сообщение из 1 потока");
        message.sendMessage("alexander_volkov", "Сообщение из 2 потока");
        message.sendMessage("alexander_volkov", "Сообщение из 3 потока");

        System.out.println("Завершение TimeCrawler");
    }

    public static void getUserList(){

        String url = "https://slack.com/api/users.list?token=xoxb-18373787971-0b7ajI9mNSOnbswAwIK0sdvW&pretty=1";

        RestTemplate restTemplate = new RestTemplate();
        Response response = restTemplate.getForObject(url, Response.class);
        System.out.println(response.getMembers().get(0).toString());

    }
}
