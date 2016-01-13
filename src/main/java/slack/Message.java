package slack;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

public class Message {

    public void sendMessage(String user, String text) {

        user = "@" + user;
//        text = "text=" + text;
//        token = "token=" + token;

//       String uri = "https://slack.com/api/chat.postMessage?" + token + "&" + user + "&" + text;
        // String uri = "https://slack.com/api/chat.postMessage?token=xoxb-18373787971-0b7ajI9mNSOnbswAwIK0sdvW&channel=@alexander_volkov&text=Hello+world";
        String uri = "https://hooks.slack.com/services/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";
        String body = "{\"channel\": \""+user+"\",\"text\": \""+text+"\"}";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters()
                .add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));

        String result = restTemplate.postForObject(uri, body, String.class);
        System.out.println(result);
    }

}
