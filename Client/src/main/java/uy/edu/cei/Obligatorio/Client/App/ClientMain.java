package uy.edu.cei.Obligatorio.Client.App;

import java.awt.EventQueue;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import uy.edu.cei.Obligatorio.Client.ui.MainWindow;
import uy.edu.cei.Obligatorio.Client.ui.Panel.LoginPanel;

public class ClientMain {

	public static void main(String[] args) throws RemoteException, NotBoundException {
		System.setProperty("java.security.policy", "file:C:\\java.policy");
		System.setSecurityManager(new SecurityManager());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {	
					MainWindow main = MainWindow.getInstancia();
					main.cambiarVentana("login");
					//main.cambiarVentana("main");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}