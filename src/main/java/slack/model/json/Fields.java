package slack.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Fields {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getShort_() {
        return short_;
    }

    public void setShort_(Boolean short_) {
        this.short_ = short_;
    }

    public Fields(String title, String value, Boolean short_) {
        this.title = title;
        this.value = value;
        this.short_ = short_;
    }

    public Fields() {
    }

    private String value;
    @JsonProperty(value = "short")
    private Boolean short_;
}
