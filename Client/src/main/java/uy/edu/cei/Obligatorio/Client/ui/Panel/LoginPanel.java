package uy.edu.cei.Obligatorio.Client.ui.Panel;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import uy.edu.cei.Obligatorio.Client.App.EventQueueClient;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginPanel extends GeneralaPanel{

	private static final long serialVersionUID = 1L;
	private JTextField textUsuario;
	private JPasswordField passwordContra;
	private JLabel lblRespuesta;
	
	public LoginPanel() {
		this.setSize(640, 480);
		setBackground(new Color(0, 191, 255));
		setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Forte", Font.PLAIN, 20));
		lblLogin.setBounds(284, 33, 60, 23);
		add(lblLogin);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Forte", Font.PLAIN, 20));
		lblUsuario.setBounds(62, 139, 83, 23);
		add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setFont(new Font("Forte", Font.PLAIN, 20));
		lblContrasea.setBounds(62, 237, 107, 30);
		add(lblContrasea);
		
		textUsuario = new JTextField();
		textUsuario.setFont(new Font("Forte", Font.PLAIN, 20));
		textUsuario.setBounds(226, 138, 175, 24);
		add(textUsuario);
		textUsuario.setColumns(10);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				try {
					String nombre = textUsuario.getText();
					String contra= new String(passwordContra.getPassword());
					EventQueueClient css = EventQueueClient.Instancia();
					UsuarioController uci = css.GetServer().getUsuarioControllerImpl();
					uci.verificarUsuario(nombre, contra,css.getId());
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnEntrar.setFont(new Font("Forte", Font.PLAIN, 20));
		btnEntrar.setBounds(62, 380, 89, 23);
		add(btnEntrar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				try {
					EventQueueClient css = EventQueueClient.Instancia();
					css.getMainWindow().getFrame().dispose();
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSalir.setFont(new Font("Forte", Font.PLAIN, 20));
		btnSalir.setBounds(482, 380, 89, 23);
		add(btnSalir);
		
		lblRespuesta = new JLabel("");
		lblRespuesta.setFont(new Font("Forte", Font.PLAIN, 20));
		lblRespuesta.setBounds(226, 380, 175, 23);
		add(lblRespuesta);
		
		passwordContra = new JPasswordField();
		passwordContra.setFont(new Font("Forte", Font.PLAIN, 20));
		passwordContra.setBounds(226, 240, 175, 23);
		add(passwordContra);
		
	}
	public void loginError() {
		lblRespuesta.setText("Error en los datos del usuario");
	}
}
