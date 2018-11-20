package uy.edu.cei.Obligatorio.Client.ui.Panel;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SpringLayout;

import uy.edu.cei.Obligatorio.Client.App.EventQueueClient;
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
		add(btnSalir);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				try {
					EventQueueClient css = EventQueueClient.Instancia();
					UsuarioModel usu = css.GetServer().getUsuarioControllerImpl().agregarUsuario(txtUsuario.getText(), txtContra.getText());
					if(usu == null)
						textRespuesta.setText("Error al agregar usuario");
					else
						textRespuesta.setText("Usuario agregado");
					
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnAgregar, 0, SpringLayout.NORTH, btnSalir);
		springLayout.putConstraint(SpringLayout.WEST, btnAgregar, 10, SpringLayout.WEST, this);
		add(btnAgregar);
		
		JLabel lblRespuesta = new JLabel("Respuesta");
		springLayout.putConstraint(SpringLayout.WEST, lblRespuesta, 47, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblRespuesta, -91, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, lblRespuesta, 0, SpringLayout.EAST, lblUsuario);
		add(lblRespuesta);
		
		textRespuesta = new JTextField();
		textRespuesta.setEditable(false);
		springLayout.putConstraint(SpringLayout.NORTH, textRespuesta, 26, SpringLayout.SOUTH, txtContra);
		springLayout.putConstraint(SpringLayout.NORTH, lblRespuesta, 3, SpringLayout.NORTH, textRespuesta);
		springLayout.putConstraint(SpringLayout.EAST, textRespuesta, 0, SpringLayout.EAST, txtUsuario);
		add(textRespuesta);
		textRespuesta.setColumns(10);
	}
}
