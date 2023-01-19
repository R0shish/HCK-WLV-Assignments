package course_management_system.util;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Logo extends JPanel {

	private static final long serialVersionUID = 4985367388576734702L;
	private ImageIcon logo;
	
	public Logo(){
		ImageIcon logo = new ImageIcon(getClass().getResource("../assets/logo.png"));
		this.logo = logo;
	}

	public ImageIcon getLogo(int width, int height) {
		return new ImageIcon(logo.getImage().getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH));
	}
}