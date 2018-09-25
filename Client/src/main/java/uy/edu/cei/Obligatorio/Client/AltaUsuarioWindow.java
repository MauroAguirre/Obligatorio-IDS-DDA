package uy.edu.cei.Obligatorio.Client;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridBagLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class AltaUsuarioWindow {

	private Windows master;
	private JFrame Ventana;
	private JTextField txtUsuario;
	private JPasswordField pwdContra;
	private JTextField txtRes;

	public AltaUsuarioWindow() {
		initialize();
	}

	public void AgregarMaster(Windows master) {
		this.master = master;
	}
	
	public void Visibilidad(boolean res) {
		if(res)
			Ventana.setVisible(true);
		else
			Ventana.setVisible(false);
	}
	
	public void initialize() {
		Ventana = new JFrame();
		Ventana.setTitle("Generala");
		Ventana.setBounds(100, 100, 450, 300);
		Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		Ventana.getContentPane().setLayout(springLayout);
		
		JLabel lblAltaDeUsuario = new JLabel("Alta de usuario");
		springLayout.putConstraint(SpringLayout.NORTH, lblAltaDeUsuario, 27, SpringLayout.NORTH, Ventana.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblAltaDeUsuario, 158, SpringLayout.WEST, Ventana.getContentPane());
		Ventana.getContentPane().add(lblAltaDeUsuario);
		
		JLabel lblUsuario = new JLabel("Usuario");
		springLayout.putConstraint(SpringLayout.NORTH, lblUsuario, 72, SpringLayout.NORTH, Ventana.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblUsuario, 76, SpringLayout.WEST, Ventana.getContentPane());
		Ventana.getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		springLayout.putConstraint(SpringLayout.NORTH, lblContrasea, 41, SpringLayout.SOUTH, lblUsuario);
		springLayout.putConstraint(SpringLayout.EAST, lblContrasea, 0, SpringLayout.EAST, lblUsuario);
		Ventana.getContentPane().add(lblContrasea);
		
		txtUsuario = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtUsuario, -3, SpringLayout.NORTH, lblUsuario);
		springLayout.putConstraint(SpringLayout.WEST, txtUsuario, 0, SpringLayout.WEST, lblAltaDeUsuario);
		Ventana.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		pwdContra = new JPasswordField();
		springLayout.putConstraint(SpringLayout.NORTH, pwdContra, -3, SpringLayout.NORTH, lblContrasea);
		springLayout.putConstraint(SpringLayout.WEST, pwdContra, 0, SpringLayout.WEST, lblAltaDeUsuario);
		springLayout.putConstraint(SpringLayout.EAST, pwdContra, -190, SpringLayout.EAST, Ventana.getContentPane());
		Ventana.getContentPane().add(pwdContra);
		
		JButton btnRegistrar = new JButton("Registrar");
		springLayout.putConstraint(SpringLayout.NORTH, btnRegistrar, 34, SpringLayout.SOUTH, lblContrasea);
		springLayout.putConstraint(SpringLayout.WEST, btnRegistrar, 0, SpringLayout.WEST, lblContrasea);
		Ventana.getContentPane().add(btnRegistrar);
		
		JButton btnSalir = new JButton("Salir");
		springLayout.putConstraint(SpringLayout.NORTH, btnSalir, 0, SpringLayout.NORTH, btnRegistrar);
		Ventana.getContentPane().add(btnSalir);
		
		txtRes = new JTextField();
		txtRes.setEditable(false);
		springLayout.putConstraint(SpringLayout.WEST, txtRes, 25, SpringLayout.EAST, btnRegistrar);
		springLayout.putConstraint(SpringLayout.EAST, txtRes, -190, SpringLayout.EAST, Ventana.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnSalir, 38, SpringLayout.EAST, txtRes);
		springLayout.putConstraint(SpringLayout.NORTH, txtRes, 1, SpringLayout.NORTH, btnRegistrar);
		Ventana.getContentPane().add(txtRes);
		txtRes.setColumns(10);
		Ventana.setVisible(false);
	}
}
