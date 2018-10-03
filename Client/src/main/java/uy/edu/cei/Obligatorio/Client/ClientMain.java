package uy.edu.cei.Obligatorio.Client;

import java.awt.EventQueue;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import uy.edu.cei.Obligatorio.Client.ui.MainWindow;
import uy.edu.cei.Obligatorio.Client.ui.Panel.LoginPanel;
import uy.edu.cei.Obligatorio.Common.Observable;
import uy.edu.cei.Obligatorio.Common.Server.Server;

public class ClientMain {

	public static void main(String[] args) throws RemoteException, NotBoundException {
		
		/*
		Registry registry = LocateRegistry.getRegistry(1099);
		Server server= (Server) registry.lookup("server");
		
		CommunicationImpl communicationImpl = new CommunicationImpl(server);
		LoginController loginController = new LoginController(communicationImpl);*/
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//profe tirando fruta
					
					CommClientServer css = CommClientServer.Instancia();
					MainWindow main = new MainWindow();
					//
					/*
					IntroWindow probando = new IntroWindow();
					MenuWindow menu = new MenuWindow();
					AltaUsuarioWindow altaUsuario = new AltaUsuarioWindow();
					Windows ventanas = new Windows(probando,menu,altaUsuario,loginController);
					((Observable) server).subscribe(ventanas);*/
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}