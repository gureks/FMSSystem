/**
 * @author Gurek Singh 2015033
 * @author Abhishek Chauhan 2015005	
 */


public class UserDoesntExistException extends Exception
{
	private String username;
	
	public UserDoesntExistException(String username)
	{
		this.username = username;
	}
	
	public String toString()
	{
		return "The following user doesn't exist :	" + username;
	}
}
