package slack.model.json;

import slack.model.json.Attachment;

import java.util.List;


public class Message {



    private String channel;
    private List<Attachment> attachments;


    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public Message() {
    }
}
