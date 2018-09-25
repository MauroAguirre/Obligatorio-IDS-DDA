package uy.edu.cei.Obligatorio.Common.Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Server extends Remote {
	public void sayHello(String name) throws RemoteException;
	public void IrMenuRegistrar() throws RemoteException;
	public boolean RegistrarUsuario() throws RemoteException;
}