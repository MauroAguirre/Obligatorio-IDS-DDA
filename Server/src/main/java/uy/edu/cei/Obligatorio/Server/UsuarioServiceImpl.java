package uy.edu.cei.Obligatorio.Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

import uy.edu.cei.Obligatorio.Domain.UsuarioModel;

public class UsuarioServiceImpl extends UnicastRemoteObject implements UsuarioService{
	private static UsuarioServiceImpl instancia;
	private static Map<String,UsuarioModel> mapUsuarios;
	
	protected UsuarioServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static UsuarioServiceImpl Instancia() throws RemoteException {
		if(instancia == null) {
			instancia = new UsuarioServiceImpl();
			mapUsuarios = new HashMap<String,UsuarioModel>();
			mapUsuarios.put("1", new UsuarioModel("mauro","123"));
			mapUsuarios.put("2", new UsuarioModel("matias","123"));
		}		
		return instancia;
	}
	@Override
	public Map<String,UsuarioModel> ListaUsuarios() throws RemoteException {
		return mapUsuarios;
	}
	public String Hola() {
		// TODO Auto-generated method stub
		return null;
	}
}
