package GSM;

import java.util.ArrayList;
import java.util.HashMap;
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
	//HashMap to store messages
	private HashMap<Account, String> inbox;
	

	
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
		//Initialising follower/following lists 
		followerList = new ArrayList<Account>();
		followingList = new ArrayList<Account>();
		//Initialising inbox 
		inbox = new HashMap<Account, String>();
	}
	
	//keeps record of previous messages, creates a chat box of sorts 
	public void sendMessageToInbox(Account recipient, String message)
	{
		String messageToSend = message;
		
		String existingMessages = recipient.inbox.get(this);
		if(existingMessages != null && !existingMessages.isEmpty())
		{
			messageToSend = existingMessages +"\n"+ message;
		}
		
		recipient.inbox.put(this, messageToSend);
	}
	public String displayMessageFromSpecifiedUser(Account user)
	{
		String message = "\nNo messages from this user";
		Account ifUser = user;
		
		for(HashMap.Entry<Account, String> temp: inbox.entrySet())
		{
			if(temp.getKey().equals(ifUser))
			{
				message = user.getUserName()+":\n"+temp.getValue();
				return message;
			}
		}
		return message;
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
			if(this.userName.equals(accountToFollow.getUserName()))
			{
				System.out.println("\nCan't follow yourself");
				throw new IllegalArgumentException();
			}
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
		String s = "";
		
		//checking empty list
		if(followerList.isEmpty())
		{
			return s = this.getUserName()+" Follower List is Empty";
		}
		//looping through and list them 
		for(Account temp: followerList)
		{
			s = s + temp.getUserName() + "\n";
		}
		return this.getUserName()+" Follower List:\n"+s;
	}
	
	public String printAllFollowing()
	{
		String s = "";
		
		//checking empty list
		if(followingList.isEmpty())
		{
			return s = this.getUserName()+"Following List is Empty";
		}
		//loop through and list them
		for(Account temp: followingList)
		{
			s = s + temp.getUserName() + "\n";
		}
		return this.getUserName()+" Following List:\n"+s;
	}
	
	
	
	
	
	
}
