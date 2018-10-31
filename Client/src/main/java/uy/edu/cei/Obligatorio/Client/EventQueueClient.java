package uy.edu.cei.Obligatorio.Client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.sun.javafx.binding.StringFormatter;

import uy.edu.cei.Obligatorio.Client.ui.MainWindow;
import uy.edu.cei.Obligatorio.Common.Observable;
import uy.edu.cei.Obligatorio.Common.Observer;
import uy.edu.cei.Obligatorio.Common.Notifications.GameNotification;
import uy.edu.cei.Obligatorio.Common.Server.Server;
import uy.edu.cei.Obligatorio.Domain.UsuarioModel;

public class EventQueueClient extends UnicastRemoteObject implements Observer{
	
	private static EventQueueClient instancia = null;
	private MainWindow mainWindow;
	private Server server;
	private Queue<GameNotification> queue;
	private int id;
	
	public static EventQueueClient Instancia() throws RemoteException {
		if(instancia == null) 
			instancia = new EventQueueClient();
		return instancia;
	}
	public EventQueueClient() throws RemoteException{
		try {
			this.queue = new LinkedList<>();
			Registry registry = LocateRegistry.getRegistry(1099);
			server= (Server) registry.lookup("server");
			server.TestConnection();
			server.subscribe(this);
			this.initializeThread();
			
		} catch (RemoteException | NotBoundException e) {
			// tirar alguna excepcion para arriba
			e.printStackTrace();
		}
	}
	public Server GetServer() {
		return server;
	}

	public void initializeThread() {
		new Thread(new Runnable() {
			
			public void run() {
				while(true) {
					try {
						do {
							GameNotification n = queue.poll();
							if(n!=null) {
								System.out.println("algo con "+n.getType());
							}
						}while(queue.peek() !=null);
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}).start(); 
	}
	@Override
	public void update(GameNotification notification) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
}
