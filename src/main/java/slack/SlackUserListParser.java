package slack;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SlackUserListParser {

    JSONObject jsonObject;
    JSONArray jsonSlackUsers;

    public SlackUserListParser(String response) {
        jsonObject = new JSONObject(response);
        jsonSlackUsers = jsonObject.getJSONArray("members");
    }

    public SlackUser getSlackUser(int i){

        JSONObject jsonSlackUser = jsonSlackUsers.getJSONObject(i);
        return new SlackUser(jsonSlackUser.getString("id"),
                jsonSlackUser.getString("team_id"),
                jsonSlackUser.getString("name"));
    }

    public List<SlackUser> getListSlackUser(){
        List<SlackUser> slackUsers = new ArrayList<SlackUser>();

        for(int i = 0; i < jsonSlackUsers.length(); i++){
            slackUsers.add(getSlackUser(i));
        }

        return slackUsers;
    }

}

