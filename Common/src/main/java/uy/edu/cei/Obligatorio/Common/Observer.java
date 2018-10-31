package uy.edu.cei.Obligatorio.Common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import uy.edu.cei.Obligatorio.Common.Notifications.GameNotification;

public interface Observer extends Remote {
	public void update(GameNotification notification) throws RemoteException;
}
