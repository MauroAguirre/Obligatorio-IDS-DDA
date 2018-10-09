package uy.edu.cei.Obligatorio.Server.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

import uy.edu.cei.Obligatorio.Domain.UsuarioModel;
import uy.edu.cei.Obligatorio.Server.UsuarioService;

public class UsuarioServiceMemoryImpl extends UnicastRemoteObject implements UsuarioService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static UsuarioServiceMemoryImpl instancia;
	private Map<String,UsuarioModel> mapUsuarios;
	
	protected UsuarioServiceMemoryImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static UsuarioServiceMemoryImpl Instancia() throws RemoteException {
		if(instancia == null) {
			instancia = new UsuarioServiceMemoryImpl();
		}		
		return instancia;
	}

	@Override
	public Map<String, UsuarioModel> ListaUsuarios() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioModel buscarUsuarioPorNombre(String nombre) {
		this.mapUsuarios = new HashMap<String,UsuarioModel>();
		this.mapUsuarios.put("mauro", new UsuarioModel("mauro","123"));
		this.mapUsuarios.put("matias", new UsuarioModel("matias","123"));
		return mapUsuarios.get(nombre);
	}

}
