package uy.edu.cei.Obligatorio.Client.App;

import java.awt.EventQueue;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import uy.edu.cei.Obligatorio.Client.ui.MainWindow;
import uy.edu.cei.Obligatorio.Client.ui.Panel.LoginPanel;

public class ClientMain {

	public static void main(String[] args) throws RemoteException, NotBoundException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {	
					EventQueueClient css = EventQueueClient.Instancia();
					MainWindow main = new MainWindow();
					css.setMainWindow(main);
					main.getFrame().setContentPane(new LoginPanel());
					main.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}