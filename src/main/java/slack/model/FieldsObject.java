package slack.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FieldsObject {
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

    public FieldsObject() {
    }

    private String value;
    @JsonProperty(value = "short")
    private Boolean short_;
}
