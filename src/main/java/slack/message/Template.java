package slack.message;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import slack.model.Attachment;
import slack.model.Fields;
import slack.model.Message;
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
        if (textModel.getTotalHours() == textModel.getMarkedHours()){
            attachment.setColor("good");
            attachment.setFallback("Умничка!");
        }
        else {
            attachment.setColor("danger");
            attachment.setFallback("Важное уведомление!");
        }

        if(first == 0) {
        attachment.setPretext(textModel.getData());
        }
        attachment.setAuthor_name(textModel.getUserName());
        attachment.setAuthor_icon(textModel.getUserImage());

        List<Fields> fieldsObjectsArray = new ArrayList<Fields>();

        fieldsObjectsArray.add(0, new Fields("Задача: "+textModel.getTaskName(),textModel.getTaskValue(),false));
        fieldsObjectsArray.add(1, new Fields("Отмечено:",textModel.getMarkedHours(),true));
        fieldsObjectsArray.add(2, new Fields("Всего:",textModel.getTotalHours(),true));

        attachment.setFields(fieldsObjectsArray);

        return attachment;
    }

}
