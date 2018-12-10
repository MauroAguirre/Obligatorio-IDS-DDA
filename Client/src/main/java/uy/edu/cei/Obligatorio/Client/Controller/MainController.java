package uy.edu.cei.Obligatorio.Client.Controller;

import uy.edu.cei.Obligatorio.Client.ui.Panel.MainPanel;
import uy.edu.cei.Obligatorio.Common.Notifications.GameNotification;

public class MainController implements MasterController{

	private static MainController instancia;
	private static MainPanel panel;
	
	public static MainController getInstancia() {
		if(instancia == null) {
			instancia = new MainController();
			panel = new MainPanel();
		}
		return instancia;
	}
	
	public MainPanel darPanel() {
		return panel;
	}

	@Override
	public void respuesta(GameNotification gn) {
		// TODO Auto-generated method stub
		
	}


	
}
