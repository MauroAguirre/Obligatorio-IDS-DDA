package uy.edu.cei.Obligatorio.Client.ui.Panel;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class WaitingPanel extends GeneralaPanel {

	private static final long serialVersionUID = 1L;

	public WaitingPanel() {
		setLayout(null);
		this.setSize(640, 480);
		JLabel img = new JLabel();
		img.setLocation(0, 0);
		img.setSize(640,480);
		add(img);
		URL url = this.getClass().getClassLoader().getResource("waiting.jpg");
		ImageIcon image = new ImageIcon(url);
		img.setIcon(image);
		img.setVisible(true);
	}

}
