package uy.edu.cei.Obligatorio.Client.Controller;

import java.rmi.RemoteException;
import java.util.List;

import javax.swing.DefaultListModel;

import uy.edu.cei.Obligatorio.Client.App.EventQueueClient;
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
		return this.panel;
	}

	@Override
	public void respuesta(GameNotification gn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void intro() {
		// TODO Auto-generated method stub
		
	}
	public void listado() {
		try {
			EventQueueClient eqc = EventQueueClient.Instancia();
			List<UsuarioModel> puntos = eqc.getServer().getUsuarioControllerImpl().listaPuntos();
			List<UsuarioModel> reales = eqc.getServer().getUsuarioControllerImpl().listaReales();
			List<UsuarioModel> victorias = eqc.getServer().getUsuarioControllerImpl().listaVictorias();
			List<UsuarioModel> virtuales = eqc.getServer().getUsuarioControllerImpl().listaVirtuales();
			DefaultListModel modelo = new DefaultListModel();
			for(int i=0;i<puntos.size();i++) {
				modelo.addElement(puntos.get(i).GetUsuario());
			}
			panel.getPuntaje().setModel(modelo);
			
			modelo = new DefaultListModel();
			for(int i=0;i<reales.size();i++) {
				modelo.addElement(reales.get(i).GetUsuario());
			}
			panel.getReales().setModel(modelo);
			
			modelo = new DefaultListModel();
			for(int i=0;i<victorias.size();i++) {
				modelo.addElement(victorias.get(i).GetUsuario());
			}
			panel.getVictorias().setModel(modelo);
			
			modelo = new DefaultListModel();
			for(int i=0;i<virtuales.size();i++) {
				modelo.addElement(virtuales.get(i).GetUsuario());
			}
			panel.getVirtuales().setModel(modelo);
			panel.repaint();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
