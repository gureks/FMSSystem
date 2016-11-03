/**
 * @author Gurek Singh 2015033
 * @author Abhishek Chauhan 2015005	
 */


public class NotLoggedInException extends Exception
{
	private String username;
	
	public NotLoggedInException(String username)
	{
		this.username = username;
	}
	
	public String toString()
	{
		return "Cannot logout '" + username + "' cause it is not logged in.";
	}
}
