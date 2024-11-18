import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<Message> messages = new ArrayList<Message>();

        // Initial Data
        try {
            // Add BoardMessages
            messages.add(new BoardMessage("Chen", "Hello", "ChenBrown@gmail.com"));
            messages.add(new BoardMessage("Noa", "JS", "noa@gmail.com"));

            // Add EmailMessages
            File file1 = new File("Java book", "doc");
            File file2 = new File("Flies", "csv");
            messages.add(new EmailMessage("Moshe", "java", "mosh@gmail.com", "Mail subject", "URGENT"));
            messages.add(new EmailMessage("Yuval", "Mail message1", "yuval@gmail.com", "schedule","REGULAR"));
            EmailMessage emailMessage = (EmailMessage) messages.get(2);
            emailMessage.addAttachment(file1);

            emailMessage = (EmailMessage) messages.get(3);
            emailMessage.addAttachment(file2);

            messages.add(new WhatsappMessage("Aviv", "ping", "0523676870", "054742364"));
            messages.add(new WhatsappMessage("Tom", "pong", "0547423644", "052367687"));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // print a menu
        menu();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int choiceDigit = Integer.parseInt(scanner.nextLine());

            try {
                switch (choiceDigit) {
                    case 1:
                        addMessage(messages);
                        break;
                    case 2:
                        printAllMessages(messages);
                        break;
                    case 3:
                        removeMessage(messages);
                        break;
                    case 4:
                        ArrayList<Integer> arrIdContainWord = new ArrayList<>();
                        arrIdContainWord = searchMessageByWord(messages);
                        System.out.println("This array gives id numbers that contains word in message by his search: " + arrIdContainWord);
                        break;
                    case 5:
                        printIdigitalMessage(messages);
                        break;

                    case 6:
                        printAllFiles(messages);
                        break;

                    case 7:
                        System.out.println("Program ended!");
                        scanner.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Please insert number between 1 - 6");
                        break;
                }
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }

            System.out.print("\n");
            menu();

        }

    }


    static void menu() {
        System.out.println("1 - Add a message");
        System.out.println("2 - Print all messages");
        System.out.println("3 - Delete message");
        System.out.println("4 - Search message by word");
        System.out.println("5 - Print digital messages");
        System.out.println("6 - Print all files");
        System.out.println("7 - Exit");
    }

    static void printAllMessages(ArrayList<Message> messages) {
        System.out.println("**********Board Messages**********");
        for(Message message : messages)
            System.out.println(message.toString());
    }


    static void addMessage(ArrayList<Message> messages) {
        System.out.println("\nChoose message type:");
        System.out.println("1. Email Message");
        System.out.println("2. Whatsapp Message");
        System.out.println("3. Board Messages\n");
        Scanner innerscanner = new Scanner(System.in);
        try {

            int choseMsg = Integer.parseInt(innerscanner.nextLine());
            if (choseMsg == 1) {

                System.out.println("What's your name:");
                String nameSender = innerscanner.nextLine();
                System.out.println("Enter a subject");
                String subject = innerscanner.nextLine();
                System.out.println("Enter a content");
                String contect = innerscanner.nextLine();
                System.out.println("Enter your mail");
                String target = innerscanner.nextLine();

                EmailMessage emailMsg = new EmailMessage();
                emailMsg.getPriorityValues();
                System.out.println("Choose priority number from this list");
                int priorityNum = innerscanner.nextInt();

                while (!emailMsg.isValidPriority(priorityNum)) {
                    System.out.println("Invalid priority number.Choose again-");
                    priorityNum = innerscanner.nextInt();
                }

                emailMsg.setPriority(priorityNum);
                emailMsg.setSender(nameSender);
                emailMsg.setContent(contect);
                emailMsg.setTarget(target);
                messages.add(emailMsg);
                System.out.println("Mail message sent!");
            }
            else if (choseMsg == 2)
            {
                System.out.println("What's your name:");
                String nameSender = innerscanner.nextLine();
                System.out.print("Enter the origin phone: ");
                String sourcePhone = innerscanner.nextLine();
                System.out.print("Enter the target phone: ");
                String targetPhone = innerscanner.nextLine();
                System.out.println("Enter a content");
                String contect = innerscanner.nextLine();

                WhatsappMessage whatsapp = new WhatsappMessage(nameSender, contect, sourcePhone, targetPhone);
                messages.add(whatsapp);
                System.out.println("Whatsapp message sent!");
            }

            else if(choseMsg == 3) {

            }

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    static void removeMessage(ArrayList<Message> messages) {
        try {
            System.out.println("Which message do you want remove? ");
            Scanner scanner = new Scanner(System.in);
            int index = scanner.nextInt();
            messages.remove(index);
            System.out.println("Message removed successful\n");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    static ArrayList<Integer> searchMessageByWord(ArrayList<Message> messages) {
        int indexId;

        ArrayList<Integer> idArr = new ArrayList<Integer>();
        ArrayList<String> wordsList = new ArrayList<String>();
        System.out.println("Enter the words that do you want search at messages board: ");
        wordsList.add("Hello");

        for(Message message : messages) {
            indexId = message.find(wordsList);
            if(indexId != 0)
                idArr.add(indexId);
        }
        return idArr;
    }

    static void printIdigitalMessage(ArrayList<Message> messages) {
        System.out.println("\n******** Idigital Messages ********");
        for(Message msg : messages) {
            if(msg instanceof Idigital) {
                System.out.println(msg.toString());
            }
        }
    }

    static void printAllFiles(ArrayList<Message> messages) {
        System.out.println("\n******** Files ********");
        for(Message message : messages){
            if(message instanceof EmailMessage) {
                ((EmailMessage) message).printAttchments();
            }
        }
    }

}