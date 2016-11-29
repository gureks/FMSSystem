/**
 * @author Gurek Singh 2015033
 * @author Abhishek Chauhan 2015005
 *
 */
public class User 
{
	Integer UID;
	String type, name, username, password, department, DOB;
	
	User(String type, String name, String username, String password, String department, String DOB)
	{
		UID = Math.abs(this.username.hashCode());
		type=this.type;
		name=this.name;
		username=this.username;
		password=this.password;
		department=this.department;
		DOB=this.DOB;
	}
	
	public String toString()
	{
		return UID + "," 
			+ type + ","
			+ name + ","
			+ username + ","
			+ password + ","
			+ department + ","
			+ DOB;
	}
}
