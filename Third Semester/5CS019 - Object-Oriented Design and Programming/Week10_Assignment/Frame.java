package Week10_Assignment;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Frame {

	private JFrame frame;

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

	public Frame() {
		initialize();
	}

	private void initialize() {

		try {
			DatabaseManager db = new DatabaseManager("jdbc:mysql://localhost:3306", "root", "");

			frame = new JFrame();
			frame.setBounds(100, 100, 506, 333);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);

			JLabel lblNewLabel = new JLabel("Herald App");
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
			lblNewLabel.setBounds(20, 10, 169, 35);
			frame.getContentPane().add(lblNewLabel);

			String data[][] = db.getAllUsers();
			String column[] = { "ID", "First Name", "Last Name" };

			JTable table = new JTable(data, column);
			table.setEnabled(false);
			table.setFont(new Font("Futura", Font.PLAIN, 12));
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(20, 70, 450, 200);
			frame.getContentPane().add(scrollPane);

			JButton btnNewButton = new JButton("Sign up");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JTextField firstNameField = new JTextField();
					JTextField lastNameField = new JTextField();

					Object[] message = {
							"First Name:", firstNameField,
							"Last Name:", lastNameField
					};

					int option = JOptionPane.showConfirmDialog(null, message, "Enter Your Name",
							JOptionPane.OK_CANCEL_OPTION);

					if (option == JOptionPane.OK_OPTION) {
						String firstName = firstNameField.getText();
						String lastName = lastNameField.getText();
						db.insertUser(firstName, lastName);

						String data[][] = db.getAllUsers();
						String column[] = { "ID", "First Name", "Last Name" };
						table.setModel(new javax.swing.table.DefaultTableModel(data, column));
					}

				}
			});
			btnNewButton.setBackground(new Color(244, 244, 244));
			btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
			btnNewButton.setBounds(299, 23, 85, 21);
			frame.getContentPane().add(btnNewButton);

			JButton btnNewButton_1 = new JButton("Sign in");
			btnNewButton_1.setBackground(new Color(244, 244, 244));
			btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 12));
			btnNewButton_1.setBounds(394, 23, 85, 21);
			frame.getContentPane().add(btnNewButton_1);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Can not connect to database!\nPlease make sure mySQL is correctly setup and running!",
					"Error 500: Server Communication Failed",
					JOptionPane.ERROR_MESSAGE);
			System.exit(500);
		}

	}
}
