
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public abstract class Message {
    static int nextId = 1;

    private int id;
    private String sender;
    private String content;
    private String target;
    private Date sendDate;


    public Message(String sender, String content, String target, Date sendDate) {
        setSender(sender);
        setContent(content);
        setSenderDate(sendDate);
        setTarget(target);
        this.id = nextId++;
    }

    public Message(String sender, String content, String target){
        this.sendDate = Date.from(new Date().toInstant());
        setSender(sender);
        setContent(content);
        setTarget(target);
        this.id = nextId++;
    }

    protected Message() {}

    public abstract String getMessageType();

    public void setSender(String _sender)throws IllegalArgumentException {
        if(_sender.isEmpty())
            throw new IllegalArgumentException("Sender name is empty");
        this.sender = _sender;
    }

    public String getSender() {
        return sender;
    }

    public void setContent(String _content) throws IllegalArgumentException{
        if(_content.isEmpty())
            throw new IllegalArgumentException("Content is empty");
        this.content = _content;
    }

    public String getContent() {
        return content;
    }

    public void setSenderDate(Date _senderDate) {
        this.sendDate = _senderDate;
    }

    public Date getSenderDate() {
        return sendDate;
    }

    public void setTarget(String _target) throws IllegalArgumentException {
        final String REGEX_EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\\\\\\\.[a-zA-Z]{2,}$";
        if(_target.matches(REGEX_EMAIL_PATTERN))
            throw new IllegalArgumentException("Mail address invalid");
        this.target = _target;
    }

    public String getTarget() {
        return target;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return  "ID-" + this.id + " Sender: " + this.sender + " content: " + this.content + " target: " + this.target;
    }

    public int find(ArrayList<String> words) {
        for(String word : words) {
            if(content.toLowerCase().contains(word.toLowerCase())){
                return this.id;
            }
        }
        return 0;
    }





}


