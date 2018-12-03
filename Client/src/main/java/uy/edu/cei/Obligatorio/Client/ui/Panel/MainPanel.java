package uy.edu.cei.Obligatorio.Client.ui.Panel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

import uy.edu.cei.Obligatorio.Client.ui.MainWindow;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.awt.Font;

public class MainPanel extends GeneralaPanel {
	
	private static final long serialVersionUID = 1L;
	private boolean modificable;
	private JLabel lblMenuPrincipal;
	
	public MainPanel() {
		this.modificable=false;
		setLayout(null);
		this.setSize(640, 480);
		URL url = this.getClass().getClassLoader().getResource("fondo2.jpg");
		ImageIcon image = new ImageIcon(url);
		
		lblMenuPrincipal = new JLabel("Menu Principal");
		lblMenuPrincipal.setFont(new Font("Forte", Font.PLAIN, 20));
		lblMenuPrincipal.setBounds(231, 63, 146, 20);
		add(lblMenuPrincipal);
		JLabel img = new JLabel();
		img.setLocation(0, 0);
		img.setSize(640,480);
		add(img);
		img.setIcon(image);
		img.setVisible(true);
		
	}
}
