package uy.edu.cei.Obligatorio.Client.ui;

import java.rmi.RemoteException;
import javax.swing.JFrame;
import uy.edu.cei.Obligatorio.Client.ui.Panel.LoginPanel;
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
	
	public void update(GameNotification notification) {
		try {
			LoginPanel loginPanel = (LoginPanel)frame.getComponent(0);
			switch(notification.getType().toString()) {
				case "LOGIN":
					loginPanel.loginError();
					break;
				case "TROW_DICE":
					break;
			}
			Thread.sleep(5000);
			System.out.println("El cliente: "+notification.getCurrentUser()+" quiso: "+notification.getType());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
