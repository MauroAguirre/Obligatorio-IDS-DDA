package uy.edu.cei.Obligatorio.Client.ui;

import java.rmi.RemoteException;
import javax.swing.JFrame;
import uy.edu.cei.Obligatorio.Client.ui.Panel.LoginPanel;
import uy.edu.cei.Obligatorio.Client.ui.Panel.RegistryPanel;
import uy.edu.cei.Obligatorio.Common.Notifications.GameNotification;

public class MainWindow{

	private JFrame frame;
	
	public JFrame GetFrame() {
		return frame;
	}

	public MainWindow() throws RemoteException{
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
