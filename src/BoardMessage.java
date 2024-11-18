import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class BoardMessage extends Message {

    private boolean isActive;
    private String durationActivated;
    private Instant start;
    private Instant finish;


    public BoardMessage(String sender, String content, String target, Date sendDate) {
        super(sender, content, target, sendDate);
        this.isActive = true;
    }

    public BoardMessage(String sender, String content, String target) {
        super(sender, content, target);
        this.isActive = true;
        System.out.println(getSenderDate());
    }




    private void durationActiveBoardMessage() {
        start = Instant.now();
    }

    public long timePassed() {
        finish = Instant.now();
        return Duration.between(start, finish).toMinutes();
    }

    @Override
    public String getMessageType() {
        return "Board messages";
    }

    @Override
    public String toString() {
        return super.toString() + " Priority: " + " isActive: " + isActive;
    }


}
