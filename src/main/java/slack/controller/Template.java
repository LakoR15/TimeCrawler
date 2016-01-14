package slack.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import slack.model.FieldsTextModel;
import slack.model.json.Attachment;
import slack.model.json.Fields;
import slack.model.json.Message;
import slack.model.TextModel;

import java.util.ArrayList;
import java.util.List;

public class Template {

    public String getMessageTemplate(String recipient, List<TextModel> textModelArray) {

        List<Attachment> attachmentArray = new ArrayList<Attachment>();

        for (int i = 0; i < textModelArray.size(); i++) {
            attachmentArray.add(i, attachmantTemplate(textModelArray.get(i),i));
        }

        Message messageObject = new Message();
        messageObject.setChannel("@" + recipient);
        messageObject.setAttachments(attachmentArray);
        String json = null;
        try {
            json = new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(messageObject);
        } catch (JsonProcessingException e) {
        }
        return json;
    }

    private Attachment attachmantTemplate(TextModel textModel, int first)  {

        Attachment attachment = new Attachment();

            attachment.setColor("danger");
            attachment.setFallback("Отчёты по отмеченному времени");

        if(first == 0) {
        attachment.setPretext(textModel.getData());
        }
        attachment.setAuthor_name(textModel.getUserName());
        attachment.setAuthor_icon(textModel.getUserImage());
        attachment.setFields(fieldsObjectsArray(textModel));

        return attachment;
    }

    private List<Fields> fieldsObjectsArray(TextModel textModel) {


        List<FieldsTextModel> fieldsList = textModel.getFieldsList();

        List<Fields> fieldsObjectsArray = new ArrayList<Fields>();
        double totalHours = 0;
        for(int i=0;i<fieldsList.size();i++) {
            fieldsObjectsArray.add(new Fields("Задача: " + fieldsList.get(i).getTaskName() + " (" + fieldsList.get(i).getProjectName() + ")", null, false));
            fieldsObjectsArray.add(new Fields("Отмечено:", fieldsList.get(i).getMarkedHours() + " ч.", true));
            totalHours+=Double.parseDouble(fieldsList.get(i).getMarkedHours());
        if (i==fieldsList.size()-1)
        {
            fieldsObjectsArray.add(2, new Fields("Всего:",totalHours+" ч.",true));
        }
        }
        return fieldsObjectsArray;
    }

}
