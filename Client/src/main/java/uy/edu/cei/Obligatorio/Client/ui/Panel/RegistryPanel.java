package uy.edu.cei.Obligatorio.Client.ui.Panel;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SpringLayout;

import uy.edu.cei.Obligatorio.Client.CommClientServer;
import uy.edu.cei.Obligatorio.Client.ui.MainWindow;
import uy.edu.cei.Obligatorio.Common.Controller.UsuarioController;
import uy.edu.cei.Obligatorio.Domain.UsuarioModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class RegistryPanel extends JPanel {
	private JTextField txtUsuario;
	private JTextField txtContra;
	private MainWindow master;
	/**
	 * Create the panel.
	 */
	public RegistryPanel(MainWindow master) {
		this.master = master;
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
		springLayout.putConstraint(SpringLayout.WEST, btnSalir, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnSalir, -10, SpringLayout.SOUTH, this);
		add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					master.GetFrame().setVisible(false);
					master.GetFrame().dispose();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
			}
		});
		
		JButton btnAgregar = new JButton("Agregar");
		springLayout.putConstraint(SpringLayout.NORTH, btnAgregar, 0, SpringLayout.NORTH, btnSalir);
		springLayout.putConstraint(SpringLayout.EAST, btnAgregar, -10, SpringLayout.EAST, this);
		add(btnAgregar);
	}
}
