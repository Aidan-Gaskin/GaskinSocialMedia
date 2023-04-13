package GSM;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Period;

public class Account 
{
	//Unique ID per user created 
	private final int ID;
	private static int incrementer = 1;
	//Final string userName, user's cannot change their userName
	private final String userName;
	
	private String forename;
	private String surname;
	
	
	//Date of birth of user
	private LocalDate dob;
	
	
	//for verifying user age 
	private LocalDate today = LocalDate.now();
    private LocalDate eighteenYearsAgo = today.minusYears(18);


	
	//ArrayList to collect username's and ensure uniqueness - same arrayList for all objects of Account 
	private static ArrayList<String> userNames = new ArrayList<String>();
	
	//ArrayList to hold all followers
	private ArrayList<Account> followerList;
	//ArrayList to hold all following
	private ArrayList<Account> followingList;
	

	
	public Account(String userName, String forename, String surname
			, int birthYear, int birthMonth, int birthDay)
	{
		//Check for user name
		if(userNames.contains(userName))
		{
			//amend once the functionality is complete 
			System.out.println("\nUsername already exists. Please change name");
			throw new IllegalArgumentException();
		}
		
		//Check for DOB
		this.dob = LocalDate.of(birthYear, birthMonth, birthDay);
        if (dob.isAfter(eighteenYearsAgo)) 
        {
            System.out.println("\nUser must be at least 18 years old.");
            throw new IllegalArgumentException();
        }

		//Continue with account creation
		ID = incrementer;
		incrementer = incrementer + 1;
		this.forename = forename;
		this.surname = surname;
		this.userName = userName;
		userNames.add(userName);
		
		followerList = new ArrayList<Account>();
		followingList = new ArrayList<Account>();
		
	}
	
	//simple getters for now
	private int getAccID()
	{
		return ID;
	}
	private String getUserName()
	{
		return userName;
	}
	private String getForename()
	{
		return forename;
	}
	private String getSurname()
	{
		return surname;
	}
	private LocalDate getDOB()
	{
		return dob;
	}
	
	
	
	//Add to following list //also adds to follwer list of account in parameter //no need for add follower method
	public void followAccount(Account accountToFollow)
	{
		try 
		{
			followingList.add(accountToFollow);
			accountToFollow.followerList.add(this);
		}
		catch (Exception e)
		{
			//will create extensive error checking after functionality achieved
			e.printStackTrace();
		}
	}
	
	public String accountToString()
	{
		String ss = "\nAccount ID: "+ID+"\nUser name: "+userName
				+"\nFull Name: "+forename+" "+surname+"\nDoB: "+dob;
		
		return ss;
	}
	
	public String printAllFollowers()
	{
		String followers = "";
		
		if(followerList.isEmpty())
		{
			return followers = "\nNo followers";
		}
		
		for(Account temp: followerList)
		{
			followers = followers + temp.accountToString() + "\n";
		}
		return followers;
	}
	
	public String printAllFollowing()
	{
		String following = "";
		
		if(followingList.isEmpty())
		{
			return following = "\nNot following any accounts";
		}
		for(Account temp: followingList)
		{
			following = "FOLLOWING:\n" + following + temp.accountToString() + "\n";
		}
		return following;
	}
	
	
	
	
	
	
	
	
}
