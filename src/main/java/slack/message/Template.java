package slack.message;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import slack.model.AttachmentObject;
import slack.model.FieldsObject;
import slack.model.MessageObject;
import slack.model.TextModel;

import java.util.ArrayList;
import java.util.List;

public class Template {

    public String getMessageTemplate(String recipient, List<TextModel> textModelArray) {

        List<AttachmentObject> attachmentObjectArray = new ArrayList<AttachmentObject>();

        for (int i = 0; i < textModelArray.size(); i++) {
            attachmentObjectArray.add(i, attachmantTemplate(textModelArray.get(i),i));
        }

        MessageObject messageObject = new MessageObject();
        messageObject.setChannel("@" + recipient);
        messageObject.setAttachments(attachmentObjectArray);
        String json = null;
        try {
            json = new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(messageObject);
        } catch (JsonProcessingException e) {
        }
        return json;
    }

    private AttachmentObject attachmantTemplate(TextModel textModel, int first)  {

        AttachmentObject attachmentObject = new AttachmentObject();
        if (textModel.getTotalHours() == textModel.getMarkedHours()){
            attachmentObject.setColor("good");
            attachmentObject.setFallback("Умничка!");
        }
        else {
            attachmentObject.setColor("danger");
            attachmentObject.setFallback("Важное уведомление!");
        }

        if(first == 0) {
        attachmentObject.setPretext(textModel.getData());
        }
        attachmentObject.setAuthor_name(textModel.getUserName());
        attachmentObject.setAuthor_icon(textModel.getUserImage());

        List<FieldsObject> fieldsObjectsArray = new ArrayList<FieldsObject>();

        fieldsObjectsArray.add(0, new FieldsObject("Задача: "+textModel.getTaskName(),textModel.getTaskValue(),false));
        fieldsObjectsArray.add(1, new FieldsObject("Отмечено:",textModel.getMarkedHours(),true));
        fieldsObjectsArray.add(2, new FieldsObject("Всего:",textModel.getTotalHours(),true));

        attachmentObject.setFields(fieldsObjectsArray);

        return attachmentObject;
    }

}
