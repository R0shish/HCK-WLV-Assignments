package course_management_system.pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import course_management_system.util.CustomImage;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dashboard extends JPanel {

	private static final long serialVersionUID = -3421670490444154816L;

	public Dashboard(JFrame frame, String name, JPanel login) {
		JPanel dashboardFrame = new JPanel();

		dashboardFrame.setBackground(new Color(238, 238, 238));
		dashboardFrame.setBounds(0, -7, 1480, 701);
		frame.getContentPane().add(dashboardFrame);
		dashboardFrame.setVisible(true);
		dashboardFrame.setLayout(null);
		CustomImage roundLogo = new CustomImage("../assets/logo_round.png");

		JLabel title = new JLabel("Welcome back, " + name + " ! 👋");
		title.setFont(new Font("Futura", Font.PLAIN, 20));
		title.setBounds(188, 33, 449, 37);
		dashboardFrame.add(title);

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMM dd");
		JLabel subtitle = new JLabel(sdf.format(cal.getTime()));
		subtitle.setEnabled(false);
		subtitle.setFont(new Font("Futura", Font.PLAIN, 15));
		subtitle.setBounds(188, 65, 449, 21);
		dashboardFrame.add(subtitle);

		JPanel searchBar = new JPanel();
		searchBar.setBackground(Color.WHITE);
		searchBar.setBounds(936, 33, 418, 45);
		dashboardFrame.add(searchBar);
		searchBar.setLayout(null);
		JLabel searchIcon = new JLabel(new ImageIcon(getClass().getResource("../assets/search_icon.png")));
		searchIcon.setBounds(382, 0, 30, 45);
		searchBar.add(searchIcon);

		JTextField searchField = new JTextField(30);
		searchField.setFont(new Font("Futura", Font.PLAIN, 15));
		searchField.setBorder(null);
		searchField.setBackground(Color.WHITE);
		searchField.setBounds(21, 0, 360, 45);
		searchBar.add(searchField);
		searchField.setLayout(new BorderLayout());

		JLabel title2 = new JLabel("Available Courses");
		title2.setFont(new Font("Futura", Font.PLAIN, 20));
		title2.setBounds(188, 212, 280, 37);
		dashboardFrame.add(title2);

		JPanel coursesPanel = new JPanel();
		coursesPanel.setBackground(new Color(252, 255, 255));
		coursesPanel.setBounds(188, 261, 676, 370);
		dashboardFrame.add(coursesPanel);

		JLabel lblTeachers = new JLabel("Teachers");
		lblTeachers.setFont(new Font("Futura", Font.PLAIN, 20));
		lblTeachers.setBounds(936, 212, 280, 37);
		dashboardFrame.add(lblTeachers);

		JPanel teachersPanel = new JPanel();
		teachersPanel.setBackground(Color.WHITE);
		teachersPanel.setBounds(936, 262, 418, 369);
		dashboardFrame.add(teachersPanel);

		JPanel sidebar = new JPanel();
		sidebar.setBackground(new Color(255, 255, 255));
		sidebar.setBounds(0, 0, 134, 701);
		dashboardFrame.add(sidebar);
		sidebar.setLayout(null);
		JLabel logoImg = new JLabel(roundLogo.getImage(50, 50));
		logoImg.setBounds(38, 41, 50, 50);
		sidebar.add(logoImg);

		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.setVisible(true);
				dashboardFrame.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Futura", Font.PLAIN, 15));
		btnNewButton.setBounds(6, 634, 122, 37);
		sidebar.add(btnNewButton);
		searchIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				searchField.setText("");
			}
		});

	}
}
