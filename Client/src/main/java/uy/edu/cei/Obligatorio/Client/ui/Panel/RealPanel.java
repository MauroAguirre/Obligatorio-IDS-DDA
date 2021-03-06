package uy.edu.cei.Obligatorio.Client.ui.Panel;

import java.net.URL;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import uy.edu.cei.Obligatorio.Client.Controller.RealPanelController;
import uy.edu.cei.Obligatorio.Client.ui.MainWindow;

import java.awt.Font;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RealPanel extends GeneralaPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean modificable;
	private JTextField txtNombre;
	private JTextField txtApuesta;
	private JLabel lblApuesta;
	private JLabel lblRespuesta;
	private JList<String> lista;
	//
	private JButton btnUnirse;
	private JButton btnSalir;
	private JButton btnCrear;
	private JLabel lblNombre;
	private JLabel lblSalasReales;
	
	public JTextField getTxtNombre() {
		return this.txtNombre;
	}
	public JTextField getTxtApuesta() {
		return this.txtApuesta;
	}
	public JLabel getLblRespuesta() {
		return this.lblRespuesta;
	}
	public JList<String> getLista(){
		return this.lista;
	}
	public RealPanel(DefaultListModel modelo) {
		
		/*
		RealPanelController rpc = RealPanelController.getInstancia();
		try {
			rpc.mostrarSalas();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/

		this.modificable=false;
		setLayout(null);
		this.setSize(640, 480);
		URL url = this.getClass().getClassLoader().getResource("fondo2.jpg");
		ImageIcon image = new ImageIcon(url);
		
        //create the list
        lista = new JList<>(modelo);
        lista.setBounds(430, 128, 200, 278);
        lista.setVisibleRowCount(1);
        add(lista);
        

		
		lblSalasReales = new JLabel("Salas Reales");
		lblSalasReales.setFont(new Font("Forte", Font.PLAIN, 20));
		lblSalasReales.setBounds(229, 60, 130, 23);
		add(lblSalasReales);
		
		lblApuesta = new JLabel("Apuesta");
		lblApuesta.setFont(new Font("Forte", Font.PLAIN, 20));
		lblApuesta.setBounds(50, 242, 84, 23);
		add(lblApuesta);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Forte", Font.PLAIN, 20));
		lblNombre.setBounds(50, 180, 84, 23);
		add(lblNombre);
		
		btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MainWindow main = MainWindow.getInstancia();
				main.cambiarVentana("main");
			}
		});
		btnSalir.setFont(new Font("Forte", Font.PLAIN, 20));
		btnSalir.setBounds(478, 417, 75, 23);
		add(btnSalir);
		
		btnCrear = new JButton("Crear");
		btnCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				RealPanelController rl = RealPanelController.getInstancia();
				rl.crearSala();
			}
		});
		btnCrear.setFont(new Font("Forte", Font.PLAIN, 20));
		btnCrear.setBounds(50, 417, 91, 23);
		add(btnCrear);
		
		btnUnirse = new JButton("Unirse");
		btnUnirse.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent arg0) {
				RealPanelController rl = RealPanelController.getInstancia();
				rl.entrarSala();
			}
		});
		btnUnirse.setFont(new Font("Forte", Font.PLAIN, 20));
		btnUnirse.setBounds(250, 417, 91, 23);
		add(btnUnirse);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Forte", Font.PLAIN, 20));
		txtNombre.setBounds(161, 181, 130, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApuesta = new JTextField();
		txtApuesta.setFont(new Font("Forte", Font.PLAIN, 20));
		txtApuesta.setColumns(10);
		txtApuesta.setBounds(161, 242, 130, 20);
		add(txtApuesta);
		
		lblRespuesta = new JLabel("");
		lblRespuesta.setFont(new Font("Forte", Font.PLAIN, 20));
		lblRespuesta.setBounds(50, 302, 241, 23);
		add(lblRespuesta);
		
		JLabel img = new JLabel();
		img.setLocation(0, 0);
		img.setSize(640,480);
		add(img);
		img.setIcon(image);
		img.setVisible(true);
		
	}
}
