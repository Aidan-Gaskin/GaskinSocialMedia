package GSM;

public class TesterMessaging {

	public static void main(String[] args) 
	{
		Account user1 = new Account("Gvskin", "Aidan", "Gaskin", 1998, 5, 15);

		Account user2 = new Account("Lvcas", "Lucas", "Gaskin", 1998, 5, 15);
		
		
		user1.sendMessageToInbox(user2, "Hello this is a message in your inbox");
		
		System.out.println(user2.displayMessageFromSpecifiedUser(user1));
	}

}
