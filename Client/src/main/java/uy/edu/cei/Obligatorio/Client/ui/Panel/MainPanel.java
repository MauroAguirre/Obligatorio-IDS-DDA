package uy.edu.cei.Obligatorio.Client.ui.Panel;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

import uy.edu.cei.Obligatorio.Client.EventQueueClient;
import uy.edu.cei.Obligatorio.Client.ui.MainWindow;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

public class MainPanel extends GeneralaPanel {
	
	public MainPanel() {
		setBackground(Color.RED);
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblMenuPrincipal = new JLabel("Menu principal");
		springLayout.putConstraint(SpringLayout.NORTH, lblMenuPrincipal, 35, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblMenuPrincipal, 164, SpringLayout.WEST, this);
		add(lblMenuPrincipal);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					EventQueueClient css = EventQueueClient.Instancia();
					css.getMainWindow().getFrame().setContentPane(new LoginPanel());
					css.getMainWindow().getFrame().setVisible(true);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		springLayout.putConstraint(SpringLayout.EAST, btnSalir, 0, SpringLayout.EAST, lblMenuPrincipal);
		add(btnSalir);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					EventQueueClient css = EventQueueClient.Instancia();
					css.getMainWindow().getFrame().setContentPane(new RegistryPanel());
					css.getMainWindow().getFrame().setVisible(true);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnRegistrar, 25, SpringLayout.SOUTH, lblMenuPrincipal);
		springLayout.putConstraint(SpringLayout.EAST, btnRegistrar, 0, SpringLayout.EAST, lblMenuPrincipal);
		add(btnRegistrar);
		
		JButton btnSalasVirtuales = new JButton("Salas virtuales");
		springLayout.putConstraint(SpringLayout.NORTH, btnSalasVirtuales, 17, SpringLayout.SOUTH, btnRegistrar);
		springLayout.putConstraint(SpringLayout.EAST, btnSalasVirtuales, 0, SpringLayout.EAST, lblMenuPrincipal);
		add(btnSalasVirtuales);
		
		JButton btnSalasReales = new JButton("Salas reales");
		springLayout.putConstraint(SpringLayout.NORTH, btnSalasReales, 19, SpringLayout.SOUTH, btnSalasVirtuales);
		springLayout.putConstraint(SpringLayout.WEST, btnSalasReales, 143, SpringLayout.WEST, this);
		add(btnSalasReales);
		
		JButton btnTop = new JButton("Top");
		springLayout.putConstraint(SpringLayout.NORTH, btnSalir, 21, SpringLayout.SOUTH, btnTop);
		springLayout.putConstraint(SpringLayout.NORTH, btnTop, 17, SpringLayout.SOUTH, btnSalasReales);
		springLayout.putConstraint(SpringLayout.EAST, btnTop, 0, SpringLayout.EAST, lblMenuPrincipal);
		add(btnTop);
	}
}
