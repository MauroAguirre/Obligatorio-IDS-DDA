package uy.edu.cei.Obligatorio.Client.Controller;

import java.rmi.RemoteException;
import java.util.List;

import javax.swing.DefaultListModel;

import uy.edu.cei.Obligatorio.Client.App.EventQueueClient;
import uy.edu.cei.Obligatorio.Client.ui.Panel.GeneralaPanel;
import uy.edu.cei.Obligatorio.Client.ui.Panel.RegistryPanel;
import uy.edu.cei.Obligatorio.Common.Notifications.GameNotification;
import uy.edu.cei.Obligatorio.Common.Server.Server;
import uy.edu.cei.Obligatorio.Domain.UsuarioModel;

public class RegistryController implements MasterController{
	private static RegistryController instancia;
	private static RegistryPanel panel;
	
	public static RegistryController getInstancia() {
		if(instancia == null) {
			instancia = new RegistryController();
			panel = new RegistryPanel();
		}
		return instancia;
	}
	public void agregarUsuario() {
		if(panel.seleccionadoAvatares()==0)
			panel.getLblRespuesta().setText("Error");
		else {
			try {
				EventQueueClient eqc = EventQueueClient.Instancia();
				Server server = eqc.getServer();
				server.getUsuarioControllerImpl().agregarUsuario(panel.getTxtNombre().getText(), panel.getTxtContra().getText(), panel.seleccionadoAvatares(),eqc.getId());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void listarUsuarios(){
		try {
			EventQueueClient eqc = EventQueueClient.Instancia();
			List<UsuarioModel> usuarios = eqc.getServer().getUsuarioControllerImpl().listaUsuarios();
			DefaultListModel<String> modelo = new DefaultListModel<String>();
			for(int i=0;i<usuarios.size();i++) {
				modelo.addElement(usuarios.get(i).getId()+" - "+usuarios.get(i).GetUsuario()+" - "+usuarios.get(i).GetContra()+" - "+usuarios.get(i).getAvatar());
			}
			panel.getListado().setModel(modelo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void modificarUsuario() {
		if(panel.seleccionadoAvatares()==0|| panel.seleccionadoListado()==0)
			panel.getLblRespuesta().setText("Error");
		else {
			try {
				EventQueueClient eqc = EventQueueClient.Instancia();
				Server server = eqc.getServer();
				String seleccion = (String) panel.getListado().getModel().getElementAt(panel.getListado().getSelectedIndex());
				String id="";
				int num=0;
				while(!seleccion.substring(num, num+1).equals(" ")) {
					id+=seleccion.substring(num, num+1);
					num++;
				}
				server.getUsuarioControllerImpl().modificarUsuario(Long.parseLong(id),panel.getTxtNombre().getText(), panel.getTxtContra().getText(), panel.seleccionadoAvatares(),eqc.getId());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Override
	public GeneralaPanel darPanel() {
		return this.panel;
	}
	@Override
	public void respuesta(GameNotification gn) {
		switch(gn.getType()) {
			case USER_CREATED:
				panel.getLblRespuesta().setText("Creado");
				listarUsuarios();
				break;
			case USER_CREATEDERROR:
				panel.getLblRespuesta().setText("Error");
				break;
			case USER_MODIFY:
				panel.getLblRespuesta().setText("Modificado");
				listarUsuarios();
				break;
			default:
		}
		panel.repaint();
		System.out.println(gn.getType());
	}
	@Override
	public void intro() {
		// TODO Auto-generated method stub
		
	}
}
