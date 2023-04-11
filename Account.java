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
	
	//
	private LocalDate dob;
	//for verifying user age 
	private final LocalDate today = LocalDate.now();

	
	//ArrayList to collect username's and ensure uniqueness
	private static ArrayList<String> userNames;
	
	public Account(String userName, String forename, String surname
			, int birthYear, int birthMonth, int birthDay)
	{
		if(userNameExists())
		{
			throw new IllegalArgumentException("Note to self: Change this at later date");
		}
		else
			
		ID = incrementer;
		incrementer = incrementer + 1;
		this.userName = userName;
		
		//obtain users date of birth 
		this.dob = LocalDate.of(birthYear, birthMonth, birthDay);
		
	}
	
	//Method to determine if userName already exists and
	//will be used within the Account constructor
	private boolean userNameExists()
	{
		if(userNames.contains(userName))				
		{
			return true;
		}
		return false;
	}
	//Method to determine user is 18 or over
	private boolean isUserOfAge()
	{
		if()
		{
			
			return false;
		}
		
		return true;
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
