package uy.edu.cei.Obligatorio.Client.ui.Panel.Game;

import javax.swing.JPanel;
import java.awt.Color;

public class GamePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public GamePanel() {
		setBackground(Color.LIGHT_GRAY);
		this.setSize(640,480);
		setLayout(null);
		
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
		plays.setBounds(150,360,340,120);
		add(plays);
	}

}
