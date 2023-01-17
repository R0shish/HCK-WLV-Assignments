package Week9_Assignment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.JTextField;

public class Activity1 {

	private JFrame frame;
	private JTextField firstNameTxt;
	private JTextField lastNameTxt;
	private JTextField emailTxt;
	private JTextField queriesTxt;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Activity1 window = new Activity1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Activity1() {
		initialize();
	}

	private boolean validate(JTextField textField, JLabel label, String field) {
		switch (field) {
			case "Email":
				String regex = "^np+[0-9]+cs+[0-9]+s+[0-9]{6}+@heraldcollege\\.edu\\.np$";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(textField.getText());
				if (!matcher.matches()) {
					label.setText("Invalid " + field);
					return false;
				}
				label.setText("");
				return true;
			case "Query":
				if (textField.getText().isBlank()) {
					label.setText("Invalid " + field);
					return false;
				}
				label.setText("");
				return true;
			default:
				if (textField.getText().length() < 3 || textField.getText().isBlank()) {
					label.setText("Invalid " + field);
					return false;
				}
				label.setText("");
				return true;
		}
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel top = new JPanel();
		top.setBounds(0, 0, 450, 47);
		frame.getContentPane().add(top);
		top.setLayout(null);

		JLabel title = new JLabel("H@ap");
		title.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		title.setForeground(new Color(0, 0, 123));
		title.setBounds(25, 16, 56, 25);
		top.add(title);

		JLabel register = new JLabel("Register");
		register.setForeground(new Color(0, 0, 0));
		register.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		register.setBounds(263, 16, 56, 25);
		top.add(register);

		JLabel login = new JLabel("Login");
		login.setForeground(Color.BLACK);
		login.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		login.setBounds(371, 16, 56, 25);
		top.add(login);

		JPanel sidebar = new JPanel();
		sidebar.setBounds(0, 59, 113, 213);
		frame.getContentPane().add(sidebar);
		sidebar.setLayout(null);

		JPanel contentPanel = new JPanel();
		contentPanel.setBounds(113, 45, 337, 227);
		frame.getContentPane().add(contentPanel);
		contentPanel.setLayout(new CardLayout(0, 0));

		JPanel coursesPanel = new JPanel();
		contentPanel.add(coursesPanel, "name_149419749615000");
		coursesPanel.setLayout(null);

		JLabel coursesTitle = new JLabel("Bsc(Hons) Computer Science");
		coursesTitle.setBounds(19, 16, 282, 16);
		coursesPanel.add(coursesTitle);

		JTextPane coursesTxt = new JTextPane();
		coursesTxt.setText(
				"- Computational Mathematics\n- Fundamentals of Computing\n- Internet Software Architecture\n- Academic Skills and Team-Based Learning\n- Embedded System Programming\n- Introductory Programming And Problem Solving");
		coursesTxt.setBackground(new Color(238, 238, 238));
		coursesTxt.setEditable(false);
		coursesTxt.setBounds(19, 44, 312, 163);
		coursesPanel.add(coursesTxt);

		JPanel aboutUsPanel = new JPanel();
		contentPanel.add(aboutUsPanel, "name_149456508077250");
		aboutUsPanel.setLayout(null);

		JLabel aboutUsTitle = new JLabel("About Us");
		aboutUsTitle.setBounds(20, 16, 58, 16);
		aboutUsPanel.add(aboutUsTitle);

		JTextPane aboutUsSubtitle = new JTextPane();
		aboutUsSubtitle.setText(
				"Herald College Kathmandu (HCK) provides the best UK university education at most affordable fees. It offers Bachelor Degrees in IT and Business in direct partnership with the University of Wolverhampton, UK. Programmes that Herald College Kathmandu offers are flexible and have always aimed to foster a broader based knowledge.");
		aboutUsSubtitle.setEditable(false);
		aboutUsSubtitle.setBackground(SystemColor.window);
		aboutUsSubtitle.setBounds(19, 49, 301, 143);
		aboutUsPanel.add(aboutUsSubtitle);

		JPanel contactUsPanel = new JPanel();
		contentPanel.add(contactUsPanel, "name_149667967269458");
		contactUsPanel.setLayout(null);

		JLabel contactUsTitle = new JLabel("Contact Us");
		contactUsTitle.setBounds(106, 16, 69, 16);
		contactUsPanel.add(contactUsTitle);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(27, 44, 69, 16);
		contactUsPanel.add(lblFirstName);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(183, 44, 69, 16);
		contactUsPanel.add(lblLastName);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(26, 109, 34, 16);
		contactUsPanel.add(lblEmail);

		JLabel lblQueries = new JLabel("Queries");
		lblQueries.setBounds(182, 109, 48, 16);
		contactUsPanel.add(lblQueries);

		firstNameTxt = new JTextField();
		firstNameTxt.setBounds(17, 62, 130, 26);
		contactUsPanel.add(firstNameTxt);
		firstNameTxt.setColumns(10);

		lastNameTxt = new JTextField();
		lastNameTxt.setColumns(10);
		lastNameTxt.setBounds(172, 62, 130, 26);
		contactUsPanel.add(lastNameTxt);

		emailTxt = new JTextField();
		emailTxt.setColumns(10);
		emailTxt.setBounds(16, 127, 130, 26);
		contactUsPanel.add(emailTxt);

		queriesTxt = new JTextField();
		queriesTxt.setColumns(10);
		queriesTxt.setBounds(171, 127, 130, 26);
		contactUsPanel.add(queriesTxt);

		JLabel errorFirstName = new JLabel("");
		errorFirstName.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		errorFirstName.setForeground(new Color(255, 9, 0));
		errorFirstName.setBounds(27, 84, 111, 16);
		contactUsPanel.add(errorFirstName);

		JLabel errorLastName = new JLabel("");
		errorLastName.setForeground(new Color(255, 9, 0));
		errorLastName.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		errorLastName.setBounds(183, 83, 111, 16);
		contactUsPanel.add(errorLastName);

		JLabel errorEmail = new JLabel("");
		errorEmail.setForeground(new Color(255, 9, 0));
		errorEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		errorEmail.setBounds(27, 151, 111, 16);
		contactUsPanel.add(errorEmail);

		JLabel errorQuery = new JLabel("");
		errorQuery.setForeground(new Color(255, 9, 0));
		errorQuery.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		errorQuery.setBounds(183, 150, 111, 16);
		contactUsPanel.add(errorQuery);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Boolean> validSubmissions = new ArrayList<Boolean>();
				validSubmissions.add(validate(firstNameTxt, errorFirstName, "First Name"));
				validSubmissions.add(validate(lastNameTxt, errorLastName, "Last Name"));
				validSubmissions.add(validate(emailTxt, errorEmail, "Email"));
				validSubmissions.add(validate(queriesTxt, errorQuery, "Query"));
				if (!validSubmissions.contains(false)) {
					JOptionPane.showMessageDialog(null, "Query submitted successfully!");
					firstNameTxt.setText("");
					lastNameTxt.setText("");
					emailTxt.setText("");
					queriesTxt.setText("");
				}

			}
		});
		btnSubmit.setBounds(106, 175, 117, 29);
		contactUsPanel.add(btnSubmit);

		JPanel alumniPanel = new JPanel();
		contentPanel.add(alumniPanel, "name_149711003039500");
		alumniPanel.setLayout(null);

		JLabel alumniTitle = new JLabel("Notable Alumni:");
		alumniTitle.setBounds(17, 17, 109, 16);
		alumniPanel.add(alumniTitle);

		JTextPane alumniSubtitle = new JTextPane();
		alumniSubtitle.setText(
				"1) Sir Isaac Newton\n2) Steve Jobs\n3) Albert Einstein\n4) Bill Gates\n5) Walt Disney\n6) Abraham Lincoln \n7) Larry Page");
		alumniSubtitle.setEditable(false);
		alumniSubtitle.setBackground(SystemColor.window);
		alumniSubtitle.setBounds(17, 46, 301, 143);
		alumniPanel.add(alumniSubtitle);

		JPanel scholarPanel = new JPanel();
		contentPanel.add(scholarPanel, "name_149714554813458");

		JButton coursesBtn = new JButton("Courses");
		coursesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPanel.removeAll();
				contentPanel.add(coursesPanel);
				contentPanel.repaint();
				contentPanel.revalidate();
			}
		});
		coursesBtn.setBounds(5, 8, 104, 29);
		sidebar.add(coursesBtn);

		JButton aboutUsBtn = new JButton("About Us");
		aboutUsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPanel.removeAll();
				contentPanel.add(aboutUsPanel);
				contentPanel.repaint();
				contentPanel.revalidate();
			}
		});
		aboutUsBtn.setBounds(5, 43, 104, 29);
		sidebar.add(aboutUsBtn);

		JButton contactUsBtn = new JButton("Contact Us");
		contactUsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPanel.removeAll();
				contentPanel.add(contactUsPanel);
				contentPanel.repaint();
				contentPanel.revalidate();
			}
		});
		contactUsBtn.setBounds(5, 78, 104, 29);
		sidebar.add(contactUsBtn);

		JButton alumniBtn = new JButton("Alumni");
		alumniBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPanel.removeAll();
				contentPanel.add(alumniPanel);
				contentPanel.repaint();
				contentPanel.revalidate();
			}
		});
		alumniBtn.setBounds(5, 113, 104, 29);
		sidebar.add(alumniBtn);

		JButton scholarBtn = new JButton("Scholar");
		scholarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPanel.removeAll();
				contentPanel.add(scholarPanel);
				contentPanel.repaint();
				contentPanel.revalidate();
			}
		});
		scholarBtn.setBounds(5, 148, 104, 29);
		sidebar.add(scholarBtn);
	}
}
