import java.util.Date;

public class WhatsappMessage extends Message implements Idigital {
    String phoneNumber;
    boolean isSeen;
    String destinationPhoneNumber;

    private final String REGEX_PATTERN_PHONENUMBER = "^\\d+$";

    public WhatsappMessage(String sender, String content, String phoneNumber, String destinationPhoneNumber) {
        super(sender, content, "NULL");
        setPhoneNumber(phoneNumber);
        setDestinationPhoneNumber(destinationPhoneNumber);
        isSeen = false;
    }

    public void setPhoneNumber(String phoneNumber) throws IllegalArgumentException{
        if(phoneNumber.matches(REGEX_PATTERN_PHONENUMBER))
            this.phoneNumber = phoneNumber;
        else
            throw new IllegalArgumentException("The source phone number invalid");
    }

    public void setDestinationPhoneNumber(String destinationPhoneNumber) throws IllegalArgumentException {
        if(destinationPhoneNumber.matches(REGEX_PATTERN_PHONENUMBER))
            this.destinationPhoneNumber = destinationPhoneNumber;
        else
            throw new IllegalArgumentException("The destination phone number invalid");
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDestinationPhoneNumber() {
        return destinationPhoneNumber;
    }

    public boolean getIsSeen() {
        return isSeen;
    }

    @Override
    public String getMessageType() {
        return "Whatsapp message";
    }

    @Override
    public String toString() {
        return  "ID-" + super.getId() + " Sender: " + super.getSender() + " source number: " + phoneNumber + " destination: " + destinationPhoneNumber;
    }

    @Override
    public void printCommunicationMethod() {
        System.out.println("Protocol - SMS");
    }
}
