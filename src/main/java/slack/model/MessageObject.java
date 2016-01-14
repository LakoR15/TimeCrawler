package slack.model;

import slack.model.AttachmentObject;

import java.util.List;


public class MessageObject {



    private String channel;
    private List<AttachmentObject> attachments;


    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public List<AttachmentObject> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<AttachmentObject> attachments) {
        this.attachments = attachments;
    }

    public MessageObject() {
    }
}
