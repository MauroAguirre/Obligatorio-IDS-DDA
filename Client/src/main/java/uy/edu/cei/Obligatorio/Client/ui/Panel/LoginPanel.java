package uy.edu.cei.Obligatorio.Client.ui.Panel;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import uy.edu.cei.Obligatorio.Client.CommClientServer;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import javax.swing.JPasswordField;
import java.awt.Font;

public class LoginPanel extends JPanel {
	private JTextField txtUsuario;
	private JPasswordField pwdContra;
	/**
	 * Create the panel.
	 */
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
		springLayout.putConstraint(SpringLayout.EAST, lblUsuario, 88, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, lblUsuario, 51, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblUsuario, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblUsuario, 82, SpringLayout.NORTH, this);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		springLayout.putConstraint(SpringLayout.NORTH, lblContrasea, 14, SpringLayout.SOUTH, lblUsuario);
		springLayout.putConstraint(SpringLayout.WEST, lblContrasea, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblContrasea, -175, SpringLayout.SOUTH, this);
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
		springLayout.putConstraint(SpringLayout.EAST, lblContrasea, -64, SpringLayout.WEST, pwdContra);
		springLayout.putConstraint(SpringLayout.EAST, pwdContra, 440, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, pwdContra, 125, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.NORTH, pwdContra, 94, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, pwdContra, 152, SpringLayout.WEST, this);
		add(pwdContra);
		
		JButton btnLogear = new JButton("Logear");
		springLayout.putConstraint(SpringLayout.NORTH, btnLogear, 124, SpringLayout.SOUTH, lblContrasea);
		springLayout.putConstraint(SpringLayout.WEST, btnLogear, 0, SpringLayout.WEST, lblLogin);
		springLayout.putConstraint(SpringLayout.SOUTH, btnLogear, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, btnLogear, 101, SpringLayout.WEST, this);
		btnLogear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btnLogear);
		btnLogear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CommClientServer css = CommClientServer.Instancia();
					css.GetServer().getUsuarioControllerImpl().VerificarUsuario(txtUsuario.getText(),new String(pwdContra.getPassword()));
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
			}
		});
		
		JButton btnSalir = new JButton("Salir");
		springLayout.putConstraint(SpringLayout.NORTH, btnSalir, 0, SpringLayout.NORTH, btnLogear);
		springLayout.putConstraint(SpringLayout.WEST, btnSalir, -101, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnSalir, 0, SpringLayout.SOUTH, btnLogear);
		springLayout.putConstraint(SpringLayout.EAST, btnSalir, 0, SpringLayout.EAST, txtUsuario);
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btnSalir);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		springLayout.putConstraint(SpringLayout.NORTH, btnRegistrar, 0, SpringLayout.NORTH, btnLogear);
		springLayout.putConstraint(SpringLayout.WEST, btnRegistrar, 72, SpringLayout.EAST, btnLogear);
		springLayout.putConstraint(SpringLayout.SOUTH, btnRegistrar, 0, SpringLayout.SOUTH, btnLogear);
		springLayout.putConstraint(SpringLayout.EAST, btnRegistrar, 264, SpringLayout.WEST, this);
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btnRegistrar);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		});
	}
}
