package GSM;

public class TesterMessaging {

	public static void main(String[] args) 
	{
		Account user1 = new Account("Gvskin", "Aidan", "Gaskin", 1998, 5, 15);
		Account user2 = new Account("Lvcas", "Lucas", "Gaskin", 1998, 5, 15);
		Account user3 = new Account("Drvw", "Drew", "Gaskin", 1998, 5, 15);

		
//		user1.sendMessageToInbox(user2, "Hello this is a message in your inbox");
//		user3.sendMessageToInbox(user2, "From User3");
//		System.out.println(user2.displayMessageFromSpecifiedUser(user1));
//		System.out.println(user2.displayMessageFromSpecifiedUser(user3));
//		user1.sendMessageToInbox(user2, "this is the amended message");
//		System.out.println(user2.displayMessageFromSpecifiedUser(user1));

		user1.sendMessageToInbox(user2, "FirstMessage");
		user1.sendMessageToInbox(user2, "SecondMessage");
		user1.sendMessageToInbox(user2, "Have another message!");
		System.out.println(user2.displayMessageFromSpecifiedUser(user1));

	
	}

}
