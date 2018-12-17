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
	public void intro() {
		panel.setModificable(false);
		int contador=0;
		while(contador<100) {
			try {
				panel.getLblSalaReal().setBounds(31+(contador*2), 179, 135, 28);
				panel.getLblSalaReal().repaint();
				panel.getLblSalir().setBounds(269, 560-(contador*2), 47, 20);
				panel.getLblSalir().repaint();
				panel.getLblRankings().setBounds(255, 303, 86, 20);
				panel.getLblRankings().repaint();
				panel.getLblUsuarios().setBounds(255, 323-(contador*2), 86, 20);
				panel.getLblUsuarios().repaint();
				panel.getLblMenuPrincipal().setBounds(231, 263-(contador*2), 146, 20);
				panel.getLblMenuPrincipal().repaint();
				panel.getLblSalasVirtuales().setBounds(31+(contador*2), 240, 135, 28);
				panel.getLblSalasVirtuales().repaint();
				contador++;
				Thread.sleep(25);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		panel.setModificable(true);
	}
	@Override
	public void respuesta(GameNotification gn) {
		// TODO Auto-generated method stub
		
	}
	

	
}
