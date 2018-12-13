package uy.edu.cei.Obligatorio.Common.Controller;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GameController extends Remote {
	public void jugar(int jugada) throws RemoteException;
}
