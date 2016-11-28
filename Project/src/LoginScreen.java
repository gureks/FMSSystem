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
public class LoginScreen
{
	JFrame frame;
	JPanel panel;
	JLabel title, subtitle;
	JButton login;
	JTextField username, password;
	
	LoginScreen()
	{ 
		frame = new JFrame("Login");
		panel = new JPanel();
		title = new JLabel("Login Screen");
		subtitle = new JLabel("Enter details");
		login = new JButton("Login");
		init_login();
		username = new JTextField("Username");
		password = new JTextField("Password");
		
		panel.setLayout(null);
		title.setBounds(350, 125, 200, 50);
		title.setFont(new Font("Arial", Font.BOLD, 30));
		subtitle.setBounds(380, 175, 140, 50);
		subtitle.setFont(new Font("Arial", Font.BOLD, 20));
		username.setBounds(300,250,300,50);
		password.setBounds(300, 300, 300, 50);
		login.setBounds(300, 350, 300, 50);
		
		panel.add(title);
		panel.add(subtitle);
		panel.add(username);
		panel.add(password);
		panel.add(login);
		
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 700);
		frame.setVisible(true);
	}
	
	public void init_login()
	{
		login.setPreferredSize(new Dimension(300, 50));
		login.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				panel.setVisible(false);
				frame.getContentPane().remove(panel);
				frame.revalidate();
				frame.setVisible(false);
			}
		});
	}	
}
