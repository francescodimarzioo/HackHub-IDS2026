package pattern;

public class GoogleMeetStrategy implements LinkCallStrategy {

    private String meetingCode;

    public GoogleMeetStrategy(String meetingCode) {
        this.meetingCode = meetingCode;
    }

    @Override
    public String generaLink() {
        String link = "https://meet.google.com/" + meetingCode;
        System.out.println("Link Google Meet generato: " + link);
        return link;
    }
}
