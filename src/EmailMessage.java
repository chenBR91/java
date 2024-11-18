import java.util.ArrayList;
import java.util.Date;

public class EmailMessage extends Message implements Idigital {
    private String subject;
    private String priority;
    private ArrayList<File> attachments;

    private enum Priority  {
        URGENT,
        REGULAR,
        GENERAL
    }


    public EmailMessage(String sender, String content, String target, Date sendDate, String subject, String priority) {
        super(sender, content, target, sendDate);
        setSubject(subject);
        this.priority = priority;
        this.attachments = new ArrayList<File>();
    }

    public EmailMessage(String sender, String content, String target, String subject, String priority) {
        super(sender, content, target);
        setSubject(subject);
        this.priority = priority;
        this.attachments = new ArrayList<File>();
    }

    public EmailMessage() {}


    public void setSubject(String subject) throws IllegalArgumentException {
        if(subject.isEmpty())
            throw new IllegalArgumentException("Subject is empty");
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }


    public void addAttachment(File inpFile) {
        this.attachments.add(inpFile);
    }


    public void removeAttachment(File files) throws AttachmentException {
        boolean isExist = attachments.remove(files);
        if(isExist)
            throw new AttachmentException("file name is not exist");
    }

    public void printAttchments() {
        for(File file : this.attachments)
            System.out.println("File name: " + file.getName() + " Type: " + file.getType());
    }


    public void getPriorityValues(){
        int counter=1;
        for (Priority priorityOption : Priority.values()) {
            System.out.println(counter + " - " + priorityOption);
            counter++;
        }
    }

    public boolean isValidPriority(int number) {
        return number >= 1 && number <= Priority.values().length;
    }

    public void setPriority(int number) {
        this.priority = Priority.values()[number - 1].toString();
    }



    @Override
    public String toString() {
        return " " + super.toString() + " Priority: " + priority;
    }


    @Override
    public String getMessageType() {
        return "Email message";
    }


    @Override
    public void printCommunicationMethod() {
        System.out.println("Protocol - Email" );
    }
}
