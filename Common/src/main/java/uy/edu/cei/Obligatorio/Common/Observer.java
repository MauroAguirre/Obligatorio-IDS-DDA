package uy.edu.cei.Obligatorio.Common;

import java.rmi.Remote;
import java.rmi.RemoteException;

import uy.edu.cei.Obligatorio.Common.Notifications.GameNotification;

public interface Observer extends Remote {
	public void update(GameNotification notification) throws RemoteException;
}
