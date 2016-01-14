package slack.model.json;

import java.util.List;

public class Attachment {

    private String fallback;
    private String color;
    private String pretext;
    private String author_name;
    private String author_link;
    private String author_icon;
    private String title;
    private String title_link;
    private String text;
    private List<Fields> fields;
    private String image_url;
    private String thumb_url;
    private String mrkdwn_in;

    public Attachment(String fallback, String color, String pretext, String author_name, String author_link, String author_icon, String title, String title_link, String text, List<Fields> fields, String image_url, String thumb_url, String mrkdwn_in) {
        this.fallback = fallback;
        this.color = color;
        this.pretext = pretext;
        this.author_name = author_name;
        this.author_link = author_link;
        this.author_icon = author_icon;
        this.title = title;
        this.title_link = title_link;
        this.text = text;
        this.fields = fields;
        this.image_url = image_url;
        this.thumb_url = thumb_url;
        this.mrkdwn_in = mrkdwn_in;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_link() {
        return author_link;
    }

    public void setAuthor_link(String author_link) {
        this.author_link = author_link;
    }

    public String getAuthor_icon() {
        return author_icon;
    }

    public void setAuthor_icon(String author_icon) {
        this.author_icon = author_icon;
    }

    public String getTitle_link() {
        return title_link;
    }

    public void setTitle_link(String title_link) {
        this.title_link = title_link;
    }

    public List<Fields> getFields() {
        return fields;
    }

    public void setFields(List<Fields> fields) {
        this.fields = fields;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getThumb_url() {
        return thumb_url;
    }

    public void setThumb_url(String thumb_url) {
        this.thumb_url = thumb_url;
    }

    public String getFallback() {

        return fallback;
    }

    public void setFallback(String fallback) {
        this.fallback = fallback;
    }

    public Attachment() {

    }

    public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPretext() {
            return pretext;
        }

        public void setPretext(String pretext) {
            this.pretext = pretext;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getMrkdwn_in() {
            return mrkdwn_in;
        }

        public void setMrkdwn_in(String mrkdwn_in) {
            this.mrkdwn_in = mrkdwn_in;
        }
}
