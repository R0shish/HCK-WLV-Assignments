package course_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import course_management_system.auth.Auth;
import course_management_system.exceptions.InvalidEmailException;
import course_management_system.util.Logo;
import course_management_system.util.Validator;

public class SignUp extends JPanel {

	private static final long serialVersionUID = 8409831875589206498L;
	private JTextField nameTxt;
	private JTextField emailTxt;
	private JPasswordField passwordTxt;

	public SignUp(JFrame frame, Logo logo) {
		
		ImageIcon signupImg = new ImageIcon(getClass().getResource("assets/signup_image.png"));
		Image signupImage = signupImg.getImage().getScaledInstance(1100, 708,  java.awt.Image.SCALE_SMOOTH);
		signupImg = new ImageIcon(signupImage);
	
		JPanel signup = new JPanel();
		signup.setBackground(new Color(255, 255, 255));
		signup.setBounds(0, -7, 1533, 701);
		frame.getContentPane().add(signup);
		signup.setVisible(true);
		signup.setLayout(null);
		
		JLabel logoImg = new JLabel(logo.getLogo(100,100));
		logoImg.setBounds(52, 43, 100, 100);
		signup.add(logoImg);
		
		JLabel signupImgLabel = new JLabel(signupImg);
		signupImgLabel.setBounds(380, 0, 1094, 708);
		signup.add(signupImgLabel);
		
		
		JLabel title = new JLabel("Create an account");
		title.setFont(new Font("Futura", Font.PLAIN, 40));
		title.setBounds(52, 155, 352, 54);
		signup.add(title);
		
		JLabel subtitle = new JLabel("Let's get started");
		subtitle.setFont(new Font("Futura", Font.PLAIN, 20));
		subtitle.setBounds(52, 205, 145, 27);
		signup.add(subtitle);
		
		nameTxt = new JTextField();
		nameTxt.setFont(new Font("Futura", Font.PLAIN, 15));
		nameTxt.setBounds(52, 306, 332, 43);
		signup.add(nameTxt);
		nameTxt.setColumns(10);
		
		emailTxt = new JTextField();
		emailTxt.setFont(new Font("Futura", Font.PLAIN, 15));
		emailTxt.setColumns(10);
		emailTxt.setBounds(52, 393, 332, 43);
		signup.add(emailTxt);
		
		JLabel nameLbl = new JLabel("Name");
		nameLbl.setFont(new Font("Futura", Font.PLAIN, 15));
		nameLbl.setBounds(55, 290, 42, 16);
		signup.add(nameLbl);
		
		JLabel emailLbl = new JLabel("Email");
		emailLbl.setFont(new Font("Futura", Font.PLAIN, 15));
		emailLbl.setBounds(55, 371, 42, 16);
		signup.add(emailLbl);
		
		JLabel passwordLbl = new JLabel("Password");
		passwordLbl.setFont(new Font("Futura", Font.PLAIN, 15));
		passwordLbl.setBounds(55, 462, 80, 16);
		signup.add(passwordLbl);
		
		passwordTxt = new JPasswordField();
		passwordTxt.setColumns(10);
		passwordTxt.setFont(new Font("Futura", Font.PLAIN, 15));
		passwordTxt.setBounds(52, 479, 332, 43);
		signup.add(passwordTxt);
		
		JLabel bottomLbl = new JLabel("Already have an account ?");
		bottomLbl.setEnabled(false);
		bottomLbl.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 12));
		bottomLbl.setBounds(107, 606, 152, 27);
		signup.add(bottomLbl);
		
		JLabel loginBtn = new JLabel("Login");
		loginBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Login(frame, logo);
				signup.setVisible(false);
			}
		});
		loginBtn.setFont(new Font("Kohinoor Bangla", Font.BOLD, 12));
		loginBtn.setBounds(257, 606, 42, 27);
		signup.add(loginBtn);
		
		JLabel errorNameLbl = new JLabel("");
		errorNameLbl.setForeground(new Color(255, 0, 7));
		errorNameLbl.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 12));
		errorNameLbl.setBounds(55, 343, 322, 27);
		signup.add(errorNameLbl);
		
		JLabel errorEmailLbl = new JLabel("");
		errorEmailLbl.setForeground(new Color(255, 0, 7));
		errorEmailLbl.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 12));
		errorEmailLbl.setBounds(55, 434, 322, 27);
		signup.add(errorEmailLbl);
		
		JLabel errorPasswordLbl = new JLabel("");
		errorPasswordLbl.setForeground(new Color(255, 0, 7));
		errorPasswordLbl.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 12));
		errorPasswordLbl.setBounds(55, 515, 322, 27);
		signup.add(errorPasswordLbl);
		
		JButton createBtn = new JButton("Create Account");
		createBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Boolean> isValidSubmission = new ArrayList<Boolean>();
				String name = nameTxt.getText().strip();
				String email = emailTxt.getText().strip();
				String password = new String(passwordTxt.getPassword()).strip();
				
				isValidSubmission.add(Validator.validate(name, errorNameLbl, "Name"));
				isValidSubmission.add(Validator.validate(email, errorEmailLbl, "Email"));
				isValidSubmission.add(Validator.validate(password, errorPasswordLbl, "Password"));
				
				if (!isValidSubmission.contains(false)) {
					try {
						Auth.addCredential(name, email, password);
						JOptionPane.showMessageDialog(null, "Account created successfully!");
						nameTxt.setText("");
						emailTxt.setText("");
						passwordTxt.setText("");
					} catch (InvalidEmailException err) {
						errorEmailLbl.setText(err.getMessage());
					}
				}
				
			}
		});
		createBtn.setFont(new Font("Futura", Font.PLAIN, 15));
		createBtn.setForeground(new Color(242, 252, 255));
		createBtn.setOpaque(true);
		createBtn.setBorderPainted(false);
		createBtn.setBackground(new Color(0, 0, 0));
		createBtn.setBounds(52, 556, 332, 43);
		signup.add(createBtn);
	}

}
