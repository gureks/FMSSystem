import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.*;
import javax.swing.*;

/**
 * @author Gurek Singh 2015033
 * @author Abhishek Chauhan 2015005
 *
 */
public class AdminScreen
{
	private JFrame frame;
	private JPanel panel, homePanel, staffPanel, reportsPanel, logisticsPanel, requestsPanel;
	private JLabel title;
	private JButton logout, home, staff, reports, logistics, requests;
	
	AdminScreen()
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
		frame = new JFrame("Admin Panel");
		panel = new JPanel();
		title = new JLabel("Welcome Admin, " + Main.LoggedIn.getName());
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
				frame.add(panel);
				initHomePanel();
				frame.add(homePanel);
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
				frame.add(panel);
				initStaffPanel();
				frame.add(staffPanel);
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
		homeText.setBounds(25, 175, 800, 500);
		homeText.setFont(new Font("Arial", Font.BOLD, 20));
		homePanel.setLayout(null);
		homePanel.add(homeText);
	}

	public void initStaffPanel()
	{
		JLabel staffText = new JLabel("Staff Panel hai yeh");
		staffText.setBounds(25, 175, 800, 500);
		staffText.setFont(new Font("Arial", Font.BOLD, 20));
		staffPanel.setLayout(null);
		staffPanel.add(staffText);
	}
}