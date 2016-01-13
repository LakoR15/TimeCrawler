package slack;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class SlackUser implements Serializable {

    @JsonProperty
    private String id;
    @JsonProperty(value = "team_id")
    private String teamId;
    @JsonProperty
    private String name;
    private boolean deleted;
    private String status;
    private String color;
    @JsonProperty
    private String realName;
    private String tz;
    @JsonProperty(value = "tz_label")
    private String tzLabel;
    @JsonProperty(value = "tz_offset")
    private int tzOffset;
    private SlackUserProfile profile;
    @JsonProperty(value = "is_admin")
    private boolean isAdmin;
    @JsonProperty(value = "is_owner")
    private boolean isOwner;
    @JsonProperty(value = "is_primary_owner")
    private boolean isPrimaryOwner;
    @JsonProperty(value = "is_restricted")
    private boolean isRestricted;
    @JsonProperty(value = "is_bot")
    private boolean isBot;


    public SlackUser() {

    }

    @Override
    public String toString() {

        return getId() + "\n" +
                getName() + "\n" +
                getTeamId() + "\n" +
                getRealName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getTz() {
        return tz;
    }

    public void setTz(String tz) {
        this.tz = tz;
    }

    public String getTzLabel() {
        return tzLabel;
    }

    public void setTzLabel(String tzLabel) {
        this.tzLabel = tzLabel;
    }

    public int getTzOffset() {
        return tzOffset;
    }

    public void setTzOffset(int tzOffset) {
        this.tzOffset = tzOffset;
    }

    public SlackUserProfile getProfile() {
        return profile;
    }

    public void setProfile(SlackUserProfile profile) {
        this.profile = profile;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isOwner() {
        return isOwner;
    }

    public void setOwner(boolean owner) {
        isOwner = owner;
    }

    public boolean isPrimaryOwner() {
        return isPrimaryOwner;
    }

    public void setPrimaryOwner(boolean primaryOwner) {
        isPrimaryOwner = primaryOwner;
    }

    public boolean isRestricted() {
        return isRestricted;
    }

    public void setRestricted(boolean restricted) {
        isRestricted = restricted;
    }

    public boolean isBot() {
        return isBot;
    }

    public void setBot(boolean bot) {
        isBot = bot;
    }
}
