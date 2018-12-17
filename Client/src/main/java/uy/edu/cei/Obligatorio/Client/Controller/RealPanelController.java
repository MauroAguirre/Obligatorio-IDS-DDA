package uy.edu.cei.Obligatorio.Client.Controller;

import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import uy.edu.cei.Obligatorio.Client.App.EventQueueClient;
import uy.edu.cei.Obligatorio.Client.ui.MainWindow;
import uy.edu.cei.Obligatorio.Client.ui.Panel.RealPanel;
import uy.edu.cei.Obligatorio.Common.Controller.RealController;
import uy.edu.cei.Obligatorio.Common.Notifications.GameNotification;
import uy.edu.cei.Obligatorio.Domain.RealModel;
import uy.edu.cei.Obligatorio.Domain.UsuarioModel;

public class RealPanelController implements MasterController {
	private static RealPanelController instancia;
	private static RealPanel panel;
	
	public static RealPanelController getInstancia() {
		if(instancia == null) {
			instancia = new RealPanelController();
			
			try {
				EventQueueClient eqc = EventQueueClient.Instancia();
				List<RealModel> salas = eqc.getServer().getRealControllerImpl().darSalas();
				DefaultListModel modelo = new DefaultListModel();
				for(int i=0;i<salas.size();i++) {
					modelo.addElement(salas.get(i).getNombre());
				}
				panel = new RealPanel(modelo);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return instancia;
	}
	
	public RealPanel darPanel() {
		return panel;
	}
	
	public void entrarSala() {
		try {
			String nombreSala = panel.getLista().getSelectedValue();
			EventQueueClient eqc = EventQueueClient.Instancia();
			UsuarioModel usuario = eqc.getServer().getUsuarioControllerImpl().buscarUsuarioPorId(eqc.getId());
			RealController rci = eqc.getServer().getRealControllerImpl();
			rci.entrarSala(nombreSala, usuario);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mostrarSalas() {
		try {
			EventQueueClient eqc = EventQueueClient.Instancia();
			List<RealModel> salas = eqc.getServer().getRealControllerImpl().darSalas();
			DefaultListModel modelo = new DefaultListModel();
			for(int i=0;i<salas.size();i++) {
				modelo.addElement(salas.get(i).getNombre());
			}
			panel.getLista().setModel(modelo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public void crearSala() {
		try {
			EventQueueClient eqc = EventQueueClient.Instancia();
			UsuarioModel usuario = eqc.getServer().getUsuarioControllerImpl().buscarUsuarioPorId(eqc.getId());
			//falta arregla que pasa si el panel no se ingresa un numero
			RealController rci = eqc.getServer().getRealControllerImpl();
			rci.crearSala(panel.getTxtNombre().getText(), usuario, Integer.parseInt(panel.getTxtApuesta().getText()));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void respuesta(GameNotification gn) {
		MainWindow main = MainWindow.getInstancia();
		switch(gn.getType()) {
			case REAL_NAMETAKEN:
				panel.getLblRespuesta().setText("nombre de sala ya utilizado");
				panel.repaint();
				break;
			case REAL_CREATED:
				main.cambiarVentana("waiting");
				break;
			case REAL_MATCHNOTFOUND:
				panel.getLblRespuesta().setText("no se encontro una sala");
				panel.repaint();
				break;
			case REAL_MATCHSTART:
				main.cambiarVentana("game");
				GameController gc = GameController.getInstancia();
				gc.setSala(gn.getSala());
				if(gn.getDato()==1)
					gc.primero();
				else
					gc.segundo();
				break;
			default:
		}
		System.out.println(gn.getType());
	}

	@Override
	public void intro() {
		// TODO Auto-generated method stub
		
	}
}
