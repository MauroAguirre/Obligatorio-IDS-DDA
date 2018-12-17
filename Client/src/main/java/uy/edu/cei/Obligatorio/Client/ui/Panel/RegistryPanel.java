package uy.edu.cei.Obligatorio.Client.ui.Panel;

import java.awt.Color;
import javax.swing.SpringLayout;

import uy.edu.cei.Obligatorio.Client.App.EventQueueClient;
import uy.edu.cei.Obligatorio.Client.Controller.RegistryController;
import uy.edu.cei.Obligatorio.Client.ui.MainWindow;
import uy.edu.cei.Obligatorio.Client.ui.Panel.Game.AvatarPanel;
import uy.edu.cei.Obligatorio.Domain.UsuarioModel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.rmi.RemoteException;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class RegistryPanel extends GeneralaPanel {

	private static final long serialVersionUID = 1L;
	private boolean modificable;
	private JTextField txtNombre;
	private JTextField txtContra;
	private AvatarPanel avatar;
	private JList listado;
	private JLabel lblRespuesta;
	private JList listadoAvatares;
	
	public JList getListado() {
		return this.listado;
	}
	public JTextField getTxtNombre() {
		return this.txtNombre;
	}
	public JTextField getTxtContra() {
		return this.txtContra;
	}
	public int seleccionadoListado() {
		return listado.getSelectedIndex()+1;
	}
	public int seleccionadoAvatares() {
		return listadoAvatares.getSelectedIndex()+1;
	}
	public JLabel getLblRespuesta() {
		return this.lblRespuesta;
	}
	
	public RegistryPanel() {
		this.modificable=false;
		setLayout(null);
		this.setSize(640, 480);
		URL url = this.getClass().getClassLoader().getResource("fondo2.jpg");
		ImageIcon image = new ImageIcon(url);
		setLayout(null);
		
		JLabel lblRegistro = new JLabel("Registro");
		lblRegistro.setFont(new Font("Forte", Font.PLAIN, 20));
		lblRegistro.setBounds(253, 30, 83, 26);
		add(lblRegistro);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Forte", Font.PLAIN, 20));
		lblNombre.setBounds(34, 118, 68, 26);
		add(lblNombre);
		
		JLabel lblContra = new JLabel("Contra");
		lblContra.setFont(new Font("Forte", Font.PLAIN, 20));
		lblContra.setBounds(34, 177, 68, 26);
		add(lblContra);
		
		lblRespuesta = new JLabel("");
		lblRespuesta.setFont(new Font("Forte", Font.PLAIN, 20));
		lblRespuesta.setBounds(295, 417, 210, 26);
		add(lblRespuesta);
		
		JLabel lblTituloTabla = new JLabel("Id - Nombre - Contra - Avatar");
		lblTituloTabla.setFont(new Font("Forte", Font.PLAIN, 20));
		lblTituloTabla.setBounds(369, 118, 261, 26);
		add(lblTituloTabla);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(142, 118, 141, 26);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtContra = new JTextField();
		txtContra.setColumns(10);
		txtContra.setBounds(142, 177, 141, 26);
		add(txtContra);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				RegistryController rc = RegistryController.getInstancia();
				rc.agregarUsuario();
			}
		});
		btnRegistrar.setFont(new Font("Forte", Font.PLAIN, 20));
		btnRegistrar.setBounds(10, 417, 115, 23);
		add(btnRegistrar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MainWindow main = MainWindow.getInstancia();
				main.cambiarVentana("main");
			}
		});
		btnSalir.setFont(new Font("Forte", Font.PLAIN, 20));
		btnSalir.setBounds(515, 417, 115, 23);
		add(btnSalir);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				RegistryController rc = RegistryController.getInstancia();
				rc.modificarUsuario();
			}
		});
		btnModificar.setFont(new Font("Forte", Font.PLAIN, 20));
		btnModificar.setBounds(142, 417, 132, 23);
		add(btnModificar);
		
		JPanel panelAvataresListado = new JPanel();
		panelAvataresListado.setBounds(77, 230, 24, 152);
		add(panelAvataresListado);
		panelAvataresListado.setLayout(null);
		
		listadoAvatares = new JList();
		listadoAvatares.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int seleccionado = listadoAvatares.getSelectedIndex();
				avatar.cambiar(seleccionado+1);
				repaint();
			}
		});
		listadoAvatares.setFont(new Font("Forte", Font.PLAIN, 20));
		listadoAvatares.setBounds(0, 0, 24, 152);
		panelAvataresListado.add(listadoAvatares);
		listadoAvatares.setModel(new AbstractListModel() {
			String[] values = new String[] {"1", "2", "3", "4", "5"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		

		avatar = new AvatarPanel(1);
		avatar.setBounds(142, 232, 150, 150);
		add(avatar);
		
		JPanel panelListado = new JPanel();
		panelListado.setBounds(369, 154, 261, 228);
		add(panelListado);
		panelListado.setLayout(null);
		
		listado = new JList();
		listado.setBounds(10, 11, 241, 206);
		listado.setModel(new AbstractListModel() {
			String[] values = new String[] {"53543", "534534", "345345"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panelListado.add(listado);
		
		JLabel img = new JLabel();
		img.setLocation(0, 0);
		img.setSize(640,480);
		add(img);
		img.setIcon(image);
		img.setVisible(true);
	}
}
