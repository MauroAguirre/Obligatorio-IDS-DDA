package uy.edu.cei.Obligatorio.Client.ui.Panel.Game;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;

public class GamePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public GamePanel() {
		
		setLayout(null);
		this.setSize(640, 480);
		URL url = this.getClass().getClassLoader().getResource("fondo2.jpg");
		ImageIcon image = new ImageIcon(url);
		
		JLabel lblSumaDeCuatros = new JLabel("Suma de Cuatros");
		lblSumaDeCuatros.setFont(new Font("Forte", Font.PLAIN, 20));
		lblSumaDeCuatros.setBounds(473, 123, 157, 20);
		add(lblSumaDeCuatros);
		
		JLabel lblSumaDeDos = new JLabel("Suma de Dos");
		lblSumaDeDos.setFont(new Font("Forte", Font.PLAIN, 20));
		lblSumaDeDos.setBounds(473, 61, 157, 20);
		add(lblSumaDeDos);
		
		JLabel lblJugada = new JLabel("Suma de Unos");
		lblJugada.setFont(new Font("Forte", Font.PLAIN, 20));
		lblJugada.setBounds(473, 30, 157, 20);
		add(lblJugada);
		
		JLabel label = new JLabel("Puntaje");
		label.setFont(new Font("Forte", Font.PLAIN, 20));
		label.setBounds(397, 185, 81, 20);
		add(label);
		
		JLabel lblPuntaje = new JLabel("Puntaje");
		lblPuntaje.setFont(new Font("Forte", Font.PLAIN, 20));
		lblPuntaje.setBounds(10, 270, 98, 20);
		add(lblPuntaje);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 320, 81, 149);
		add(panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(382, 11, 81, 149);
		add(panel_2);
		
		JButton btnNewButton = new JButton("Tirar Dados");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Forte", Font.PLAIN, 20));
		btnNewButton.setBounds(101, 446, 142, 23);
		add(btnNewButton);
		
		JButton btnLockearJugada = new JButton("Lockear Jugada");
		btnLockearJugada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLockearJugada.setFont(new Font("Forte", Font.PLAIN, 20));
		btnLockearJugada.setBounds(253, 446, 167, 23);
		add(btnLockearJugada);
		
		DicePanel dice1 = new DicePanel(1,"red");
		dice1.setBounds(130, 130, 40, 40);
		add(dice1);
		DicePanel dice2 = new DicePanel(2,"red");
		dice2.setBounds(180, 180, 40, 40);
		add(dice2);
		DicePanel dice3 = new DicePanel(3,"red");
		dice3.setBounds(230, 230, 40, 40);
		add(dice3);
		DicePanel dice4 = new DicePanel(4,"red");
		dice4.setBounds(280, 280, 40, 40);
		add(dice4);
		DicePanel dice5 = new DicePanel(5,"red");
		dice5.setBounds(330, 330, 40, 40);
		add(dice5);
		
		JLabel lblTiempo = new JLabel("Tiempo");
		lblTiempo.setFont(new Font("Forte", Font.PLAIN, 20));
		lblTiempo.setBounds(292, 31, 74, 20);
		add(lblTiempo);
		
		JLabel lblJugando = new JLabel("Jugando");
		lblJugando.setFont(new Font("Forte", Font.PLAIN, 20));
		lblJugando.setBounds(10, 31, 122, 20);
		add(lblJugando);
		
		JLabel lblSumaDeTres = new JLabel("Suma de Tres");
		lblSumaDeTres.setFont(new Font("Forte", Font.PLAIN, 20));
		lblSumaDeTres.setBounds(473, 92, 157, 20);
		add(lblSumaDeTres);
		
		JLabel img = new JLabel();
		img.setLocation(0, 0);
		img.setSize(640,480);
		add(img);
		img.setIcon(image);
		img.setVisible(true);
		
		/*
		DicePanel die1 = new DicePanel(1,"red");
		die1.setBounds(183, 220, 40, 40);
		add(die1);
		DicePanel die2 = new DicePanel(2,"red");
		die2.setBounds(183, 280, 40, 40);
		add(die2);
		DicePanel die3 = new DicePanel(3,"red");
		die3.setBounds(230, 265, 40, 40);
		add(die3);
		DicePanel die4 = new DicePanel(4,"red");
		die4.setBounds(310, 183, 40, 40);
		add(die4);
		DicePanel die5 = new DicePanel(6,"red");
		die5.setBounds(360, 260, 40, 40);
		add(die5);
		
		AvatarPanel avatar1 = new AvatarPanel(1);
		avatar1.setBounds(0,0,150,480);
		add(avatar1);
		
		AvatarPanel avatar2 = new AvatarPanel(2);
		avatar2.setBounds(490,0,150,480);
		add(avatar2);
		
		PlaysPanel plays = new PlaysPanel();
		plays.setBackground(Color.CYAN);
		plays.setBounds(0,360,640,120);
		add(plays);
		*/
	}
}
