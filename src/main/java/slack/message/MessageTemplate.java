package slack.message;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import slack.model.AttachmentObject;
import slack.model.FieldsObject;
import slack.model.MessageObject;
import slack.model.TextModel;

import java.util.ArrayList;
import java.util.List;

public class MessageTemplate {

    public String getUserTemplate(TextModel textModel) throws JsonProcessingException {

        AttachmentObject attachmentObject = new AttachmentObject();
        attachmentObject.setColor("danger");
        attachmentObject.setPretext(textModel.getData());
        attachmentObject.setAuthor_name(textModel.getUserName());
        attachmentObject.setFallback("Важное уведомление!");

        List<FieldsObject> fieldsObjectsArray = new ArrayList<FieldsObject>();

        fieldsObjectsArray.add(0, new FieldsObject("Задача:"+textModel.getTaskName(),textModel.getTaskValue(),false));
        fieldsObjectsArray.add(1, new FieldsObject("Отмечено:",textModel.getMarkedHours(),true));
        fieldsObjectsArray.add(2, new FieldsObject("Всего:",textModel.getTotalHours(),true));

        attachmentObject.setFields(fieldsObjectsArray);

        List<AttachmentObject> attachmentObjectArray = new ArrayList<AttachmentObject>();

        attachmentObjectArray.add(0, attachmentObject);

        MessageObject messageObject = new MessageObject();
        messageObject.setChannel("@" + textModel.getUserName());
        messageObject.setAttachments(attachmentObjectArray);

        return new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(messageObject);

    }

}
