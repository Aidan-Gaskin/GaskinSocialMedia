package GSM;

public class Account 
{
	//Unique ID per user created 
	private final int uniqueID;
	private static int incrementer = 1;
	
	private final String userName;

	
	public Account(String userName)
	{
		this.uniqueID = incrementer;
		incrementer = incrementer + 1;
		this.userName = userName;
	}
}
