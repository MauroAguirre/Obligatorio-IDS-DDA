package uy.edu.cei.Obligatorio.Client.ui.Panel;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ListModel;

import uy.edu.cei.Obligatorio.Domain.UsuarioModel;

import java.awt.Font;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class RealPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean modificable;
	/**
	 * Create the panel.
	 */
	public RealPanel() {
		this.modificable=false;
		setLayout(null);
		this.setSize(640, 480);
		URL url = this.getClass().getClassLoader().getResource("fondo2.jpg");
		ImageIcon image = new ImageIcon(url);
		DefaultListModel<String> model = new DefaultListModel<String>();
		model.addElement("hola");
		
		JLabel lblSalasReales = new JLabel("Salas Reales");
		lblSalasReales.setFont(new Font("Forte", Font.PLAIN, 20));
		lblSalasReales.setBounds(229, 60, 130, 23);
		add(lblSalasReales);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Forte", Font.PLAIN, 20));
		lblNombre.setBounds(55, 121, 75, 23);
		add(lblNombre);
		
		JLabel lblJugadores = new JLabel("Jugadores");
		lblJugadores.setFont(new Font("Forte", Font.PLAIN, 20));
		lblJugadores.setBounds(229, 121, 98, 23);
		add(lblJugadores);
		
		JLabel lblAccion = new JLabel("Accion");
		lblAccion.setFont(new Font("Forte", Font.PLAIN, 20));
		lblAccion.setBounds(442, 121, 67, 23);
		add(lblAccion);
		
		JLabel lblSala1 = new JLabel("Sala 1");
		lblSala1.setFont(new Font("Forte", Font.PLAIN, 20));
		lblSala1.setBounds(55, 180, 67, 23);
		add(lblSala1);
		
		JLabel lblSala2 = new JLabel("Sala 2");
		lblSala2.setFont(new Font("Forte", Font.PLAIN, 20));
		lblSala2.setBounds(55, 210, 67, 23);
		add(lblSala2);
		
		JLabel lblSala3 = new JLabel("Sala 3");
		lblSala3.setFont(new Font("Forte", Font.PLAIN, 20));
		lblSala3.setBounds(55, 241, 67, 23);
		add(lblSala3);
		
		JLabel lblSala4 = new JLabel("Sala 4");
		lblSala4.setFont(new Font("Forte", Font.PLAIN, 20));
		lblSala4.setBounds(55, 271, 67, 23);
		add(lblSala4);
		
		JLabel lblSala5 = new JLabel("Sala 5");
		lblSala5.setFont(new Font("Forte", Font.PLAIN, 20));
		lblSala5.setBounds(55, 300, 67, 23);
		add(lblSala5);
		
		JLabel lblSala6 = new JLabel("Sala 6");
		lblSala6.setFont(new Font("Forte", Font.PLAIN, 20));
		lblSala6.setBounds(55, 331, 67, 23);
		add(lblSala6);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.setFont(new Font("Forte", Font.PLAIN, 20));
		btnNewButton.setBounds(241, 416, 75, 23);
		add(btnNewButton);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Forte", Font.PLAIN, 20));
		btnEntrar.setBounds(431, 180, 85, 23);
		add(btnEntrar);
		
		JButton btnEntrar2 = new JButton("Entrar");
		btnEntrar2.setFont(new Font("Forte", Font.PLAIN, 20));
		btnEntrar2.setBounds(431, 213, 85, 23);
		add(btnEntrar2);
		
		JButton btnEntrar3 = new JButton("Entrar");
		btnEntrar3.setFont(new Font("Forte", Font.PLAIN, 20));
		btnEntrar3.setBounds(431, 241, 85, 23);
		add(btnEntrar3);
		
		JButton btnEntrar4 = new JButton("Entrar");
		btnEntrar4.setFont(new Font("Forte", Font.PLAIN, 20));
		btnEntrar4.setBounds(431, 271, 85, 23);
		add(btnEntrar4);
		
		JButton btnEntrar5 = new JButton("Entrar");
		btnEntrar5.setFont(new Font("Forte", Font.PLAIN, 20));
		btnEntrar5.setBounds(431, 303, 85, 23);
		add(btnEntrar5);
		
		JButton btnEntrar6 = new JButton("Entrar");
		btnEntrar6.setFont(new Font("Forte", Font.PLAIN, 20));
		btnEntrar6.setBounds(431, 331, 85, 23);
		add(btnEntrar6);
		
		JLabel lblJugadores1 = new JLabel("0");
		lblJugadores1.setFont(new Font("Forte", Font.PLAIN, 20));
		lblJugadores1.setBounds(260, 180, 20, 23);
		add(lblJugadores1);
		
		JLabel lblJugadores2 = new JLabel("0");
		lblJugadores2.setFont(new Font("Forte", Font.PLAIN, 20));
		lblJugadores2.setBounds(260, 210, 20, 23);
		add(lblJugadores2);
		
		JLabel lblJugadores3 = new JLabel("0");
		lblJugadores3.setFont(new Font("Forte", Font.PLAIN, 20));
		lblJugadores3.setBounds(260, 241, 20, 23);
		add(lblJugadores3);
		
		JLabel lblJugadores4 = new JLabel("0");
		lblJugadores4.setFont(new Font("Forte", Font.PLAIN, 20));
		lblJugadores4.setBounds(260, 271, 20, 23);
		add(lblJugadores4);
		
		JLabel lblJugadores5 = new JLabel("0");
		lblJugadores5.setFont(new Font("Forte", Font.PLAIN, 20));
		lblJugadores5.setBounds(260, 300, 20, 23);
		add(lblJugadores5);
		
		JLabel lblJugadores6 = new JLabel("0");
		lblJugadores6.setFont(new Font("Forte", Font.PLAIN, 20));
		lblJugadores6.setBounds(260, 331, 20, 23);
		add(lblJugadores6);
		JLabel img = new JLabel();
		img.setLocation(0, 0);
		img.setSize(640,480);
		add(img);
		img.setIcon(image);
		img.setVisible(true);
	}
}
