package uy.edu.cei.Obligatorio.Client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;

import uy.edu.cei.Obligatorio.Client.ui.MainWindow;
import uy.edu.cei.Obligatorio.Common.Observable;
import uy.edu.cei.Obligatorio.Common.Observer;
import uy.edu.cei.Obligatorio.Common.Server.Server;
import uy.edu.cei.Obligatorio.Domain.UsuarioModel;

public class CommClientServer extends UnicastRemoteObject implements Observer{
	private List<Observer> observers;
	private static CommClientServer instancia = null;
	private Server server;
	
	public static CommClientServer Instancia() throws RemoteException {
		if(instancia == null)
			instancia = new CommClientServer();
		return instancia;
	}
	public CommClientServer() throws RemoteException{
		try {
			this.observers = new LinkedList<>();
			Registry registry = LocateRegistry.getRegistry(1099);
			server= (Server) registry.lookup("server");
			server.TestConnection();
			server.subscribe(this);
			
		} catch (RemoteException | NotBoundException e) {
			// tirar alguna excepcion para arriba
			e.printStackTrace();
		}
	}
	public Server GetServer() {
		return server;
	}
	@Override
	public void update(String message) throws RemoteException {
		try {
			Thread.sleep(4000);
			System.out.println("message");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//JOptionPane.showMessageDialog(frame.getComponent(0), "Encontrado", "Bien", 0);
	}

	@Override
	public void CambiarMenuRegistro() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean RegistrarUsuario() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
}
