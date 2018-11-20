package uy.edu.cei.Obligatorio.Client.App;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JFrame;

import uy.edu.cei.Obligatorio.Client.Controller.LoginController;
import uy.edu.cei.Obligatorio.Client.ui.MainWindow;
import uy.edu.cei.Obligatorio.Client.ui.Panel.LoginPanel;
import uy.edu.cei.Obligatorio.Client.ui.Panel.RegistryPanel;
import uy.edu.cei.Obligatorio.Common.Observer;
import uy.edu.cei.Obligatorio.Common.Notifications.GameNotification;
import uy.edu.cei.Obligatorio.Common.Server.Server;

public class EventQueueClient extends UnicastRemoteObject implements Observer{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static EventQueueClient instancia = null;
	private MainWindow mainWindow;
	private Server server;
	private Queue<GameNotification> queue;
	private int id;
	private LoginController loginController;
	
	public void setMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}
	public MainWindow getMainWindow() {
		return this.mainWindow;
	}
	public int getId() {
		return id;
	}
	
	public static EventQueueClient Instancia() throws RemoteException {
		if(instancia == null) 
			instancia = new EventQueueClient();
		return instancia;
	}
	public EventQueueClient() throws RemoteException{
		try {
			loginController = new LoginController();
			this.queue = new LinkedList<>();
			Registry registry = LocateRegistry.getRegistry(1099);
			server= (Server) registry.lookup("server");
			server.TestConnection();
			server.subscribe(this);
			id=server.asignarIdACliente();
			System.out.println("Cliente id: "+id);
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
						e.printStackTrace();
					}
				}
			}
			
		}).start(); 
	}
	@Override
	public void update(GameNotification notification) {
		switch(notification.getType()) {
			case LOGIN:
				loginController.Verificar(mainWindow.getFrame(),notification);
				break;
			case REGISTRY:
				break;
			default:
				break;
		}
		//Thread.sleep(5000);
		System.out.println("El cliente: "+notification.getId()+" quiso: "+notification.getType());
	}
	
}
