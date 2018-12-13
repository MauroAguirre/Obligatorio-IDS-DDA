package uy.edu.cei.Obligatorio.Client.Controller;

import uy.edu.cei.Obligatorio.Client.ui.Panel.Game.GamePanel;
import uy.edu.cei.Obligatorio.Common.Notifications.GameNotification;

public class GameController implements MasterController{
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

	@Override
	public void respuesta(GameNotification gn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void intro() {
		// TODO Auto-generated method stub
		
	}
	public void jugar(int i) {
		
	}
}
