package slack;

import org.springframework.web.client.RestTemplate;

public class Message {

    public void sendMessage(String user, String text, String token) {

        user = "channel=@" + user;
        text = "text=" + text;
        token = "token=" + token;

        String uri = "https://slack.com/api/chat.postMessage?" + token + "&" + user + "&" + text;
        // String uri = "https://slack.com/api/chat.postMessage?token=xoxb-18373787971-0b7ajI9mNSOnbswAwIK0sdvW&channel=@alexander_volkov&text=Hello+world";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject(uri, new String(), String.class);
        System.out.println(result);
    }

}
