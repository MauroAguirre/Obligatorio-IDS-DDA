package uy.edu.cei.Obligatorio.Server;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

import javax.persistence.EntityManager;

import uy.edu.cei.Obligatorio.Domain.UsuarioModel;
import uy.edu.cei.Obligatorio.Server.Impl.UsuarioServiceDataBaseImpl;
import uy.edu.cei.Obligatorio.Server.Impl.UsuarioServiceMemoryImpl;

public interface UsuarioService extends Remote {
	
	public static final String TYPE = "database";
	
	public static UsuarioService userServiceFactory(EntityManager entityManager) throws RemoteException {
		UsuarioService usuarioService = null;
		if("memory".equals(TYPE)) {
			usuarioService = UsuarioServiceMemoryImpl.getInstance();
		}
		else {
			if("database".equals(TYPE)) {
				usuarioService = UsuarioServiceDataBaseImpl.getInstancia(entityManager);
			}
		}
		return usuarioService;
	}
	public Map<String,UsuarioModel> ListaUsuarios() throws RemoteException;
	public UsuarioModel buscarUsuarioPorNombre(String nombre) throws RemoteException;
}
