package uy.edu.cei.Obligatorio.Client.ui.Panel.Game;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DicePanel extends JPanel {


	private static final long serialVersionUID = 1L;

	public DicePanel(int num,String color) {
		setLayout(null);
		this.setSize(40, 40);
		JLabel img = new JLabel();
		img.setLocation(0, 0);
		img.setSize(40,40);
		add(img);
		URL url = this.getClass().getClassLoader().getResource(color+"die"+num+".png");
		ImageIcon image = new ImageIcon(url);
		img.setIcon(image);
		img.setVisible(true);
		
	}

}
