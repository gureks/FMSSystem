/**
 * @author Gurek Singh 2015033
 * @author Abhishek Chauhan 2015005
 *
 */
public class Main 
{
	static String lpass, luname;
	public static void main(String[] args) 
	{
		WelcomeScreen welcome = new WelcomeScreen();
	}
	
	public static void initlogin()
	{
		LoginScreen login = new LoginScreen();
	}

	public static void initregister()
	{
		RegisterScreen register = new RegisterScreen();
	}
	
	public static void login()
	{
		System.out.println("Logging in " + luname + " with " + lpass);
	}
	
	public static void registerUser(String type, String name, String username, String password, String department, String DOB)
	{
		System.out.println(type);
		System.out.println(name);
		System.out.println(username);
		System.out.println(password);
		System.out.println(department);
		System.out.println(DOB);	
	}
}
