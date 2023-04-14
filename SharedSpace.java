package GSM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author aidangaskin
 * This class will hold user posts and interactions
 */
public class SharedSpace 
{

	private static HashMap<Account, String> posts;
	
	public SharedSpace()
	{
		setPosts(new HashMap<Account, String>());
	}
	
	public void createPost(Account user, String post)
	{
		String formattedPost = user.getUserName()+":\n"+post;
		
		getPosts().put(user, formattedPost);
	}

	public static HashMap<Account, String> getPosts() 
	{
		return posts;
	}

	public static void setPosts(HashMap<Account, String> posts) 
	{
		SharedSpace.posts = posts;
	}
	
	public static String displayPosts()
	{
		String postsString = "";
		
		for (Map.Entry<Account, String> temp : posts.entrySet()) 
		{
		    Account account = temp.getKey();
		    postsString = temp.getValue()+postsString+"\n";
		}
		
		return postsString;
	}
	
	
	
	
	

}
