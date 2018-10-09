package uy.edu.cei.Obligatorio.Client.ui;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uy.edu.cei.Obligatorio.Client.CommClientServer;
import uy.edu.cei.Obligatorio.Client.ui.Panel.LoginPanel;
import uy.edu.cei.Obligatorio.Common.Observer;
import uy.edu.cei.Obligatorio.Domain.UsuarioModel;

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
		frame.add(new LoginPanel());
		frame.setVisible(true);
	}

}
