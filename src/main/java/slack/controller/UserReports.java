package slack.controller;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import slack.model.FieldsTextModel;
import slack.model.Person;
import slack.model.TimeReport;
import slack.model.json.Response;
import slack.model.TextModel;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UserReports {

    public void sendUserReport(final String recipient, final List<TextModel> textModelArray) {

        final Thread thread = new Thread(new Runnable() {
            public void run() {
                String uri = "https://hooks.slack.com/services/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";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters()
                        .add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));

                String result = null;
                try {
                    result = restTemplate.postForObject(uri, new Template().getMessageTemplate(recipient, textModelArray), String.class);
                    System.out.println(result);
                } catch (ResourceAccessException rae) {
                    throw new RuntimeException("Ошибка отправки, проверить соединение с интернетом " + rae.getMessage());
                } catch (HttpServerErrorException hsee) {
                    throw new RuntimeException("Проверьте отправляемые данные " + hsee.getMessage());
                } catch (Exception e) {
                    throw new RuntimeException("Неизвестная ошибка " + e.getMessage());
                }


            }
        });
        thread.start();

    }

    public void sendUserReport(final String recipient, final TextModel textModel) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String uri = "https://hooks.slack.com/services/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";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters()
                        .add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));

                String result = null;
                try {
                    result = restTemplate.postForObject(uri, new Template().getMessageTemplate(recipient, textModel), String.class);
                    System.out.println(result);
                } catch (ResourceAccessException rae) {
                    throw new RuntimeException("Ошибка отправки, проверить соединение с интернетом " + rae.getMessage());
                } catch (HttpServerErrorException hsee) {
                    throw new RuntimeException("Проверьте отправляемые данные " + hsee.getMessage());
                } catch (Exception e) {
                    throw new RuntimeException("Неизвестная ошибка " + e.getMessage());
                }

            }
        });
        thread.start();

    }

    public Response getUserList() {

        String url = "https://slack.com/api/users.list?token=xoxb-18373787971-0b7ajI9mNSOnbswAwIK0sdvW&pretty=1";

        RestTemplate restTemplate = new RestTemplate();
        Response response;

        try {
            response = restTemplate.getForObject(url, Response.class);
        }catch (ResourceAccessException rae){
            throw new RuntimeException("Ошибка получения, проверить соединение с интернетом " + rae.getMessage());
        }catch (Exception e){
            throw new RuntimeException("Неизвестная ошибка " +e.getMessage());
        }

        return response;

    }

    public void send(List<TimeReport> timeReports, String manager) {

        Collections.sort(timeReports, new Comparator<TimeReport>() {
            @Override
            public int compare(TimeReport o1, TimeReport o2) {
                return o1.getPerson().toString().compareTo(o2.getPerson().toString());
            }
        });

        List<TextModel> textModels = new ArrayList<>();
        Person person = timeReports.get(0).getPerson();
        List<List> list = new ArrayList();
        list.add(new ArrayList<FieldsTextModel>());
        int count = 0;
        for (int i = 0; i < timeReports.size(); i++) {
            if (person.equals(timeReports.get(i).getPerson())) {
                list.get(count).add(new FieldsTextModel(timeReports.get(i).getTask().getTitle(), timeReports.get(i).getTask().getProject().getTitle(), timeReports.get(i).getHoursLogged()));
                if (i == timeReports.size() - 1) {
                    textModels.add(new TextModel(timeReports.get(i).getDate(), timeReports.get(i).getPerson().getName(), "", timeReports.get(i).getPerson().getSlackId(), list.get(count)));
                }
            } else {
                textModels.add(new TextModel(timeReports.get(i - 1).getDate(), timeReports.get(i - 1).getPerson().getName(), "", timeReports.get(i - 1).getPerson().getSlackId(), list.get(count)));
                count++;
                person = timeReports.get(i).getPerson();
                list.add(new ArrayList<FieldsTextModel>());
                i = i - 1;
            }
        }

//        for (TextModel tm: textModels) {
//            sendUserReport(tm.getSlackId(), tm);
//        }

        sendUserReport(manager, textModels);

    }

}
