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
	
	
	

	//private static HashMap<Account, String> posts;
	
//	public SharedSpace()
//	{
//		setPosts(new HashMap<Account, String>());
//	}
	public SharedSpace()
	{
		setPosts(new ArrayList<String>());
	}
	
	public void createPost(Account user, String post)
	{
		String formattedPost = user.getUserName()+":\n"+post;
		
		getPosts().add(formattedPost);
	}

//	public static HashMap<Account, String> getPosts() 
//	{
//		return posts;
//	}

//	public static void setPosts(HashMap<Account, String> posts) 
//	{
//		SharedSpace.posts = posts;
//	}
	
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
	
//	public static String displayPosts()
//	{
//		
//		String post = "";
//		for (Map.Entry<Account, String> temp : posts.entrySet()) 
//		{
//		    //Account account = temp.getKey();
//		    post = post+"\n"+temp.getValue()+"\n";
//		    postArray.add(post);//adding new posts to arrayList 
////		    for(int i = 0; i<postArray.size(); i++)
////		    {
////		    	post = post + postArray.get(i);
////		    	return post;
////		    }
//		}
//		for(int i = 0; i<postArray.size(); i++)
//		{
//			return post;
//		}
//		return "no posts";
//	}
	
	public static void setPosts(ArrayList<String> posts) 
	{
		SharedSpace.postArray = posts;
	}
	
	public static ArrayList<String> getPosts() 
	{
		return postArray;
	}
	
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
