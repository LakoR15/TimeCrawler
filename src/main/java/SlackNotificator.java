import slack.SlackAgent;
import slack.model.TimeReport;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class SlackNotificator implements Runnable{

    @Override
    public void run() {
        sendLastTimeReports();
    }

    public void sendLastTimeReports(){
        SlackAgent slackAgent = new SlackAgent();

        //тут нужно сходить в бд
        List<TimeReport> timeReports = new ArrayList<>();
        List<String> managers = new ArrayList<>();
        //тут нужно сходить в бд

        slackAgent.sendTimeReport(timeReports, managers);
    }
}
