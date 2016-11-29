import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.*;
import javax.swing.*;

/**
 * @author Gurek Singh 2015033
 * @author Abhishek Chauhan 2015005
 *
 */
public class SupervisorScreen
{
	private JFrame frame;
	private JPanel panel, homePanel, staffPanel, reportsPanel, logisticsPanel, requestsPanel;
	private JLabel title, ladd, ldel, staffText;
	private JButton logout, home, staff, reports, logistics, requests, submit;
	private JTextField add, del;
	
	SupervisorScreen()
	{
		init_all();
		panel.setLayout(null);
		title.setBounds(25, 25, 550, 50);
		title.setFont(new Font("Arial", Font.BOLD, 20));
		
		home.setBounds(25, 75, 140, 50);
		staff.setBounds(165, 75, 140, 50);
		reports.setBounds(305, 75, 140, 50);
		logistics.setBounds(445, 75, 140, 50);
		requests.setBounds(585, 75, 140, 50);
		logout.setBounds(725, 75, 140, 50);

		initPanel();
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 700);
		frame.setVisible(true);
	}
	
	public void init_logout()
	{
		logout.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				panel.setVisible(false);
				frame.getContentPane().remove(panel);
				frame.revalidate();
				frame.setVisible(false);
				Main.LoggedIn = null;
				Main.main(null);
			}
		});
	}	
	
	public void init_all()
	{
		frame = new JFrame("Supervisor Panel");
		panel = new JPanel();
		title = new JLabel("Welcome Supervisor, " + Main.LoggedIn.getName());
		logout = new JButton("Logout");
		init_logout();
		home = new JButton("Home");
		init_home();
		staff = new JButton("Staff");
		init_staff();
		reports = new JButton("Reports");
		logistics = new JButton("Logistics");
		requests = new JButton("Requests");
		homePanel = new JPanel();
		staffPanel = new JPanel();
	}
	
	public void init_home()
	{
		home.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				frame.getContentPane().removeAll();
				frame.revalidate();
				frame.getContentPane().add(panel);
				initHomePanel();
				frame.getContentPane().add(homePanel);
				frame.revalidate();
			}
		});
	}
	
	public void init_staff()
	{
		staff.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				frame.getContentPane().removeAll();
				frame.revalidate();
				frame.getContentPane().add(panel);
				initStaffPanel();
				frame.getContentPane().add(staffPanel);
				frame.revalidate();
			}
		});
	}
	public void initPanel()
	{		
		panel.add(title);
		panel.add(home);
		panel.add(staff);
		panel.add(reports);
		panel.add(logistics);
		panel.add(requests);
		panel.add(logout);
	}
	
	public void initHomePanel()
	{
		JLabel homeText = new JLabel("<html>UID: " + Main.LoggedIn.getUID() + "<br />Type: " + Main.LoggedIn.getType() + "<br />Name: " + Main.LoggedIn.getName() + "<br />Username: " + Main.LoggedIn.getUsername() + "<br />Department: " + Main.LoggedIn.getDepartment() + "<br />DOB: " + Main.LoggedIn.getDOB() + "</html>");
		homeText.setBounds(25, 200, 800, 400);
		homeText.setFont(new Font("Arial", Font.BOLD, 20));
		homePanel.setLayout(null);
		homePanel.add(homeText);
	}

	public void initStaffPanel()
	{
		staffText = new JLabel("<html>");
		add = new JTextField("Enter username of request to be added");
		del = new JTextField("Enter username of request to be deleted");
		initStaffPanelElements();
		staffPanel.add(ladd);
		staffPanel.add(add);		
		staffPanel.add(ldel);
		staffPanel.add(del);
		staffPanel.add(staffText);
		staffPanel.add(submit);
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("newusers.csv"));
			String line = null;
			while ((line = br.readLine()) != null) {
		        String[] values = line.split(",");
		        User temp = new User(Integer.valueOf(values[0]),values[1],values[2],values[3],values[4],values[5],values[6]);
		        if(!temp.getType().equals("Supervisor")){  
               staffText.setText(staffText.getText() + "<br>Name :" + temp.getName() + "&emsp;Username :" + temp.getUsername() + "&emsp;Department :" + temp.getDepartment() + "&emsp;Type :" + temp.getType());
		        }
        }
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally	{
			staffText.setText(staffText.getText() + "</html>");
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
	
	public void init_submit()
	{
		submit.setPreferredSize(new Dimension(300, 50));
		submit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(!add.getText().equals(""))
				{
					BufferedReader br = null;
					PrintWriter pw = null, pw1 = null;
					try {
						pw = new PrintWriter(new FileOutputStream(new File("newusers1.csv"), true));
						br = new BufferedReader(new FileReader("newusers.csv"));
						pw1 = new PrintWriter(new FileOutputStream(new File("users.csv"), true));
						String line = null;
						while ((line = br.readLine()) != null) {
					        String[] values = line.split(",");
					        User temp = new User(Integer.valueOf(values[0]),values[1],values[2],values[3],values[4],values[5],values[6]);
					        if(temp.getUsername().equals(add.getText()))
					        {
					        	pw1.println(temp.toString());
					        }
					        else {
					        	pw.println(line);
					        }
						}
					}
					catch(FileNotFoundException e1) {
						e1.printStackTrace();
					}
					catch (IOException e1) {
						e1.printStackTrace();
					}
					finally	{
						if(br!=null){
							try{
								br.close();
							}
							catch(IOException e1){
								e1.printStackTrace();
							}
						}
						pw.close();
						pw1.close();
						File delFile = new File("newusers.csv");
						File renameFile = new File("newusers1.csv");
					    try {
					    	Files.move(renameFile.toPath(), delFile.toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING);
					    }
					    catch (FileNotFoundException ex)
					    {
					    	ex.printStackTrace();
					    }
					    catch (IOException ex)
					    {
					    	ex.printStackTrace();
					    }
					}
				}
				if(!del.getText().equals(""))
				{
					System.out.println("User to be removed " + del.getText());
					BufferedReader br = null;
					PrintWriter pw = null;
					try {
						pw = new PrintWriter(new FileOutputStream(new File("newusers1.csv"), true));
						br = new BufferedReader(new FileReader("newusers.csv"));
						String line = null;
						while ((line = br.readLine()) != null) {
					        String[] values = line.split(",");
					        User temp = new User(Integer.valueOf(values[0]),values[1],values[2],values[3],values[4],values[5],values[6]);
					        if(!temp.getUsername().equals(del.getText()))
					        {
					        	pw.println(line);
					        }
						}
					}
					catch(FileNotFoundException e1) {
						e1.printStackTrace();
					}
					catch (IOException e1) {
						e1.printStackTrace();
					}
					finally	{
						if(br!=null){
							try{
								br.close();
							}
							catch(IOException e1){
								e1.printStackTrace();
							}
						}
						pw.close();
						File delFile = new File("newusers.csv");
						File renameFile = new File("newusers1.csv");
					    try {
					    	Files.move(renameFile.toPath(), delFile.toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING);
					    }
					    catch (FileNotFoundException ex)
					    {
					    	ex.printStackTrace();
					    }
					    catch (IOException ex)
					    {
					    	ex.printStackTrace();
					    }
					}
				}
			}
		});
	}
	
	public void initStaffPanelElements()
	{
		staffText.setBounds(75, 150, 800, 200);
		staffText.setFont(new Font("Arial", Font.BOLD, 15));
		staffPanel.setLayout(null);
		ladd = new JLabel("Add user:");
		ladd.setBounds(75, 375, 300, 50);
		ladd.setFont(new Font("Arial", Font.BOLD, 20));
		add.setBounds(75, 425, 300, 50);
		ldel = new JLabel("Delete user:");
		ldel.setBounds(450, 375, 300, 50);
		ldel.setFont(new Font("Arial", Font.BOLD, 20));
		del.setBounds(450, 425, 300, 50);
		submit = new JButton("Submit");
		submit.setBounds(300, 500, 300, 50);
		init_submit();
	}
}
