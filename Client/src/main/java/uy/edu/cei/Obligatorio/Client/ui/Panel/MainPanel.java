package uy.edu.cei.Obligatorio.Client.ui.Panel;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

import uy.edu.cei.Obligatorio.Client.ui.MainWindow;

public class MainPanel extends GeneralaPanel {
	
	public MainPanel() {
		setBackground(Color.RED);
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblMenuPrincipal = new JLabel("Menu principal");
		springLayout.putConstraint(SpringLayout.NORTH, lblMenuPrincipal, 43, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblMenuPrincipal, 164, SpringLayout.WEST, this);
		add(lblMenuPrincipal);
		
		JPanel respuesta = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, respuesta, 39, SpringLayout.SOUTH, lblMenuPrincipal);
		springLayout.putConstraint(SpringLayout.WEST, respuesta, 58, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, respuesta, 131, SpringLayout.SOUTH, lblMenuPrincipal);
		springLayout.putConstraint(SpringLayout.EAST, respuesta, 290, SpringLayout.WEST, this);
		add(respuesta);
	}
}
