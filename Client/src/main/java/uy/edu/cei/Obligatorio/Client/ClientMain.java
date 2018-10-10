package uy.edu.cei.Obligatorio.Client;

import java.awt.EventQueue;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import uy.edu.cei.Obligatorio.Client.ui.MainWindow;
import uy.edu.cei.Obligatorio.Client.ui.Panel.LoginPanel;
import uy.edu.cei.Obligatorio.Client.ui.Panel.MainPanel;
import uy.edu.cei.Obligatorio.Client.ui.Panel.RegistryPanel;

public class ClientMain {

	public static void main(String[] args) throws RemoteException, NotBoundException {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//profe tirando fruta
					
					CommClientServer css = CommClientServer.Instancia();
					MainWindow main = new MainWindow();
					main.GetFrame().add(new LoginPanel(main));
					main.GetFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}