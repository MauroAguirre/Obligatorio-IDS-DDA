package uy.edu.cei.Obligatorio.Client.Controller;

import java.util.List;

import uy.edu.cei.Obligatorio.Client.ui.Panel.GeneralaPanel;
import uy.edu.cei.Obligatorio.Client.ui.Panel.RankingPanel;
import uy.edu.cei.Obligatorio.Common.Notifications.GameNotification;
import uy.edu.cei.Obligatorio.Domain.UsuarioModel;

public class RankingController implements MasterController {

	private static RankingController instancia;
	private static RankingPanel panel;
	
	public static RankingController getInstancia() {
		if(instancia == null) {
			instancia = new RankingController();
			panel = new RankingPanel();
		}
		return instancia;
	}
	@Override
	public GeneralaPanel darPanel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void respuesta(GameNotification gn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void intro() {
		// TODO Auto-generated method stub
		
	}
	public List<UsuarioModel> top5Puntacion(){
		return null;
	}
	public List<UsuarioModel> top5Victorias(){
		return null;
	}
	public List<UsuarioModel> top5Reales(){
		return null;
	}
	public List<UsuarioModel> top5Virtuales(){
		return null;
	}
}
