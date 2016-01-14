package slack.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import slack.model.json.SlackUser;

import java.io.Serializable;
import java.util.List;

public class Response implements Serializable {

    private boolean ok;
    private List<SlackUser> members;
    @JsonProperty(value = "cache_ts")
    private int cacheTs;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public List<SlackUser> getMembers() {
        return members;
    }

    public void setMembers(List<SlackUser> members) {
        this.members = members;
    }

    public int getCacheTs() {
        return cacheTs;
    }

    public void setCacheTs(int cacheTs) {
        this.cacheTs = cacheTs;
    }
}
