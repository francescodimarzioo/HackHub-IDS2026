package pattern;

public class ZoomStrategy implements LinkCallStrategy {

    private String meetingId;
    private String password;

    public ZoomStrategy(String meetingId, String password) {
        this.meetingId = meetingId;
        this.password = password;
    }

    @Override
    public String generaLink() {
        String link = "https://zoom.us/j/" + meetingId + "?pwd=" + password;
        System.out.println("Link Zoom generato: " + link);
        return link;
    }
}