package GSM;

public class TestingSharedSpace 
{
	public static void main(String[] args)
	{
		Account aidan = new Account("Gvskin", "Aidan", "Gaskin", 1998, 5, 15);
		Account lucas = new Account("Lvcas", "Lucas", "Gaskin", 1998, 5, 15);
		Account jayden = new Account("Jvyden", "Jayden", "Gaskin", 1998, 5, 15);

		aidan.createPost("1st Post from AIDAN");
		lucas.createPost("1st Post from LUCAS");
		jayden.createPost("1st Post from JAYDEN");
		aidan.createPost("2nd Post from AIDAN");

		System.out.println(SharedSpace.displayPosts());
	}
	
	
}
