package uy.edu.cei.Obligatorio.Common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerApp extends Remote {
	public void sayHello(String name) throws RemoteException;
	public void IrMenuRegistrar() throws RemoteException;
}