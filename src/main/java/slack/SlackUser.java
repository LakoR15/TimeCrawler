package slack;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SlackUser {

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
    private String profile;
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


    public SlackUser(String id, String teamId, String name) {
        this.id = id;
        this.teamId = teamId;
        this.name = name;
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

    public String getTeamId() {
        return teamId;
    }

    public String getName() {
        return name;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public String getStatus() {
        return status;
    }

    public String getColor() {
        return color;
    }

    public String getRealName() {
        return realName;
    }

    public String getTz() {
        return tz;
    }

    public String getTzLabel() {
        return tzLabel;
    }

    public int getTzOffset() {
        return tzOffset;
    }

    public String getProfile() {
        return profile;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean isOwner() {
        return isOwner;
    }

    public boolean isPrimaryOwner() {
        return isPrimaryOwner;
    }

    public boolean isRestricted() {
        return isRestricted;
    }

    public boolean isBot() {
        return isBot;
    }
}
