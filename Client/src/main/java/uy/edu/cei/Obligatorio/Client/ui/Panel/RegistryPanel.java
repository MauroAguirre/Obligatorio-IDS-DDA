package uy.edu.cei.Obligatorio.Client.ui.Panel;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SpringLayout;

import uy.edu.cei.Obligatorio.Client.EventQueueClient;
import uy.edu.cei.Obligatorio.Client.ui.MainWindow;
import uy.edu.cei.Obligatorio.Common.Controller.UsuarioController;
import uy.edu.cei.Obligatorio.Domain.UsuarioModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

public class RegistryPanel extends GeneralaPanel {
	private JTextField txtUsuario;
	private JTextField txtContra;
	private JTextField textRespuesta;
	/**
	 * Create the panel.
	 */
	public RegistryPanel() {
		setBackground(Color.GREEN);
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblRegistro = new JLabel("Registro");
		springLayout.putConstraint(SpringLayout.NORTH, lblRegistro, 28, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblRegistro, 173, SpringLayout.WEST, this);
		add(lblRegistro);
		
		JLabel lblUsuario = new JLabel("Usuario");
		springLayout.putConstraint(SpringLayout.NORTH, lblUsuario, 97, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblUsuario, 68, SpringLayout.WEST, this);
		add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		springLayout.putConstraint(SpringLayout.NORTH, lblContrasea, 59, SpringLayout.SOUTH, lblUsuario);
		springLayout.putConstraint(SpringLayout.EAST, lblContrasea, 0, SpringLayout.EAST, lblUsuario);
		add(lblContrasea);
		
		txtUsuario = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtUsuario, 0, SpringLayout.NORTH, lblUsuario);
		springLayout.putConstraint(SpringLayout.WEST, txtUsuario, 64, SpringLayout.EAST, lblUsuario);
		add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContra = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, txtContra, 0, SpringLayout.SOUTH, lblContrasea);
		springLayout.putConstraint(SpringLayout.EAST, txtContra, 0, SpringLayout.EAST, txtUsuario);
		add(txtContra);
		txtContra.setColumns(10);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					EventQueueClient css = EventQueueClient.Instancia();
					css.getMainWindow().getFrame().setContentPane(new MainPanel());
					css.getMainWindow().getFrame().setVisible(true);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnSalir, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnSalir, -10, SpringLayout.SOUTH, this);
		add(btnSalir);
		
		JButton btnAgregar = new JButton("Agregar");
		springLayout.putConstraint(SpringLayout.NORTH, btnAgregar, 0, SpringLayout.NORTH, btnSalir);
		springLayout.putConstraint(SpringLayout.EAST, btnAgregar, -10, SpringLayout.EAST, this);
		add(btnAgregar);
		
		JLabel lblRespuesta = new JLabel("Respuesta");
		springLayout.putConstraint(SpringLayout.NORTH, lblRespuesta, 31, SpringLayout.SOUTH, lblContrasea);
		springLayout.putConstraint(SpringLayout.WEST, lblRespuesta, 0, SpringLayout.WEST, lblContrasea);
		springLayout.putConstraint(SpringLayout.SOUTH, lblRespuesta, 45, SpringLayout.SOUTH, lblContrasea);
		springLayout.putConstraint(SpringLayout.EAST, lblRespuesta, 104, SpringLayout.WEST, this);
		add(lblRespuesta);
		
		textRespuesta = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textRespuesta, 0, SpringLayout.NORTH, lblRespuesta);
		springLayout.putConstraint(SpringLayout.WEST, textRespuesta, 0, SpringLayout.WEST, txtUsuario);
		add(textRespuesta);
		textRespuesta.setColumns(10);
	}
}
