package slack.controller;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import slack.model.json.Response;
import slack.model.TextModel;

import java.io.IOException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.List;

public class UserReports {

    public void sendUserReport(final String recipient, final List<TextModel> textModelArray){

        final Thread thread = new Thread(new Runnable() {
                public void run() {
                    String uri = "https://hooks.slack.com/services/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";
                    RestTemplate restTemplate = new RestTemplate();
                    restTemplate.getMessageConverters()
                            .add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));

                    String result = null;
                    result = restTemplate.postForObject(uri,new Template().getMessageTemplate(recipient,textModelArray), String.class);
                    System.out.println(result);
                }
            });
            thread.start();

        }

    public void sendUserReport(final String recipient, final TextModel textModel){

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String uri = "https://hooks.slack.com/services/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";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters()
                        .add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));

                String result = null;
                result = restTemplate.postForObject(uri, new Template().getMessageTemplate(recipient, textModel), String.class);
                System.out.println(result);
            }
        });
        thread.start();

    }

    public static Response getUserList() {


        String url = "https://slack.com/api/users.list?token=xoxb-18373787971-0b7ajI9mNSOnbswAwIK0sdvW&pretty=1";

        RestTemplate restTemplate = new RestTemplate();
        Response response;
        response = restTemplate.getForObject(url, Response.class);
        System.out.println(response.getMembers().get(0).toString());

        return response;

    }

}
