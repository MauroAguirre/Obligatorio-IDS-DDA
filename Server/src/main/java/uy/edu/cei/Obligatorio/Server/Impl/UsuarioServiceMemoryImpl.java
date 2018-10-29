package uy.edu.cei.Obligatorio.Server.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import uy.edu.cei.Obligatorio.Domain.UsuarioModel;
import uy.edu.cei.Obligatorio.Server.UsuarioService;

public class UsuarioServiceMemoryImpl implements UsuarioService {

	/**
	 * 
	 */
	private static UsuarioServiceMemoryImpl instance;

	static {
		UsuarioServiceMemoryImpl.instance = new UsuarioServiceMemoryImpl();
	}

	public static UsuarioServiceMemoryImpl getInstance() {
		return UsuarioServiceMemoryImpl.instance;
	}

	private Map<String, UsuarioModel> users;

	private UsuarioServiceMemoryImpl(){
		this.users = new TreeMap<>();

		users.put("pepe", new UsuarioModel("pepe", "password"));
		users.put("juan", new UsuarioModel("juan", "password"));
		users.put("jose", new UsuarioModel("jose", "password"));
	}

	@Override
	public UsuarioModel buscarUsuarioPorNombre(String username) {
		return this.users.get(username);
	}

	@Override
	public Map<String, UsuarioModel> ListaUsuarios() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


}
