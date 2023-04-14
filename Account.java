package GSM;

import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;

public class Account 
{
	
	/*Class Account creates an account object for which all users will have.
	 * Users will have a unique ID and UserName.
	 * Users must be 18 or over.
	 * Users can follow or unfollow other users.
	 * Users can direct message other users.
	 */
	
	
	
	//Unique ID per user created 
	private final int ID;
	private static int incrementer = 1;
	//User's cannot change their userName
	private final String userName;
	private String forename;
	private String surname;
	//Date of birth of user
	private LocalDate dob;
	//Verify the user is 18 or over
	private LocalDate today = LocalDate.now();
    private LocalDate eighteenYearsAgo = today.minusYears(18);
	//ArrayList to collect username's and ensure uniqueness - same arrayList for all objects of Account 
	private static ArrayList<String> userNames = new ArrayList<String>();
	//ArrayList to hold all follower accounts 
	private ArrayList<Account> followerList;
	//ArrayList to hold following accounts
	private ArrayList<Account> followingList;
	//HashMap to store messages between accounts 
	private HashMap<Account, String> inbox;
	

	/*
	 * Creates an Account object and verifies unique UserName and of age 
	 * @param - all parameters are self explanatory
	 * all parameters will be used for account creation process
	 */
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
	

	/*
	 * @param recipient - the account to which the message is being sent
	 * @param message - the messsage which will be sent to the above mentioned account 
	 * This method is called on the current Account object and sends a message to a 
	 * specified account. The message is placed within both of the Account object's
	 * HashMaps to provide a chat history. Each message is appended to end of the previous.
	 * The end of each message details the respective user's name for clarification and cohesion. 
	 */
	public void sendMessageToInbox(Account recipient, String message)
	{
		String messageToSend = message;
		
		String existingMessages = recipient.inbox.get(this);
		if(existingMessages != null && !existingMessages.isEmpty())
		{
			messageToSend = existingMessages +"\n"+ message;
		}
		
		recipient.inbox.put(this,messageToSend+" :"+this.getUserName());
		//new line - should add message to both Maps
		this.inbox.put(recipient, messageToSend +" :"+this.getUserName());
	}
	/*
	 * @param user - the Account object to display the chat with
	 * @return message - the messages between the user 
	 * Call this method on the current Account object and put the 
	 * other account object as the parameter to display the chats between them.
	 * If the messages are empty - displays relevant message 
	 */
	public String displayMessageFromSpecifiedUser(Account user)
	{
		String message = "\nNo messages from this user";
		Account ifUser = user;
		
		for(HashMap.Entry<Account, String> temp: inbox.entrySet())
		{
			if(temp.getKey().equals(ifUser))
			{
				message = user.getUserName()+":\n"+temp.getValue()+"\n";
				return message;
			}
		}
		return message;
	}
	
	
	
	
	/*
	 * @param user - the Account the current user wants to clear the chat with 
	 * This method is called on the current Account and deletes the chat history
	 * between both users. 
	 */
	public void clearChatHistory(Account user)
	{
		user.inbox.clear();
		this.inbox.clear();
	}
	
	
	/*
	 * @return the ID field 
	 */
	private int getAccID()
	{
		return ID;
	}
	/*
	 * @return the userName field
	 */
	private String getUserName()
	{
		return userName;
	}
	/*
	 * @return the forename field 
	 */
	private String getForename()
	{
		return forename;
	}
	/*
	 * @return the surname field
	 */
	private String getSurname()
	{
		return surname;
	}
	/*
	 * @return the dob field
	 */
	private LocalDate getDOB()
	{
		return dob;
	}
	
	
	/*
	 * @param accountToFollow - the account object to follow
	 * adds the parameter account object to the current account object's
	 * following list.
	 * adds current account object to the parameter account object's
	 * follower list
	 */
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
	/*
	 * @param the Account to unfollow
	 * Removes current account from the parameters follower list
	 * removes parameter account from the current account following list
	 */
	public void unFollowAccount(Account accountToUnFollow)
	{
		try 
		{
			if(this.userName.equals(accountToUnFollow.getUserName()))
			{
				System.out.println("\nCan't follow yourself");
				throw new IllegalArgumentException();
			}
			followingList.remove(accountToUnFollow);
			accountToUnFollow.followerList.remove(this);
		}
		catch(Exception e)
		{
			//Use this as error checking placeholder 
			e.printStackTrace();
		}
	}
	
	
	
	/*
	 * Method for testing purposes - Delete/Amend at later date
	 */
	public String accountToString()
	{
		String ss = "\nAccount ID: "+ID+"\nUser name: "+userName
				+"\nFull Name: "+forename+" "+surname+"\nDoB: "+dob;
		
		return ss;
	}
	/*
	 * Method for testing purposes - Delete/Amend at later date
	 */
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
	/*
	 * Method for testing purposes - Delete/Amend at later date 
	 */
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
