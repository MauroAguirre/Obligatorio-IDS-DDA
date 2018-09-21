package uy.edu.cei.Obligatorio.Client;

import java.awt.EventQueue;

import javax.swing.JFrame;

import uy.edu.cei.Obligatorio.Common.ServerApp;

public class AltaUsuarioWindow {

	private Windows master;
	private JFrame Ventana;

	public AltaUsuarioWindow() {
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
	
	public void initialize() {
		Ventana = new JFrame();
		Ventana.setBounds(100, 100, 450, 300);
		Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Ventana.setVisible(false);
	}

}
