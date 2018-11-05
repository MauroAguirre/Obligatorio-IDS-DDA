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

		users.put("mauro", new UsuarioModel("mauro", "123"));
		users.put("matias", new UsuarioModel("matias", "123"));
		users.put("kakaroto", new UsuarioModel("kakaroto", "123"));
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
