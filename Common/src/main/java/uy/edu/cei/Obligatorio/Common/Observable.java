package uy.edu.cei.Obligatorio.Common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Observable extends Remote {

	public void subscribe(Observer observer) throws RemoteException;

}