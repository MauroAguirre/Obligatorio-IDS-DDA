package uy.edu.cei.Obligatorio.Server;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

import uy.edu.cei.Obligatorio.Domain.UsuarioModel;
import uy.edu.cei.Obligatorio.Server.Impl.UsuarioServiceMemoryImpl;

public interface UsuarioService extends Remote {
	
	public static final String TYPE = "memory";
	
	public static UsuarioService userServiceFactory() throws RemoteException {
		UsuarioService usuarioService = null;
		if("memory".equals(TYPE)) {
			usuarioService = UsuarioServiceMemoryImpl.Instancia();
		}
		else {
			if("database".equals(TYPE)) {
				//proximamente
			}
		}
		return usuarioService;
	}
	public Map<String,UsuarioModel> ListaUsuarios() throws RemoteException;
	/**
	 * Vamo vamo vamo
	 * @param nombre
	 * @return UsuarioModel
	 */
	public UsuarioModel buscarUsuarioPorNombre(String nombre) throws RemoteException;
}
