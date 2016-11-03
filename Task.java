/**
 * @author Gurek Singh 2015033
 * @author Abhishek Chauhan 2015005	
 */

import java.util.Date;

public class Task
{
	private Date deadline;
	private String status;
	private String timestamp;
	
	public Task(Date deadline, String status="NOT STARTED")
	{
		this.deadline = deadline;
		this.status = status;
		timestamp = new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date());
	}

	public Date getDeadline()
	{
		return deadline;
	}

	public String getStatus()
	{
		return status;
	}

	public String getTimestamp()
	{
		return timestamp;
	}

	public void setDeadline(Date deadline)
	{
		this.deadline = deadline;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public void setTimestamp()
	{
		timestamp = new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date());
	}

	public String toString()
	{
		return "Deadline: " + deadline + "Staus: " + status;
	}
}
