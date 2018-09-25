package uy.edu.cei.Obligatorio.Client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import com.jgoodies.forms.layout.FormSpecs;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.SpringLayout;
import javax.swing.JLabel;

public class IntroWindow {

	private Windows master;
	private JFrame Ventana;
	private JTextField txtUsuario;
	private JTextField txtContra;
	private JButton btnLogear;
	private JButton btnRegistro;
	private JLabel lblLogin;
	private JLabel lblUsuario;
	private JLabel lblContrasea;

	public IntroWindow()  {
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
	
	public void update(String message)  {
		Ventana.setVisible(false);
		Ventana.setVisible(true);
	}
	
	
	private void initialize() {
		Ventana = new JFrame();
		Ventana.setTitle("Generala");
		Ventana.setBounds(100, 100, 450, 300);
		Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		Ventana.getContentPane().setLayout(springLayout);
		
		btnLogear = new JButton("Logear");
		Ventana.getContentPane().add(btnLogear);
		btnLogear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtContra.setText(txtUsuario.getText());
				try {
					master.CambiarMenuRegistro();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnRegistro = new JButton("Registro");
		springLayout.putConstraint(SpringLayout.SOUTH, btnRegistro, -48, SpringLayout.SOUTH, Ventana.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnLogear, 0, SpringLayout.NORTH, btnRegistro);
		Ventana.getContentPane().add(btnRegistro);
		
		lblLogin = new JLabel("Login");
		springLayout.putConstraint(SpringLayout.NORTH, lblLogin, 10, SpringLayout.NORTH, Ventana.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblLogin, 182, SpringLayout.WEST, Ventana.getContentPane());
		Ventana.getContentPane().add(lblLogin);
		
		lblUsuario = new JLabel("Usuario");
		springLayout.putConstraint(SpringLayout.WEST, lblUsuario, 97, SpringLayout.WEST, Ventana.getContentPane());
		Ventana.getContentPane().add(lblUsuario);
		
		lblContrasea = new JLabel("Contraseña");
		springLayout.putConstraint(SpringLayout.EAST, btnRegistro, 0, SpringLayout.EAST, lblContrasea);
		springLayout.putConstraint(SpringLayout.WEST, lblContrasea, 0, SpringLayout.WEST, lblUsuario);
		Ventana.getContentPane().add(lblContrasea);
		
		txtUsuario = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, btnLogear, 0, SpringLayout.WEST, txtUsuario);
		springLayout.putConstraint(SpringLayout.NORTH, lblUsuario, 3, SpringLayout.NORTH, txtUsuario);
		springLayout.putConstraint(SpringLayout.EAST, lblUsuario, -64, SpringLayout.WEST, txtUsuario);
		springLayout.putConstraint(SpringLayout.NORTH, txtUsuario, 43, SpringLayout.NORTH, Ventana.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, txtUsuario, 247, SpringLayout.WEST, Ventana.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtUsuario, -66, SpringLayout.EAST, Ventana.getContentPane());
		Ventana.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContra = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, lblContrasea, 3, SpringLayout.NORTH, txtContra);
		springLayout.putConstraint(SpringLayout.NORTH, txtContra, 39, SpringLayout.SOUTH, txtUsuario);
		springLayout.putConstraint(SpringLayout.WEST, txtContra, 0, SpringLayout.WEST, txtUsuario);
		springLayout.putConstraint(SpringLayout.EAST, txtContra, -66, SpringLayout.EAST, Ventana.getContentPane());
		Ventana.getContentPane().add(txtContra);
		txtContra.setColumns(10);
		
		Ventana.setVisible(true);
	}
}
