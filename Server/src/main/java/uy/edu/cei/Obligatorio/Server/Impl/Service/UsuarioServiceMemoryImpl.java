package uy.edu.cei.Obligatorio.Server.Impl.Service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import uy.edu.cei.Obligatorio.Domain.UsuarioModel;
import uy.edu.cei.Obligatorio.Server.Service.UsuarioService;

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
	public UsuarioModel registrar(String mauro, String contra) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsuarioModel> ListaUsuarios() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public UsuarioModel buscarUsuarioPorNombre(String nombre) throws RemoteException {
		return this.users.get(nombre);
	}



	@Override
	public UsuarioModel buscarPorId(long id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}







}
