package uy.edu.cei.Obligatorio.Server.Impl.Controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;

import uy.edu.cei.Obligatorio.Common.Observer;
import uy.edu.cei.Obligatorio.Common.Controller.UsuarioController;
import uy.edu.cei.Obligatorio.Common.Notifications.GameNotification;
import uy.edu.cei.Obligatorio.Common.Notifications.GameNotificationType;
import uy.edu.cei.Obligatorio.Domain.UsuarioModel;
import uy.edu.cei.Obligatorio.Server.Impl.Service.UsuarioServiceMemoryImpl;
import uy.edu.cei.Obligatorio.Server.Service.UsuarioService;

public class UsuarioControllerImpl extends UnicastRemoteObject implements UsuarioController {

	private static final long serialVersionUID = 1L;
	private List<Observer> observers;
	private UsuarioService us;

	public UsuarioControllerImpl(List<Observer> observers) throws RemoteException {
		this.observers = observers;
		this.us = UsuarioService.userServiceFactory();
	}
	
	public void verificarUsuario(String usuario, String contra, Long id) throws RemoteException {
		System.out.println("Usuario: "+usuario+" Contraseña: "+contra+" Id: "+id);
		UsuarioModel usuarioModel = us.buscarUsuarioPorNombre(usuario);
		GameNotification gameNotification;
		if(usuarioModel != null && usuarioModel.GetContra().equals(contra)) {
			gameNotification = new GameNotification(GameNotificationType.LOGIN_SUCCES,usuarioModel.getId());
		}
		else
			gameNotification = new GameNotification(GameNotificationType.LOGIN_ERROR);
		for(int i=0;i<observers.size();i++) {
			if(observers.get(i).getId()==id) {
				observers.get(i).update(gameNotification);
				break;
			}
		}
	}

	public void agregarUsuario(String nombre, String contra,int avatar,Long id) throws RemoteException {
		UsuarioModel usuarioModel = us.registrar(nombre, contra,avatar);
		GameNotification gameNotification;
		if(usuarioModel != null) {
			gameNotification = new GameNotification(GameNotificationType.USER_CREATED);
		}
		else
			gameNotification = new GameNotification(GameNotificationType.USER_CREATEDERROR);
		for(int i=0;i<observers.size();i++) {
			if(observers.get(i).getId()==id) {
				observers.get(i).update(gameNotification);
				break;
			}
		}
	}

	@Override
	public List<UsuarioModel> listaUsuarios() throws RemoteException {
		return us.listaUsuarios();
	}
	
	@Override
	public UsuarioModel buscarUsuarioPorId(Long id) throws RemoteException {
		return us.buscarPorId(id);
	}

	@Override
	public void modificarUsuario(Long idUsuario,String usuario, String contra, int avatar,Long id) throws RemoteException {
		UsuarioModel usu = us.modificar(idUsuario,usuario, contra, avatar);
		GameNotification gameNotification;
		if(usu != null) {
			gameNotification = new GameNotification(GameNotificationType.USER_MODIFY);
		}
		else
			gameNotification = new GameNotification(GameNotificationType.USER_CREATEDERROR);
		for(int i=0;i<observers.size();i++) {
			if(observers.get(i).getId()==id) {
				observers.get(i).update(gameNotification);
				break;
			}
		}
	}

	@Override
	public List<UsuarioModel> listaVictorias() throws RemoteException {
		List<UsuarioModel> usuarios = us.listaVictorias();
		List<UsuarioModel> cortados = new LinkedList<UsuarioModel>();
		for(int i=0;i<usuarios.size()&&i<5;i++) {
			cortados.add(usuarios.get(i));
		}
		return cortados;
	}

	@Override
	public List<UsuarioModel> listaPuntos() throws RemoteException {
		List<UsuarioModel> usuarios = us.listaPuntos();
		List<UsuarioModel> cortados = new LinkedList<UsuarioModel>();
		for(int i=0;i<usuarios.size()&&i<5;i++) {
			cortados.add(usuarios.get(i));
		}
		return cortados;
	}

	@Override
	public List<UsuarioModel> listaReales() throws RemoteException {
		List<UsuarioModel> usuarios = us.listaReales();
		List<UsuarioModel> cortados = new LinkedList<UsuarioModel>();
		for(int i=0;i<usuarios.size()&&i<5;i++) {
			cortados.add(usuarios.get(i));
		}
		return cortados;
	}

	@Override
	public List<UsuarioModel> listaVirtuales() throws RemoteException {
		List<UsuarioModel> usuarios = us.listaVirtuales();
		List<UsuarioModel> cortados = new LinkedList<UsuarioModel>();
		for(int i=0;i<usuarios.size()&&i<5;i++) {
			cortados.add(usuarios.get(i));
		}
		return cortados;
	}

}
