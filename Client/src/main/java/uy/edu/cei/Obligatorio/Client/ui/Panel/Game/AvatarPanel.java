package uy.edu.cei.Obligatorio.Client.ui.Panel.Game;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AvatarPanel extends JPanel {

	private JLabel img;
	
	public AvatarPanel(int num) {
		setLayout(null);
		this.setSize(150,150);
		img = new JLabel();
		img.setLocation(0, 0);
		img.setSize(150,150);
		add(img);
		URL url = this.getClass().getClassLoader().getResource("avatar"+num+".png");
		ImageIcon image = new ImageIcon(url);
		img.setIcon(image);
		img.setVisible(true);
	}
	public void cambiar(int num) {
		URL url = this.getClass().getClassLoader().getResource("avatar"+num+".png");
		ImageIcon image = new ImageIcon(url);
		img.setIcon(image);
		img.repaint();
	}
}
