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
public class WelcomeScreen
{
	private JFrame frame;
	private JPanel panel;
	private JLabel title, author;
	private JButton login, register;
	
	WelcomeScreen()
	{
		frame = new JFrame("Welcome");
		panel = new JPanel();
		title = new JLabel("Facility Management Services System");
		author = new JLabel("Gurek Singh & Abhishek Chauhan");
		login = new JButton("Login");
		init_login();
		register = new JButton("Register");
		init_register();
		
		panel.setLayout(null);
		title.setBounds(175, 150, 550, 50);
		title.setFont(new Font("Arial", Font.BOLD, 30));
		author.setBounds(285, 200, 375, 50);
		author.setFont(new Font("Arial", Font.ITALIC, 20));
		login.setBounds(300, 300, 300, 50);
		register.setBounds(300, 400, 300, 50);
		
		panel.add(title);
		panel.add(author);
		panel.add(login);
		panel.add(register);
		
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
				Main.initlogin();
			}
		});
	}	
	
	public void init_register()
	{
		register.setPreferredSize(new Dimension(300, 50));
		register.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				panel.setVisible(false);
				frame.getContentPane().remove(panel);
				frame.revalidate();
				frame.setVisible(false);
				Main.initregister();
			}
		});
	}
}
