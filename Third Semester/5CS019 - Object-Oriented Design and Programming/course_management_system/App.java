package course_management_system;

import java.awt.EventQueue;

import javax.swing.JFrame;

import course_management_system.util.Logo;

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
		frmHeraldCourseManagement.setSize(1480,720);
		
		Logo logo = new Logo();
		
		new SplashScreen(frmHeraldCourseManagement, logo);
		
	}
}
