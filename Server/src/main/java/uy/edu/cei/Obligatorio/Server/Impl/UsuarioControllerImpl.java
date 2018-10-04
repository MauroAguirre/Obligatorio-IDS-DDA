package uy.edu.cei.Obligatorio.Server.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;

import uy.edu.cei.Obligatorio.Common.Controller.UsuarioController;
import uy.edu.cei.Obligatorio.Domain.UsuarioModel;

public class UsuarioControllerImpl extends UnicastRemoteObject implements UsuarioController {
	private static UsuarioControllerImpl instancia;
	public UsuarioServiceMemoryImpl usuarioServiceMemoryImpl;

	public static UsuarioControllerImpl Instancia() throws RemoteException {
		if (instancia == null)
			instancia = new UsuarioControllerImpl();
		return instancia;
	}

	public UsuarioControllerImpl() throws RemoteException {
		super();
		usuarioServiceMemoryImpl = UsuarioServiceMemoryImpl.Instancia();
	}

	public UsuarioModel VerificarUsuario(String usuario, String contra) throws RemoteException {
		return usuarioServiceMemoryImpl.buscarUsuarioPorNombre(usuario);
		/*
		Map<String,UsuarioModel> usuarios = usuarioServiceImpl.ListaUsuarios();
		UsuarioModel user = new UsuarioModel(usuario,contra);

		for(UsuarioModel us : usuarios.values()){
			if(us.GetContra().equals(contra) && us.GetUsuario().equals(usuario))
				return us;
		}
		System.out.println("No se encontro el usuario");
		return null;
		*/
	}
}
