package uy.edu.cei.Obligatorio.Server.Impl.Model;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.persistence.EntityManager;

import uy.edu.cei.Obligatorio.Common.Observer;
import uy.edu.cei.Obligatorio.Common.Controller.UsuarioController;
import uy.edu.cei.Obligatorio.Common.Notifications.GameNotification;
import uy.edu.cei.Obligatorio.Common.Notifications.GameNotificationAction;
import uy.edu.cei.Obligatorio.Common.Notifications.GameNotificationType;
import uy.edu.cei.Obligatorio.Domain.UsuarioModel;
import uy.edu.cei.Obligatorio.Server.Impl.Service.UsuarioServiceMemoryImpl;
import uy.edu.cei.Obligatorio.Server.Service.UsuarioService;

public class UsuarioControllerImpl extends UnicastRemoteObject implements UsuarioController {

	private static final long serialVersionUID = 1L;
	public UsuarioServiceMemoryImpl usuarioServiceMemoryImpl;
	private List<Observer> observers;
	private UsuarioService us;

	public UsuarioControllerImpl(List<Observer> observers) throws RemoteException {
		this.observers = observers;
		this.us = UsuarioService.userServiceFactory();
	}
	
	public void verificarUsuario(String usuario, String contra, long id) throws RemoteException {
		System.out.println("Usuario: "+usuario+" Contraseña: "+contra+" Id: "+id);
		UsuarioModel usuarioModel = us.buscarUsuarioPorNombre(usuario);
		GameNotification gameNotification;
		if(usuarioModel != null && usuarioModel.GetContra().equals(contra)) {
			gameNotification = new GameNotification(GameNotificationType.LOGIN,GameNotificationAction.LOG,id,usuarioModel.getId());
		}
		else
			gameNotification = new GameNotification(GameNotificationType.LOGIN,GameNotificationAction.ERROR,id);
		for(int i=0;i<observers.size();i++) {
			if(observers.get(i).getId()==id) {
				observers.get(i).update(gameNotification);
				break;
			}
		}
	}

	public UsuarioModel agregarUsuario(String nombre, String contra) throws RemoteException {
		return us.registrar(nombre, contra);
	}

	@Override
	public List<UsuarioModel> ListaUsuarios() throws RemoteException {
		return us.ListaUsuarios();
	}
}
