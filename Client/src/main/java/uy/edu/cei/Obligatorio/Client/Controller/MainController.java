package uy.edu.cei.Obligatorio.Client.Controller;

import java.rmi.RemoteException;

import uy.edu.cei.Obligatorio.Client.App.EventQueueClient;
import uy.edu.cei.Obligatorio.Client.ui.Panel.LoginPanel;
import uy.edu.cei.Obligatorio.Client.ui.Panel.MainPanel;

public class MainController {

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
	
	public void IngresarSalaVirtual() {
		try {
			EventQueueClient eqc = EventQueueClient.Instancia();
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
