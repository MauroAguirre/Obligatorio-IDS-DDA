package uy.edu.cei.Obligatorio.Client.Controller;

import uy.edu.cei.Obligatorio.Client.ui.Panel.Game.GamePanel;

public class GameController {
	private static GameController instancia;
	private static GamePanel panel;
	
	public static GameController getInstancia() {
		if(instancia == null) {
			instancia = new GameController();
			panel = new GamePanel();
		}
		return instancia;
	}
	
	public GamePanel darPanel() {
		return panel;
	}
}
