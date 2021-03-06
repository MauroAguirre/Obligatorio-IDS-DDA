package uy.edu.cei.Obligatorio.Client.App;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JFrame;

import uy.edu.cei.Obligatorio.Client.Controller.GameController;
import uy.edu.cei.Obligatorio.Client.Controller.LoginController;
import uy.edu.cei.Obligatorio.Client.Controller.RealPanelController;
import uy.edu.cei.Obligatorio.Client.Controller.RegistryController;
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
	private Server server;
	private Queue<GameNotification> queue;
	private long id;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
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
			server.testConnection();
			id = server.subscribe(this);
			this.initializeThread();
			System.out.println(id);
		} catch (RemoteException | NotBoundException e) {
			// tirar alguna excepcion para arriba
			e.printStackTrace();
		}
	}
	public Server getServer() {
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
			case LOGIN_SUCCES:
			case LOGIN_ERROR:
				LoginController loginController = LoginController.getInstancia();
				loginController.respuesta(notification);
				break;
			case REAL_NAMETAKEN:
			case REAL_CREATED:
			case REAL_MATCHNOTFOUND:
			case REAL_MATCHSTART:
				RealPanelController realController = RealPanelController.getInstancia();
				realController.respuesta(notification);
				break;
			case USER_CREATED:
			case USER_CREATEDERROR:
			case USER_MODIFY:
				RegistryController rc = RegistryController.getInstancia();
				rc.respuesta(notification);
				break;
			case DICE_PUSH:
			case DICE_PULL:
			case DICE_SELECTED:
			case YOUR_TURN:
				GameController gc = GameController.getInstancia();
				gc.respuesta(notification);
				break;
			default:
				break;
		}	
	}
	
}
