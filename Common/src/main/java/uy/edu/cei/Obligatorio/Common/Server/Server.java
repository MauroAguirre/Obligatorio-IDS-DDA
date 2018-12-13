package uy.edu.cei.Obligatorio.Common.Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import uy.edu.cei.Obligatorio.Domain.UsuarioModel;
import uy.edu.cei.Obligatorio.Common.Observable;
import uy.edu.cei.Obligatorio.Common.Controller.GameController;
import uy.edu.cei.Obligatorio.Common.Controller.RealController;
import uy.edu.cei.Obligatorio.Common.Controller.RegistroController;
import uy.edu.cei.Obligatorio.Common.Controller.UsuarioController;
import uy.edu.cei.Obligatorio.Common.Controller.VirtualController;

public interface Server extends Remote,Observable {
	public void testConnection() throws RemoteException;
	public UsuarioController getUsuarioControllerImpl() throws RemoteException;
	public RealController getRealControllerImpl() throws RemoteException;
	public VirtualController getVirtualControllerImpl() throws RemoteException;
	public GameController getGameControllerImpl() throws RemoteException;
	public RegistroController getRegistroControllerImpl() throws RemoteException;
}