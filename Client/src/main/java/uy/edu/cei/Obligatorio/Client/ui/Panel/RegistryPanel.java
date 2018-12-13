package uy.edu.cei.Obligatorio.Client.ui.Panel;

import java.awt.Color;
import javax.swing.SpringLayout;

import uy.edu.cei.Obligatorio.Client.App.EventQueueClient;
import uy.edu.cei.Obligatorio.Client.ui.MainWindow;
import uy.edu.cei.Obligatorio.Domain.UsuarioModel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import javax.swing.JRadioButton;

public class RegistryPanel extends GeneralaPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtUsuario;
	private JTextField txtContra;
	private JLabel lblRespuesta;
	private JRadioButton rb1;
	private JRadioButton rb2;
	private JRadioButton rb3;
	private JRadioButton rb4;
	private JRadioButton rb5;
	
	public RegistryPanel() {
		setBackground(Color.PINK);
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblRegistro = new JLabel("Registro");
		springLayout.putConstraint(SpringLayout.NORTH, lblRegistro, 28, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblRegistro, 173, SpringLayout.WEST, this);
		add(lblRegistro);
		
		JLabel lblUsuario = new JLabel("Usuario");
		add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		springLayout.putConstraint(SpringLayout.NORTH, lblContrasea, 35, SpringLayout.SOUTH, lblUsuario);
		springLayout.putConstraint(SpringLayout.WEST, lblContrasea, 48, SpringLayout.WEST, this);
		add(lblContrasea);
		
		txtUsuario = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtUsuario, 55, SpringLayout.SOUTH, lblRegistro);
		springLayout.putConstraint(SpringLayout.WEST, txtUsuario, 168, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, lblUsuario, 3, SpringLayout.NORTH, txtUsuario);
		springLayout.putConstraint(SpringLayout.EAST, lblUsuario, -65, SpringLayout.WEST, txtUsuario);
		add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContra = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtContra, -3, SpringLayout.NORTH, lblContrasea);
		springLayout.putConstraint(SpringLayout.WEST, txtContra, 0, SpringLayout.WEST, txtUsuario);
		add(txtContra);
		txtContra.setColumns(10);
		
		JButton btnSalir = new JButton("Salir");
		springLayout.putConstraint(SpringLayout.SOUTH, btnSalir, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, btnSalir, -10, SpringLayout.EAST, this);
		btnSalir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				MainWindow mainWindow = MainWindow.getInstancia();
				mainWindow.cambiarVentana("main");
			}
		});
		add(btnSalir);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				try {
					
					EventQueueClient css = EventQueueClient.Instancia();
					/*
					UsuarioModel usu = css.getServer().getUsuarioControllerImpl().agregarUsuario(txtUsuario.getText(), txtContra.getText(),2);
					if(usu == null)
						textRespuesta.setText("Error al agregar usuario");
					else
						textRespuesta.setText("Usuario agregado");
					*/
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnAgregar, 0, SpringLayout.NORTH, btnSalir);
		springLayout.putConstraint(SpringLayout.WEST, btnAgregar, 10, SpringLayout.WEST, this);
		add(btnAgregar);
		
		lblRespuesta = new JLabel("Respuesta");
		springLayout.putConstraint(SpringLayout.NORTH, lblRespuesta, 41, SpringLayout.SOUTH, lblContrasea);
		springLayout.putConstraint(SpringLayout.WEST, lblRespuesta, 109, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblRespuesta, -82, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, lblRespuesta, 62, SpringLayout.EAST, lblUsuario);
		add(lblRespuesta);
		
		rb1 = new JRadioButton("1");
		springLayout.putConstraint(SpringLayout.SOUTH, rb1, -57, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, rb1, -119, SpringLayout.EAST, this);
		add(rb1);
		
		rb2 = new JRadioButton("2");
		springLayout.putConstraint(SpringLayout.WEST, rb2, 0, SpringLayout.WEST, rb1);
		springLayout.putConstraint(SpringLayout.SOUTH, rb2, -18, SpringLayout.NORTH, rb1);
		add(rb2);
		
		rb5 = new JRadioButton("5");
		springLayout.putConstraint(SpringLayout.WEST, rb5, 0, SpringLayout.WEST, rb1);
		rb5.setToolTipText("");
		add(rb5);
		
		rb4 = new JRadioButton("4");
		springLayout.putConstraint(SpringLayout.SOUTH, rb5, -20, SpringLayout.NORTH, rb4);
		springLayout.putConstraint(SpringLayout.SOUTH, rb4, 0, SpringLayout.SOUTH, lblUsuario);
		springLayout.putConstraint(SpringLayout.EAST, rb4, 0, SpringLayout.EAST, rb1);
		add(rb4);
		
		rb3 = new JRadioButton("3");
		springLayout.putConstraint(SpringLayout.SOUTH, rb3, 0, SpringLayout.SOUTH, lblContrasea);
		springLayout.putConstraint(SpringLayout.EAST, rb3, 0, SpringLayout.EAST, rb1);
		add(rb3);
	}
}
