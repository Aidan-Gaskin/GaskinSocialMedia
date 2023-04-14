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
	
	//ArrayList to store all posts within
	private static ArrayList<String> postArray = new ArrayList<String>();
	
	
	

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
	
//	public static String displayPosts()
//	{
//		String postsString = "";
//		
//		for (Map.Entry<Account, String> temp : posts.entrySet()) 
//		{
//		    Account account = temp.getKey();
//		    postsString = temp.getValue()+postsString+"\n";
//		    postArray.add(postsString);//adding new posts to arrayList
//		}
//		
//		return postsString;
//	}
	
	public static String displayPosts()
	{
		
		for (Map.Entry<Account, String> temp : posts.entrySet()) 
		{
		    //Account account = temp.getKey();
		    String post = temp.getValue()+"\n";
		    postArray.add(post);//adding new posts to arrayList
		    for(int i = 0; i<postArray.size(); i++)
		    {
		    	post = post + postArray.get(i);
		    	return post;
		    }
		}
		return "no posts";
	}
	
	
	

}
