package uy.edu.cei.Obligatorio.Client.ui.Panel;

import uy.edu.cei.Obligatorio.Client.Controller.LoginController;
import uy.edu.cei.Obligatorio.Client.ui.MainWindow;
import uy.edu.cei.Obligatorio.Common.Notifications.GameNotification;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class LoginPanel extends GeneralaPanel{

	private static final long serialVersionUID = 1L;
	private JTextField textUsuario;
	private JPasswordField passwordContra;
	private JLabel lblRespuesta;
	private JLabel lblLogin;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JButton btnSalir;
	private JButton btnEntrar;
	private boolean modificable;
	
	public JTextField getTextUsuario() {
		return this.textUsuario;
	}
	public JPasswordField getPasswordContra() {
		return this.passwordContra;
	}
	public JLabel getLblRespuesta() {
		return this.lblRespuesta;
	}
	public JLabel getLblLogin() {
		return this.lblLogin;
	}
	public JLabel getLblUsuario() {
		return this.lblUsuario;
	}
	public JLabel getLblContrasea() {
		return this.lblContrasea;
	}
	public JButton getBtnSalir() {
		return this.btnSalir;
	}
	public JButton getBtnEntrar() {
		return this.btnEntrar;
	}
	public boolean getModificable() {
		return this.modificable;
	}
	public void setModificable(boolean cambio) {
		this.modificable = cambio;
	}
	
	public LoginPanel() {
		this.modificable=false;
		setLayout(null);
		this.setSize(640, 480);
		URL url = this.getClass().getClassLoader().getResource("fondo2.jpg");
		ImageIcon image = new ImageIcon(url);
		
		lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Forte", Font.PLAIN, 20));
		lblLogin.setBounds(283, 60, 60, 23);
		add(lblLogin);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				lblUsuario.setForeground(Color.BLUE);
			}
		});
		lblUsuario.setFont(new Font("Forte", Font.PLAIN, 20));
		lblUsuario.setBounds(140, 153, 83, 23);
		add(lblUsuario);
		
		lblContrasea = new JLabel("Contraseña");
		lblContrasea.setFont(new Font("Forte", Font.PLAIN, 20));
		lblContrasea.setBounds(116, 237, 107, 30);
		add(lblContrasea);
		
		textUsuario = new JTextField();
		textUsuario.setFont(new Font("Forte", Font.PLAIN, 20));
		textUsuario.setBounds(343, 152, 175, 24);
		add(textUsuario);
		textUsuario.setColumns(10);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(modificable) {
					LoginController lc = new LoginController();
					lc.IntentarLogear();
				}				
			}
		});
		btnEntrar.setFont(new Font("Forte", Font.PLAIN, 20));
		btnEntrar.setBounds(134, 357, 89, 23);
		add(btnEntrar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(modificable) {
					MainWindow mainWindow = MainWindow.getInstancia();
					mainWindow.cambiarVentana("kill");
				}
			}
		});
		btnSalir.setFont(new Font("Forte", Font.PLAIN, 20));
		btnSalir.setBounds(343, 357, 89, 23);
		add(btnSalir);
		
		lblRespuesta = new JLabel("");
		lblRespuesta.setFont(new Font("Forte", Font.PLAIN, 20));
		lblRespuesta.setBounds(211, 301, 175, 23);
		add(lblRespuesta);
		
		passwordContra = new JPasswordField();
		passwordContra.setFont(new Font("Forte", Font.PLAIN, 20));
		passwordContra.setBounds(343, 240, 175, 23);
		add(passwordContra);
		JLabel img = new JLabel();
		img.setLocation(0, 0);
		img.setSize(640,480);
		add(img);
		img.setIcon(image);
		img.setVisible(true );
	}
}
