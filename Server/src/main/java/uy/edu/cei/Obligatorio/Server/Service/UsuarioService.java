package uy.edu.cei.Obligatorio.Server.Service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import uy.edu.cei.Obligatorio.Domain.UsuarioModel;
import uy.edu.cei.Obligatorio.Server.Impl.Service.UsuarioServiceDataBaseImpl;
import uy.edu.cei.Obligatorio.Server.Impl.Service.UsuarioServiceMemoryImpl;

public interface UsuarioService extends Remote {

	public static final String TYPE = "database";

	public static UsuarioService userServiceFactory() throws RemoteException {
		JPAService.getInstance().getEM();
		UsuarioService usuarioService = null;
		if ("memory".equals(TYPE)) {
			usuarioService = UsuarioServiceMemoryImpl.getInstance();
		} else {
			if ("database".equals(TYPE)) {
				usuarioService = UsuarioServiceDataBaseImpl.getInstancia();
			}
		}
		return usuarioService;
	}

	public List<UsuarioModel> ListaUsuarios() throws RemoteException;

	public UsuarioModel buscarUsuarioPorNombre(String nombre) throws RemoteException;

	public UsuarioModel registrar(String nombre, String contra) throws RemoteException;
}
