import slack.SlackAgent;

public class SlackNotificator implements Runnable{

    @Override
    public void run() {
        sendLastTimeReports();
    }

    public void sendLastTimeReports(){
        SlackAgent slackAgent = new SlackAgent();
        slackAgent.sendTimeReport(slackAgent.getTimeReports(), slackAgent.getManagers());
    }
}
