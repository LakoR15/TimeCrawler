package slack.controller;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import slack.model.TextModel;

import java.nio.charset.Charset;
import java.util.List;

public class UserReports {

    private final String URL = "https://hooks.slack.com/services/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";

    public void sendReport(String recipient, List<TextModel> textModelArray) {

        final Thread thread = new Thread(() -> {
            send(new Template().getMessageTemplate(recipient, textModelArray));
        });
        thread.start();

    }

    public void sendReport(String recipient, TextModel textModel) {

        Thread thread = new Thread(() -> {
            send(new Template().getMessageTemplate(recipient, textModel));
        });
        thread.start();

    }

    private void send(String template){

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));

        String result;
        try {
            result = restTemplate.postForObject(URL, template, String.class);
            System.out.println(result);
        } catch (ResourceAccessException rae) {
            throw new RuntimeException("Ошибка отправки, проверить соединение с интернетом " + rae.getMessage());
        } catch (HttpServerErrorException hsee) {
            throw new RuntimeException("Проверьте отправляемые данные " + hsee.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Неизвестная ошибка " + e.getMessage());
        }

    }

//    public Response getUserList() {
//
//        String url = "https://slack.com/api/users.list?token=xoxb-18373787971-0b7ajI9mNSOnbswAwIK0sdvW&pretty=1";
//
//        RestTemplate restTemplate = new RestTemplate();
//        Response response;
//
//        try {
//            response = restTemplate.getForObject(url, Response.class);
//        }catch (ResourceAccessException rae){
//            throw new RuntimeException("Ошибка получения, проверить соединение с интернетом " + rae.getMessage());
//        }catch (Exception e){
//            throw new RuntimeException("Неизвестная ошибка " +e.getMessage());
//        }
//
//        return response;
//
//    }

}
