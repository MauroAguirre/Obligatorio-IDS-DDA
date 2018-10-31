package uy.edu.cei.Obligatorio.Common.Controller;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UsuarioController extends Remote {
	public void VerificarUsuario(String usuario, String contra) throws RemoteException;
}
