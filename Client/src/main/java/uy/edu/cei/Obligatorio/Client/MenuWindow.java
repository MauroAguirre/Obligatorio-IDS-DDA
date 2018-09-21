package uy.edu.cei.Obligatorio.Client;

import java.awt.EventQueue;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JFrame;

import uy.edu.cei.Obligatorio.Common.Observer;
import uy.edu.cei.Obligatorio.Common.ServerApp;

public class MenuWindow {

	private Windows master;
	private JFrame Ventana;

	public MenuWindow() {
		initialize();
	}
	
	public void AgregarMaster(Windows master) {
		this.master = master;
	}
	
	public void Visibilidad(boolean res) {
		if(res)
			Ventana.setVisible(true);
		else
			Ventana.setVisible(false);
	}
	
	public void update(String message) {
		Ventana.setVisible(false);
		Ventana.setVisible(true);
	}
	
	private void initialize() {
		Ventana = new JFrame();
		Ventana.setBounds(100, 100, 450, 300);
		Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Ventana.setVisible(false);
	}

}
