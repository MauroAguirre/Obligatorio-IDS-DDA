package uy.edu.cei.Obligatorio.Server;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

import uy.edu.cei.Obligatorio.Domain.UsuarioModel;

public interface UsuarioService extends Remote {
	public Map<String,UsuarioModel> ListaUsuarios() throws RemoteException;
	public String Hola() throws RemoteException;
}
