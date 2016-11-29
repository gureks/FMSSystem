import java.io.*;

/**
 * @author Gurek Singh 2015033
 * @author Abhishek Chauhan 2015005
 *
 */
public class Main 
{
	static String lpass, luname;
	static User LoggedIn;
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
		System.out.println(Math.abs(luname.hashCode()));
		int flag=0;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("users.csv"));
			String line = null;
			while ((line = br.readLine()) != null) {
				//System.out.println(line);
		        String[] values = line.split(",");
		        User temp = new User(Integer.valueOf(values[0]),values[1],values[2],values[3],values[4],values[5],values[6]);
		        //System.out.println(temp);
		        if(temp.getUsername().equals(luname))
		        {
		        	if(temp.getPassword().equals(lpass))
		        	{
		        		LoggedIn=temp;
		        		flag=1;
		        		break;
		        	}
		        }
		        else
		        	flag=0;
			}
			if(flag==0)
				initlogin();
			else {
				System.out.println("Welcome " + LoggedIn.getName() + " - " + LoggedIn.getType());
        		loginRedirect();
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally	{
			if(br!=null){
				try{
					br.close();
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void registerUser(Integer uid, String type, String name, String username, String password, String department, String DOB)
	{
		System.out.println(uid);
		System.out.println(type);
		System.out.println(name);
		System.out.println(username);
		System.out.println(password);
		System.out.println(department);
		System.out.println(DOB);	
		User newUser = new User(uid, type, name, username, password, department, DOB);
		System.out.println(newUser.toString());
		try 
		{
			PrintWriter pw = new PrintWriter(new FileOutputStream(new File("newusers.csv"), true));
			pw.println(newUser.toString());			
			pw.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void loginRedirect()
	{
		if(LoggedIn.getType().equals("Admin"))
		{
			AdminScreen adminscreen = new AdminScreen();
		}
		else if(LoggedIn.getType().equals("Supervisor"))
		{
			SupervisorScreen superscreen = new SupervisorScreen();
		}
		else
		{
			System.out.println("Welcome, staff of " + LoggedIn.getDepartment());
		}
	}
}
