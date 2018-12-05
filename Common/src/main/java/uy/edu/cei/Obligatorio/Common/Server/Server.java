package uy.edu.cei.Obligatorio.Common.Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import uy.edu.cei.Obligatorio.Domain.UsuarioModel;
import uy.edu.cei.Obligatorio.Common.Observable;
import uy.edu.cei.Obligatorio.Common.Controller.RealController;
import uy.edu.cei.Obligatorio.Common.Controller.UsuarioController;

public interface Server extends Remote,Observable {
	public void TestConnection() throws RemoteException;
	public UsuarioController getUsuarioControllerImpl() throws RemoteException;
	public RealController getRealControllerImpl() throws RemoteException;
}