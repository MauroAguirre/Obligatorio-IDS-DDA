package uy.edu.cei.Obligatorio.Client.ui;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uy.edu.cei.Obligatorio.Client.EventQueueClient;
import uy.edu.cei.Obligatorio.Client.ui.Panel.LoginPanel;
import uy.edu.cei.Obligatorio.Common.Observer;
import uy.edu.cei.Obligatorio.Common.Notifications.GameNotification;
import uy.edu.cei.Obligatorio.Domain.UsuarioModel;

public class MainWindow implements Observer{

	private JFrame frame;
	private int id;
	
	public void setId(int id) {
		this.id = id;
	}
	
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
			Thread.sleep(5000);
			System.out.println("El cliente: "+notification.getCurrentUser()+" quiso: "+notification.getType());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int getId() {
		return id;
	}

}
