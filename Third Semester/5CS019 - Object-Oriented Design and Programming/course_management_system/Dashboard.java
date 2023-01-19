package course_management_system;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import course_management_system.util.Logo;
import java.awt.Font;
import javax.swing.JTextField;

public class Dashboard extends JPanel {
	
		private static final long serialVersionUID = -3421670490444154816L;
		private JTextField textField;

	public Dashboard(JFrame frame, Logo logo, String name) {
		JPanel splashFrame = new JPanel();
		splashFrame.setBackground(new Color(255, 255, 255));
		splashFrame.setBounds(0, -7, 1480, 701);
		frame.getContentPane().add(splashFrame);
		splashFrame.setVisible(true);
		splashFrame.setLayout(null);
		
		JLabel logoImg = new JLabel(logo.getLogo(50,50));
		logoImg.setBounds(38, 33, 50, 50);
		splashFrame.add(logoImg);
		
		JLabel lblNewLabel = new JLabel("Welcome back, "+ name + " ! 👋");
		lblNewLabel.setFont(new Font("Futura", Font.PLAIN, 20));
		lblNewLabel.setBounds(188, 33, 449, 37);
		splashFrame.add(lblNewLabel);
		
		JLabel lblThursdayJan = new JLabel("Thursday, Jan 19 2023");
		lblThursdayJan.setEnabled(false);
		lblThursdayJan.setFont(new Font("Futura", Font.PLAIN, 15));
		lblThursdayJan.setBounds(188, 65, 449, 21);
		splashFrame.add(lblThursdayJan);
		
		textField = new JTextField();
		textField.setFont(new Font("Futura", Font.PLAIN, 15));
		textField.setBounds(936, 33, 418, 45);
		splashFrame.add(textField);
		textField.setColumns(10);
    
	}
}

