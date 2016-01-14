package slack.message;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import slack.model.AttachmentObject;
import slack.model.MessageObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gidro on 13.01.2016.
 */
public class MessageTemplate {

    private List<AttachmentObject> as;
    public String getUserTemplate(String user_name, String text) throws JsonProcessingException {


       AttachmentObject a = new AttachmentObject();
        a.setText(text);
//               ("Title","Pretext _supports_ mrkdwn",text,"[\"text\", \"pretext\"]");

        List<AttachmentObject> as = new ArrayList<AttachmentObject>();


        as.add(0,a);

       MessageObject sd = new MessageObject();
        sd.setChannel("@"+user_name);
        sd.setAttachments(as);
//               ("@"+user_name,as);


        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(sd);
        return json;





    }

}
