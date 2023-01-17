package Week9_Tutorial;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Welcome {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome window = new Welcome("User");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Welcome(String username) {
		initialize(username);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String username) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome " + username);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(86, 22, 253, 16);
		panel.add(lblNewLabel);
		
		JTextPane txtpnHelloHowAre = new JTextPane();
		txtpnHelloHowAre.setBackground(new Color(255, 255, 255));
		txtpnHelloHowAre.setEditable(false);
		txtpnHelloHowAre.setFont(new Font("Helvetica", Font.PLAIN, 27));
		txtpnHelloHowAre.setText("Hello " + username + "!\nHow are you?\nI am fine. \nThank you!");
		txtpnHelloHowAre.setBounds(86, 74, 253, 113);
		panel.add(txtpnHelloHowAre);
		frame.setVisible(true);
	}
}
