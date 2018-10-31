package uy.edu.cei.Obligatorio.Server.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;

import uy.edu.cei.Obligatorio.Common.Observer;
import uy.edu.cei.Obligatorio.Common.Controller.UsuarioController;
import uy.edu.cei.Obligatorio.Common.Notifications.GameNotification;
import uy.edu.cei.Obligatorio.Common.Notifications.GameNotificationType;
import uy.edu.cei.Obligatorio.Domain.UsuarioModel;
import uy.edu.cei.Obligatorio.Server.UsuarioService;

public class UsuarioControllerImpl extends UnicastRemoteObject implements UsuarioController {

	public UsuarioServiceMemoryImpl usuarioServiceMemoryImpl;
	private List<Observer> observers;

	public UsuarioControllerImpl(List<Observer> observers) throws RemoteException {
		this.observers = observers;
	}
	
	public void VerificarUsuario(String usuario, String contra, int id) throws RemoteException {
		System.out.println("Usuario: "+usuario+" Contraseña: "+contra+" Id: "+id);
		
		UsuarioService us = UsuarioService.userServiceFactory();
		UsuarioModel usuarioModel = us.buscarUsuarioPorNombre(usuario);
		GameNotification gameNotification;
		if(usuarioModel != null && usuarioModel.GetContra().equals(contra)) {
			gameNotification = new GameNotification(GameNotificationType.LOGIN,id);
		}
		else
			gameNotification = new GameNotification(GameNotificationType.LOGIN_ERROR,id);
		for(int i=0;i<observers.size();i++) {
			if(observers.get(i).getId()==id) {
				observers.get(i).update(gameNotification);
				break;
			}
		}
	}
}
