package uy.edu.cei.Obligatorio.Client.ui.Panel.Game;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AvatarPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public AvatarPanel(int num) {
		setLayout(null);
		this.setSize(340, 340);
		JLabel img = new JLabel();
		img.setLocation(0, 0);
		img.setSize(340,340);
		add(img);
		URL url = null;
		switch(num) {
			case 1:
				url = this.getClass().getClassLoader().getResource("tierra.jpg");
				break;
			case 2:
				url = this.getClass().getClassLoader().getResource("agua.jpg");
				break;
			case 3:
				url = this.getClass().getClassLoader().getResource("fuego.jpg");
				break;
			case 4:
				url = this.getClass().getClassLoader().getResource("aire.jpg");
				break;
		}
		ImageIcon image = new ImageIcon(url);
		img.setIcon(image);
		img.setVisible(true);
	}

}
