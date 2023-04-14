package GSM;

public class TesterUnfollowing 
{
	public static void main(String[] args)
	{
		//accounts
		Account aidan = new Account("Gvskin", "Aidan", "Gaskin", 1998, 5, 15);
		Account lucas = new Account("Lvcas", "Lucas", "Gaskin", 1998, 5, 15);
		
		aidan.followAccount(lucas);
		System.out.println(aidan.printAllFollowing());
		System.out.println(lucas.printAllFollowers());

		aidan.unFollowAccount(lucas);
		System.out.println(aidan.printAllFollowing());
		System.out.println(lucas.printAllFollowers());

		
	}

}
