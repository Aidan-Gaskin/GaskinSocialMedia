package GSM;

import java.util.ArrayList;

/**
 * 
 * @author aidangaskin
 * This class will hold user posts and interactions
 * @field postArray - stores all user posts
 */
public class SharedSpace 
{
	
	private static ArrayList<String> postArray = new ArrayList<String>();

	/*
	 * Calls the initialisation method to enable the postArray
	 */
	public SharedSpace()
	{
		setPosts(new ArrayList<String>());
	}
	/*
	 * Initialise the postArray
	 */
	private static void setPosts(ArrayList<String> posts) 
	{
		SharedSpace.postArray = posts;
	}
	/*
	 * enables the postArray to be accessed within the Account class
	 */
	public static ArrayList<String> getPosts() 
	{
		return postArray;
	}
	/*
	 * displays All posts
	 */
	public static String displayPosts()
	{
		String post="";
		
		if(postArray.isEmpty())
		{
			post = "\nNo current posts";
		}
		
		for(int i = 0; i<postArray.size();i++)
		{
			post = post + postArray.get(i);
		}
		return post;
	}
	

}
