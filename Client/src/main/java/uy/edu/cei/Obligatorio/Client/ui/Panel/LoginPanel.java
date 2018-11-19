package uy.edu.cei.Obligatorio.Client.ui.Panel;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import uy.edu.cei.Obligatorio.Client.EventQueueClient;
import uy.edu.cei.Obligatorio.Client.ui.MainWindow;
import uy.edu.cei.Obligatorio.Common.Controller.UsuarioController;
import uy.edu.cei.Obligatorio.Domain.UsuarioModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import javax.swing.JPasswordField;
import java.awt.Font;

public class LoginPanel extends GeneralaPanel{

	private static final long serialVersionUID = 1L;
	private JTextField txtUsuario;
	private JPasswordField pwdContra;
	private JTextField txtRespuesta;

	public LoginPanel() {
		setBackground(Color.GRAY);
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblLogin = new JLabel("Login");
		springLayout.putConstraint(SpringLayout.NORTH, lblLogin, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblLogin, 41, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, lblLogin, 88, SpringLayout.WEST, this);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		springLayout.putConstraint(SpringLayout.WEST, lblLogin, 10, SpringLayout.WEST, this);
		add(lblLogin);
		
		JLabel lblUsuario = new JLabel("Usuario");
		springLayout.putConstraint(SpringLayout.SOUTH, lblUsuario, 82, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.NORTH, lblUsuario, 51, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblUsuario, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblUsuario, 88, SpringLayout.WEST, this);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		springLayout.putConstraint(SpringLayout.NORTH, lblContrasea, 14, SpringLayout.SOUTH, lblUsuario);
		springLayout.putConstraint(SpringLayout.WEST, lblContrasea, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblContrasea, 43, SpringLayout.SOUTH, lblUsuario);
		springLayout.putConstraint(SpringLayout.EAST, lblContrasea, 88, SpringLayout.WEST, this);
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblContrasea);
		
		txtUsuario = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtUsuario, 51, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, txtUsuario, 152, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, txtUsuario, 82, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, txtUsuario, 440, SpringLayout.WEST, this);
		add(txtUsuario);
		txtUsuario.setColumns(10);
		
		pwdContra = new JPasswordField();
		springLayout.putConstraint(SpringLayout.EAST, pwdContra, 440, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, pwdContra, 125, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.NORTH, pwdContra, 94, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, pwdContra, 152, SpringLayout.WEST, this);
		add(pwdContra);	
		
		JButton btnLogear = new JButton("Logear");
		springLayout.putConstraint(SpringLayout.NORTH, btnLogear, 249, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, btnLogear, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnLogear, 290, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, btnLogear, 101, SpringLayout.WEST, this);
		btnLogear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btnLogear);
		btnLogear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nombre = txtUsuario.getText();
					String contra= new String(pwdContra.getPassword());
					EventQueueClient css = EventQueueClient.Instancia();
					UsuarioController uci = css.GetServer().getUsuarioControllerImpl();
					uci.VerificarUsuario(nombre, contra,css.getId());
				} catch (Throwable e1) {
					e1.printStackTrace();
				}			
			}
		});
		
		JButton btnSalir = new JButton("Salir");
		springLayout.putConstraint(SpringLayout.WEST, btnSalir, -101, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.EAST, btnSalir, -10, SpringLayout.EAST, this);
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btnSalir);
		
		txtRespuesta = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, btnSalir, 128, SpringLayout.SOUTH, txtRespuesta);
		springLayout.putConstraint(SpringLayout.NORTH, btnSalir, 87, SpringLayout.SOUTH, txtRespuesta);
		txtRespuesta.setEditable(false);
		springLayout.putConstraint(SpringLayout.NORTH, txtRespuesta, 6, SpringLayout.SOUTH, pwdContra);
		springLayout.putConstraint(SpringLayout.WEST, txtRespuesta, 0, SpringLayout.WEST, txtUsuario);
		springLayout.putConstraint(SpringLayout.SOUTH, txtRespuesta, 37, SpringLayout.SOUTH, pwdContra);
		springLayout.putConstraint(SpringLayout.EAST, txtRespuesta, 0, SpringLayout.EAST, txtUsuario);
		txtRespuesta.setColumns(10);
		add(txtRespuesta);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					EventQueueClient css = EventQueueClient.Instancia();
					css.getMainWindow().getFrame().dispose();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		});
		
	}
	public void loginError() {
		txtRespuesta.setText("Error en los datos del usuario");
	}
}
