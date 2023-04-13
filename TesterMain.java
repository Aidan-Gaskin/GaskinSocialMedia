package GSM;

public class TesterMain 
{
	public static void main(String[] args) 
	{
		Account user1 = new Account("Gvskin", "Aidan", "Gaskin", 1998, 5, 15);
		
		//System.out.println(user1.accountToString());
		
		Account user2 = new Account("L", "Lucas", "Gaskin", 1998, 5, 15);
		
		user1.followAccount(user2);
		
		//method to print follower/following list 

		
		Account user3 = new Account("D", "Drew", "Wass", 1998, 5, 15);
		user3.followAccount(user2);
		user3.followAccount(user1);
		user1.followAccount(user3);
		user2.followAccount(user3);
		
		System.out.println(user3.printAllFollowers());
		System.out.println(user3.printAllFollowing());
		
		System.out.println(user2.printAllFollowers());
		System.out.println(user1.printAllFollowers());

		
		System.out.println(user2.printAllFollowing());
		System.out.println(user1.printAllFollowing());
		
		
		
		
		
		
	}

}
