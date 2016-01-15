package slack.model;

import java.time.LocalDate;
import java.util.List;

public class TextModel {

    private LocalDate data;
    private String userName;
    private String userImage;
    private List<FieldsTextModel> fieldsList;

    public TextModel(LocalDate data, String userName, String userImage, List<FieldsTextModel> fieldsList) {
        this.data = data;
        this.userName = userName;
        this.userImage = userImage;
        this.fieldsList = fieldsList;
    }

    public List<FieldsTextModel> getFieldsList() {
        return fieldsList;
    }

    public void setFieldsList(List<FieldsTextModel> fieldsList) {
        this.fieldsList = fieldsList;
    }


    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
