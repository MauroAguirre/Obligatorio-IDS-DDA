package uy.edu.cei.Obligatorio.Client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import uy.edu.cei.Obligatorio.Common.Observer;
import uy.edu.cei.Obligatorio.Common.ServerApp;

public class Windows extends UnicastRemoteObject implements Observer {
	
	private ServerApp server;
	private IntroWindow intro;
	private MenuWindow menu;
	private AltaUsuarioWindow altaUsuario;
	
	public Windows(IntroWindow intro,MenuWindow menu, AltaUsuarioWindow altaUsuario ) throws RemoteException  {
		this.intro = intro;
		this.menu = menu;
		this.altaUsuario = altaUsuario;
		intro.AgregarMaster(this);
		menu.AgregarMaster(this);
		altaUsuario.AgregarMaster(this);
	}
	
	public MenuWindow DarMenu() {
		return menu;
	}
	public IntroWindow DarIntro() {
		return intro;
	}

	@Override
	public void update(String message) throws RemoteException {
		intro.update("dsad");
		menu.update("dasd");
	}

	@Override
	public void CambiarMenuRegistro() throws RemoteException {
		intro.Visibilidad(false);
		altaUsuario.Visibilidad(true);
	}
}
