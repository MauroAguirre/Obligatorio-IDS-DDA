package uy.edu.cei.Obligatorio.Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import uy.edu.cei.Obligatorio.Common.Controller.UsuarioController;
import uy.edu.cei.Obligatorio.Domain.UsuarioModel;

public class UsuarioControllerImpl extends UnicastRemoteObject implements UsuarioController {
	private static UsuarioControllerImpl instancia;

	public static UsuarioControllerImpl Instancia() throws RemoteException {
		if (instancia == null)
			instancia = new UsuarioControllerImpl();
		return instancia;
	}

	public UsuarioControllerImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsuarioModel VerificarUsuario(String usuario, String contra) throws RemoteException {
		System.out.println(usuario + " - " + contra);
		return null;
	}
}
