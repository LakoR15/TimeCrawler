import org.springframework.web.client.RestTemplate;

public class Application {

    public static void main(String[] args){
        System.out.println("Запуск TimeCrawler");

        String uri = "https://slack.com/api/chat.postMessage?token=xoxp-2914071231-18274875456-18301125571-4f208dd26f&channel=%40alexander_volkov&text=Second%20test&username=bot&pretty=1";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        System.out.println(result);
    }
}
