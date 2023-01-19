package course_management_system.util;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class CustomImage extends JPanel {

	private static final long serialVersionUID = 4985367388576734702L;
	private ImageIcon image;
	
	public CustomImage(String path){
		ImageIcon image = new ImageIcon(getClass().getResource(path));
		this.image = image;
	}

	public ImageIcon getImage(int width, int height) {
		return new ImageIcon(image.getImage().getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH));
	}
}