package Week9_Assignment;

import java.awt.EventQueue;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Activity2 {

	private JFrame frame;
	private JTextField firstNameTxtField_create;
	private JTextField firstNameTxtField_deposit;
	private JTextField firstNameTxtField_withdraw;
	private JTextField firstNameTxtField_check;
	private JTextField lastNameTxtField_create;
	private JTextField lastNameTxtField_deposit;
	private JTextField lastNameTxtField_withdraw;
	private JTextField lastNameTxtField_check;
	private JTextField amountTxtField_create;
	private JTextField amountTxtField_deposit;
	private JTextField amountTxtField_withdraw;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Activity2 window = new Activity2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Activity2() {
		initialize();
	}

	public class Banking {
		String name;
		int amount;
		private Hashtable<String, Float> accounts = new Hashtable<String, Float>();

		public Banking() {
			System.out.println("Welcome to Roshish ko Bank!");
		}

		private boolean checkAccount(String name) {
			return accounts.containsKey(name);
		}

		public String createAccount(String name, float amount) {
			if (checkAccount(name)) {
				return "Account already exists!";
			}
			if (amount < 0) {
				return "Amount must not be negative!";
			}
			accounts.put(name, amount);
			return "Account created successfully!";
		}

		public String depositAmount(String name, float amount) {
			if (!checkAccount(name)) {
				return "User does not exist!";
			}
			float currentAmount = accounts.get(name);
			if (amount < 0) {
				return "Amount must not be negative!";
			}
			accounts.replace(name, currentAmount + amount);
			return "Amount deposited successfully!";
		}

		public String withdrawAmount(String name, float amount) {
			if (!checkAccount(name)) {
				return "User does not exist!";
			}
			float currentAmount = accounts.get(name);
			if (amount < 0) {
				return "Amount must not be negative!";
			}
			if (amount > currentAmount) {
				return "Amount exceeds the current amount!";
			}
			accounts.replace(name, currentAmount - amount);
			return "Amount withdrawn successfully!";
		}

		public String checkBalance(String name) {
			if (!checkAccount(name)) {
				return "User does not exist!";
			}
			return "Rs " + accounts.get(name).toString();
		}
	}

	private void initialize() {

		Banking banking = new Banking();

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(238, 238, 238));
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		// Create Account Panel

		JPanel createPanel = new JPanel();
		tabbedPane.addTab("Create Account", null, createPanel, null);
		createPanel.setLayout(null);
		tabbedPane.setEnabledAt(0, true);

		JLabel firstNameTxt_create = new JLabel("First Name");
		firstNameTxt_create.setBounds(61, 28, 73, 16);
		createPanel.add(firstNameTxt_create);

		firstNameTxtField_create = new JTextField();
		firstNameTxtField_create.setBounds(148, 23, 130, 26);
		createPanel.add(firstNameTxtField_create);
		firstNameTxtField_create.setColumns(10);

		JLabel lastNameTxt_create = new JLabel("Last Name");
		lastNameTxt_create.setBounds(61, 72, 73, 16);
		createPanel.add(lastNameTxt_create);

		lastNameTxtField_create = new JTextField();
		lastNameTxtField_create.setColumns(10);
		lastNameTxtField_create.setBounds(148, 67, 130, 26);
		createPanel.add(lastNameTxtField_create);

		JLabel amountTxt_create = new JLabel("Amount");
		amountTxt_create.setBounds(61, 116, 73, 16);
		createPanel.add(amountTxt_create);

		amountTxtField_create = new JTextField();
		amountTxtField_create.setColumns(10);
		amountTxtField_create.setBounds(148, 111, 130, 26);
		createPanel.add(amountTxtField_create);

		JButton createBtn = new JButton("Create");
		createBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = firstNameTxtField_create.getText() + "_" + lastNameTxtField_create.getText();
				String message = banking.createAccount(name, Float.parseFloat(amountTxtField_create.getText()));
				JOptionPane.showMessageDialog(null, message);
			}
		});
		createBtn.setBounds(148, 157, 130, 29);
		createPanel.add(createBtn);

		// Deposit Amount Panel

		JPanel depositPanel = new JPanel();
		tabbedPane.addTab("Deposit", null, depositPanel, null);
		depositPanel.setLayout(null);
		tabbedPane.setEnabledAt(1, true);

		JLabel firstNameTxt_deposit = new JLabel("First Name");
		firstNameTxt_deposit.setBounds(61, 28, 73, 16);
		depositPanel.add(firstNameTxt_deposit);

		firstNameTxtField_deposit = new JTextField();
		firstNameTxtField_deposit.setBounds(148, 23, 130, 26);
		depositPanel.add(firstNameTxtField_deposit);
		firstNameTxtField_deposit.setColumns(10);

		JLabel lastNameTxt_deposit = new JLabel("Last Name");
		lastNameTxt_deposit.setBounds(61, 72, 73, 16);
		depositPanel.add(lastNameTxt_deposit);

		lastNameTxtField_deposit = new JTextField();
		lastNameTxtField_deposit.setColumns(10);
		lastNameTxtField_deposit.setBounds(148, 67, 130, 26);
		depositPanel.add(lastNameTxtField_deposit);

		JLabel amountTxt_deposit = new JLabel("Amount");
		amountTxt_deposit.setBounds(61, 116, 73, 16);
		depositPanel.add(amountTxt_deposit);

		amountTxtField_deposit = new JTextField();
		amountTxtField_deposit.setColumns(10);
		amountTxtField_deposit.setBounds(148, 111, 130, 26);
		depositPanel.add(amountTxtField_deposit);

		JButton depositBtn = new JButton("Deposit");
		depositBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = firstNameTxtField_deposit.getText() + "_" + lastNameTxtField_deposit.getText();
				String message = banking.depositAmount(name, Float.parseFloat(amountTxtField_deposit.getText()));
				JOptionPane.showMessageDialog(null, message);
			}
		});
		depositBtn.setBounds(148, 157, 130, 29);
		depositPanel.add(depositBtn);

		// Withdraw Amount Panel

		JPanel withdrawPanel = new JPanel();
		tabbedPane.addTab("Withdraw", null, withdrawPanel, null);
		withdrawPanel.setLayout(null);
		tabbedPane.setEnabledAt(2, true);

		JLabel firstNameTxt_withdraw = new JLabel("First Name");
		firstNameTxt_withdraw.setBounds(61, 28, 73, 16);
		withdrawPanel.add(firstNameTxt_withdraw);

		firstNameTxtField_withdraw = new JTextField();
		firstNameTxtField_withdraw.setBounds(148, 23, 130, 26);
		withdrawPanel.add(firstNameTxtField_withdraw);
		firstNameTxtField_withdraw.setColumns(10);

		JLabel lastNameTxt_withdraw = new JLabel("Last Name");
		lastNameTxt_withdraw.setBounds(61, 72, 73, 16);
		withdrawPanel.add(lastNameTxt_withdraw);

		lastNameTxtField_withdraw = new JTextField();
		lastNameTxtField_withdraw.setColumns(10);
		lastNameTxtField_withdraw.setBounds(148, 67, 130, 26);
		withdrawPanel.add(lastNameTxtField_withdraw);

		JLabel amountTxt_withdraw = new JLabel("Amount");
		amountTxt_withdraw.setBounds(61, 116, 73, 16);
		withdrawPanel.add(amountTxt_withdraw);

		amountTxtField_withdraw = new JTextField();
		amountTxtField_withdraw.setColumns(10);
		amountTxtField_withdraw.setBounds(148, 111, 130, 26);
		withdrawPanel.add(amountTxtField_withdraw);

		JButton withdrawBtn = new JButton("Withdraw");
		withdrawBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = firstNameTxtField_withdraw.getText() + "_" + lastNameTxtField_withdraw.getText();
				String message = banking.withdrawAmount(name, Float.parseFloat(amountTxtField_withdraw.getText()));
				JOptionPane.showMessageDialog(null, message);
			}
		});
		withdrawBtn.setBounds(148, 157, 130, 29);
		withdrawPanel.add(withdrawBtn);

		// Check Balance Panel

		JPanel checkPanel = new JPanel();
		tabbedPane.addTab("Check Balance", null, checkPanel, null);
		checkPanel.setLayout(null);
		tabbedPane.setEnabledAt(3, true);

		JLabel firstNameTxt_check = new JLabel("First Name");
		firstNameTxt_check.setBounds(61, 28, 73, 16);
		checkPanel.add(firstNameTxt_check);

		firstNameTxtField_check = new JTextField();
		firstNameTxtField_check.setBounds(148, 23, 130, 26);
		checkPanel.add(firstNameTxtField_check);
		firstNameTxtField_check.setColumns(10);

		JLabel lastNameTxt_check = new JLabel("Last Name");
		lastNameTxt_check.setBounds(61, 72, 73, 16);
		checkPanel.add(lastNameTxt_check);

		lastNameTxtField_check = new JTextField();
		lastNameTxtField_check.setColumns(10);
		lastNameTxtField_check.setBounds(148, 67, 130, 26);
		checkPanel.add(lastNameTxtField_check);

		JLabel amountTxt_check = new JLabel("Amount");
		amountTxt_check.setBounds(61, 116, 73, 16);
		checkPanel.add(amountTxt_check);

		JLabel amountLabel = new JLabel("Press Check to View");
		amountLabel.setBounds(148, 116, 130, 16);
		checkPanel.add(amountLabel);

		JButton checkBtn = new JButton("Check");
		checkBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = firstNameTxtField_check.getText() + "_" + lastNameTxtField_check.getText();
				String message = banking.checkBalance(name);
				amountLabel.setText(message);
			}
		});
		checkBtn.setBounds(148, 157, 130, 29);
		checkPanel.add(checkBtn);

	}
}
