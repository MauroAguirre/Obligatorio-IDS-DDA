package uy.edu.cei.Obligatorio.Client.ui.Panel;

import javax.swing.JPanel;
import javax.swing.ListModel;

import uy.edu.cei.Obligatorio.Client.ui.MainWindow;

import java.awt.Color;
import java.net.URL;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RankingPanel extends GeneralaPanel {

	private JList<String> puntaje;
	private JList<String> victorias;
	private JList<String> reales;
	private JList<String> virtuales;
	
	public JList<String> getPuntaje(){
		return this.puntaje;
	}
	public JList<String> getVictorias(){
		return this.victorias;
	}
	public JList<String> getReales(){
		return this.reales;
	}
	public JList<String> getVirtuales(){
		return this.virtuales;
	}
	
	public RankingPanel() {
		setBackground(Color.ORANGE);
		setLayout(null);
		this.setSize(640, 480);
		URL url = this.getClass().getClassLoader().getResource("fondo2.jpg");
		ImageIcon image = new ImageIcon(url);
		
		JLabel lblRankingMundial = new JLabel("Ranking Mundial");
		lblRankingMundial.setFont(new Font("Forte", Font.PLAIN, 20));
		lblRankingMundial.setBounds(238, 60, 170, 28);
		add(lblRankingMundial);
		
		JPanel panelPuntaje = new JPanel();
		panelPuntaje.setBounds(26, 166, 130, 180);
		add(panelPuntaje);
		
		JPanel panelVictorias = new JPanel();
		panelVictorias.setBounds(500, 166, 130, 180);
		add(panelVictorias);
		panelVictorias.setLayout(null);
		
		JPanel panelReales = new JPanel();
		panelReales.setBounds(180, 261, 130, 180);
		add(panelReales);
		panelReales.setLayout(null);
		
		JPanel panelVirtuales = new JPanel();
		panelVirtuales.setBounds(334, 261, 130, 180);
		add(panelVirtuales);
		panelVirtuales.setLayout(null);
		
		JLabel lblTopPuntaje = new JLabel("Top Puntaje");
		lblTopPuntaje.setFont(new Font("Forte", Font.PLAIN, 20));
		lblTopPuntaje.setBounds(28, 116, 107, 28);
		add(lblTopPuntaje);
		
		JLabel lblTopReales = new JLabel("Top Reales");
		lblTopReales.setFont(new Font("Forte", Font.PLAIN, 20));
		lblTopReales.setBounds(191, 222, 107, 28);
		add(lblTopReales);
		
		JLabel lblTopVirtuales = new JLabel("Top Virtuales");
		lblTopVirtuales.setFont(new Font("Forte", Font.PLAIN, 20));
		lblTopVirtuales.setBounds(343, 222, 121, 28);
		add(lblTopVirtuales);
		
		JLabel lblTopVictorias = new JLabel("Top Victorias");
		lblTopVictorias.setFont(new Font("Forte", Font.PLAIN, 20));
		lblTopVictorias.setBounds(508, 116, 122, 28);
		add(lblTopVictorias);
		panelPuntaje.setLayout(null);
		
		puntaje = new JList<String>();
		puntaje.setFont(new Font("Forte", Font.PLAIN, 18));
		puntaje.setBounds(10, 11, 110, 158);
		puntaje.setModel(new AbstractListModel() {
			String[] values = new String[] {"3232", "4232", "3232323", "232323232", "32323232323"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panelPuntaje.add(puntaje);
		
		victorias = new JList<String>();
		victorias.setFont(new Font("Forte", Font.PLAIN, 18));
		victorias.setBounds(10, 11, 110, 158);
		victorias.setModel(new AbstractListModel() {
			String[] values = new String[] {"3232", "4232", "3232323", "232323232", "32323232323"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panelVictorias.add(victorias);
		
		reales = new JList<String>();
		reales.setFont(new Font("Forte", Font.PLAIN, 18));
		reales.setBounds(10, 11, 110, 158);
		reales.setModel(new AbstractListModel() {
			String[] values = new String[] {"3232", "4232", "3232323", "232323232", "32323232323"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panelReales.add(reales);
		
		virtuales = new JList<String>();
		virtuales.setFont(new Font("Forte", Font.PLAIN, 18));
		virtuales.setBounds(10, 11, 110, 158);
		virtuales.setModel(new AbstractListModel() {
			String[] values = new String[] {"3232", "4232", "3232323", "232323232", "32323232323"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panelVirtuales.add(virtuales);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MainWindow main = MainWindow.getInstancia();
				main.cambiarVentana("main");
			}
		});
		btnNewButton.setFont(new Font("Forte", Font.PLAIN, 20));
		btnNewButton.setBounds(521, 418, 89, 23);
		add(btnNewButton);
		
		JLabel img = new JLabel();
		img.setLocation(0, 0);
		img.setSize(640,480);
		add(img);
		img.setIcon(image);
		img.setVisible(true);
		
	}
}
