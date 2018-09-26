package uy.edu.cei.Obligatorio.Client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import uy.edu.cei.Obligatorio.Common.Communication;
import uy.edu.cei.Obligatorio.Common.Server.Server;
import uy.edu.cei.Obligatorio.Domain.Usuario;

public class CommunicationImpl extends UnicastRemoteObject implements Communication{
	/**
	 * 
	 */
	private Server server;
	
	public CommunicationImpl(Server server) throws RemoteException {
		this.server = server;
	}

	public List<Usuario> DarUsuarios() throws RemoteException {
		return server.ListaUsuarios();
	}
	public String Hola() throws RemoteException {
		return server.Hola();
	}
}
