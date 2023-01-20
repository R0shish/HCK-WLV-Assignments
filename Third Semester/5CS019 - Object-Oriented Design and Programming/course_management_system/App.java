package course_management_system;

import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;

import course_management_system.auth.Auth;
import course_management_system.pages.SplashScreen;
import course_management_system.util.CustomImage;
import course_management_system.util.DatabaseManager;

public class App {

	private JFrame frmHeraldCourseManagement;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frmHeraldCourseManagement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public App() {
		initialize();
	}

	private void initialize() {
		frmHeraldCourseManagement = new JFrame();
		frmHeraldCourseManagement.setTitle("Herald Course Management System");
		frmHeraldCourseManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHeraldCourseManagement.getContentPane().setLayout(null);
		frmHeraldCourseManagement.setSize(1480, 720);

		try {
			DatabaseManager db = new DatabaseManager("jdbc:mysql://localhost:3306", "root", "");
			new Auth(db);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		CustomImage logo = new CustomImage("../assets/logo.png");

		new SplashScreen(frmHeraldCourseManagement, logo);
	}
}
