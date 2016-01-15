import slack.SlackAgent;

public class SlackCrawler implements Runnable{

    @Override
    public void run() {
        sendLastTimeReports();
    }

    public void sendLastTimeReports(){
        SlackAgent slackAgent = new SlackAgent();
        slackAgent.sendTimeReportUser();
        slackAgent.sendTimeReportManager();
    }
}
