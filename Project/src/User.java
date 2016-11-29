/**
 * @author Gurek Singh 2015033
 * @author Abhishek Chauhan 2015005
 *
 */
public class User 
{
	private Integer uid;
	private String type, name, username, password, department, DOB;
	
	User(Integer uid, String type, String name, String username, String password, String department, String DOB)
	{
		this.uid = uid;
		this.type = type;
		this.name = name;
		this.username = username;
		this.password = password;
		this.department = department;
		this.DOB = DOB;
	}
	
	public String toString()
	{
		return uid + "," 
			+ type + ","
			+ name + ","
			+ username + ","
			+ password + ","
			+ department + ","
			+ DOB;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password;
	}

	public String getType()
	{
		return type;
	}

	public String getName()
	{
		return name;
	}
	
	public String getDepartment()
	{
		return department;
	}
	
	public String getDOB()
	{
		return DOB;
	}
	
	public Integer getUID()
	{
		return uid;
	}
	
	
}
