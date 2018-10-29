package uy.edu.cei.Obligatorio.Server.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;
import java.util.Observer;

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

	public UsuarioModel VerificarUsuario(String usuario, String contra) throws RemoteException {
		return usuarioServiceMemoryImpl.buscarUsuarioPorNombre(usuario);
	}
	
	public UsuarioModel login(String username, String password) throws RemoteException {
		System.out.println(String.format("username: %s, password: %s", username, password));
		
		UsuarioService us = UsuarioService.userServiceFactory();
		UsuarioModel userModel = us.buscarUsuarioPorNombre(username);
		if(userModel != null && 
				userModel.GetContra().equals(password)) {
			this.observers.forEach(o -> {
				GameNotification gameNotification = 
						new GameNotification();
				
				gameNotification.setCurrentUser("test");
				gameNotification.setType(
						GameNotificationType.THROW_DICE);
				
				o.update(null, gameNotification);
			});
			return userModel;
		}
		
		return null;
	}
}
