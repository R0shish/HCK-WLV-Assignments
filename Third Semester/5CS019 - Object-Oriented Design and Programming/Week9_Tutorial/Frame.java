package Week9_Tutorial;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Frame {

	private JFrame frame;
	private JTextField txtFieldFirstName;
	private JTextField txtFieldLastName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame window = new Frame();
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
	public Frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(new Color(249, 255, 241));
		lblFirstName.setBounds(59, 24, 78, 16);
		frame.getContentPane().add(lblFirstName);

		JLabel lbl_FN = new JLabel("");
		lbl_FN.setForeground(new Color(248, 254, 242));
		lbl_FN.setBounds(16, 215, 266, 16);
		frame.getContentPane().add(lbl_FN);

		txtFieldFirstName = new JTextField();
		txtFieldFirstName.setBounds(135, 19, 130, 26);
		frame.getContentPane().add(txtFieldFirstName);
		txtFieldFirstName.setColumns(10);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(new Color(249, 255, 241));
		lblLastName.setBounds(59, 57, 78, 16);
		frame.getContentPane().add(lblLastName);

		txtFieldLastName = new JTextField();
		txtFieldLastName.setColumns(10);
		txtFieldLastName.setBounds(135, 52, 130, 26);
		frame.getContentPane().add(txtFieldLastName);

		JLabel lbl_LN = new JLabel("");
		lbl_LN.setForeground(new Color(248, 254, 242));
		lbl_LN.setBounds(16, 243, 249, 16);
		frame.getContentPane().add(lbl_LN);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl_FN.setText("First Name: " + txtFieldFirstName.getText());
				lbl_LN.setText("Last Name: " + txtFieldLastName.getText());
			}
		});
		btnNewButton.setBounds(135, 85, 117, 29);
		frame.getContentPane().add(btnNewButton);
	}
}
