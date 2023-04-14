package GSM;

public class TesterMessaging {

	public static void main(String[] args) 
	{
		Account aidan = new Account("Gvskin", "Aidan", "Gaskin", 1998, 5, 15);
		Account lucas = new Account("Lvcas", "Lucas", "Gaskin", 1998, 5, 15);
		Account drew = new Account("Drvw", "Drew", "Gaskin", 1998, 5, 15);
		
		aidan.sendMessageToInbox(lucas, "FirstMessage");
		aidan.sendMessageToInbox(lucas, "SecondMessage");
		System.out.println(lucas.displayMessageFromSpecifiedUser(aidan));
		aidan.sendMessageToInbox(lucas, "Have another message!");
		lucas.sendMessageToInbox(aidan, "Hi from me");
		System.out.println(lucas.displayMessageFromSpecifiedUser(aidan));
		System.out.println(aidan.displayMessageFromSpecifiedUser(lucas));
//		System.out.println(lucas.displayMessageFromSpecifiedUser(aidan));

		
		aidan.sendMessageToChat(lucas, "FirstMessage");
		aidan.sendMessageToChat(lucas, "SecondMessage");
		System.out.println(lucas.displayChatWithUser(aidan));
		aidan.sendMessageToChat(lucas, "Have another message!");
		lucas.sendMessageToChat(aidan, "Hi from me");
		System.out.println(lucas.displayChatWithUser(aidan));
		System.out.println(aidan.displayChatWithUser(lucas));
//		System.out.println(lucas.displayMessageFromSpecifiedUser(aidan));

	
	}

}
