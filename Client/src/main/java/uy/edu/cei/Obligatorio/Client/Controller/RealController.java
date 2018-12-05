package uy.edu.cei.Obligatorio.Client.Controller;

import uy.edu.cei.Obligatorio.Client.ui.Panel.RealPanel;

public class RealController {
	private static RealController instancia;
	private static RealPanel panel;
	
	public static RealController getInstancia() {
		if(instancia == null) {
			instancia = new RealController();
			panel = new RealPanel();
		}
		return instancia;
	}
	
	public RealPanel darPanel() {
		return panel;
	}
}
