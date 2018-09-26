package uy.edu.cei.Obligatorio.Client;

import java.awt.EventQueue;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import uy.edu.cei.Obligatorio.Common.Observable;
import uy.edu.cei.Obligatorio.Common.Server.Server;

public class ClientMain {

	public static void main(String[] args) throws RemoteException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry(1099);
		Server server= (Server) registry.lookup("server");
		CommunicationImpl communicationImpl = new CommunicationImpl(server);
		LoginController loginController = new LoginController(communicationImpl);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					/*
					ChatWindow window = new ChatWindow(serverApp);
					System.out.println("Ventana");
					((Observable) serverApp).subscribe(window);
					System.out.println("suscribir");
					serverApp.sayHello("me quiero matar");*/
					
					IntroWindow probando = new IntroWindow();
					MenuWindow menu = new MenuWindow();
					AltaUsuarioWindow altaUsuario = new AltaUsuarioWindow();
					//((Observable) serverApp).subscribe(probando);
					//((Observable) serverApp).subscribe(menu);
					
					Windows ventanas = new Windows(probando,menu,altaUsuario,loginController);
					((Observable) server).subscribe(ventanas);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}