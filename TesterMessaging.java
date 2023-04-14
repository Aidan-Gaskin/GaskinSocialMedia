package GSM;

public class TesterMessaging {

	public static void main(String[] args) 
	{
		Account aidan = new Account("Gvskin", "Aidan", "Gaskin", 1998, 5, 15);
		Account lucas = new Account("Lvcas", "Lucas", "Gaskin", 1998, 5, 15);
		Account drew = new Account("Drvw", "Drew", "Gaskin", 1998, 5, 15);
		
//		aidan.sendMessageToInbox(lucas, "FirstMessage");
//		aidan.sendMessageToInbox(lucas, "SecondMessage");
//		
//		System.out.println(lucas.displayMessageFromSpecifiedUser(aidan));
//		
//		aidan.sendMessageToInbox(lucas, "Have another message!");
//		lucas.sendMessageToInbox(aidan, "Hi from me");
//		
//		System.out.println(lucas.displayMessageFromSpecifiedUser(aidan));
//		System.out.println(aidan.displayMessageFromSpecifiedUser(lucas));
		
		aidan.sendMessageToInbox(lucas, "Hi Lucas, its Aidan");
		System.out.println(lucas.displayMessageFromSpecifiedUser(aidan));
		lucas.sendMessageToInbox(aidan, "Hello Aidan, its Lucas");
		System.out.println(lucas.displayMessageFromSpecifiedUser(aidan));

		//Checking the inbox from the other account 
		System.out.println(aidan.displayMessageFromSpecifiedUser(lucas));

		//Checking the inbox from account with no message history
		System.out.println(lucas.displayMessageFromSpecifiedUser(drew));
		lucas.sendMessageToInbox(drew, "Hello Drew, its Lucas");
		//System.out.println(lucas.displayMessageFromSpecifiedUser(drew));
		System.out.println(drew.displayMessageFromSpecifiedUser(lucas));

		
		
	}

}
