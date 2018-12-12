package uy.edu.cei.Obligatorio.Client.Controller;

import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

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
			panel = new RealPanel();
		}
		return instancia;
	}
	
	public RealPanel darPanel() {
		return panel;
	}
	public void mostrarSalas() throws RemoteException {
		EventQueueClient eqc = EventQueueClient.Instancia();
		List<RealModel> lista = eqc.GetServer().getRealControllerImpl().darSalas();
		String[] contenido = new String[lista.size()];
		for(int i=0;i<lista.size();i++) {
			contenido[i] = lista.get(i).getNombre();
		}
		JList panelNuevo = new JList(contenido);
		panelNuevo.setBounds(10, 11, 146, 250);
		panel.getPanelLista().add(panelNuevo);
	}
	public void crearSala() {
		try {
			EventQueueClient eqc = EventQueueClient.Instancia();
			UsuarioModel usuario = eqc.GetServer().getUsuarioControllerImpl().buscarUsuarioPorId(eqc.getId());
			//falta arregla que pasa si el panel no se ingresa un numero
			RealController rci = eqc.GetServer().getRealControllerImpl();
			rci.crearSala(panel.getTxtNombre().getText(), usuario, Integer.parseInt(panel.getTxtApuesta().getText()));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void respuesta(GameNotification gn) {
		switch(gn.getType()) {
			case REAL_NAMETAKEN:
				panel.getLblRespuesta().setText("nombre de sala ya utilizado");
				panel.repaint();
				break;
			case REAL_CREATED:
				MainWindow main = MainWindow.getInstancia();
				main.cambiarVentana("waiting");
				break;
			default:
		}
	}
}
