package uy.edu.cei.Obligatorio.Common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Observer extends Remote {

	public void update(String message) throws RemoteException;
	public void CambiarMenuRegistro() throws RemoteException;
	public boolean RegistrarUsuario() throws RemoteException;
}
