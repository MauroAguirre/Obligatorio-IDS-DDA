package uy.edu.cei.Obligatorio.Client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import uy.edu.cei.Obligatorio.Common.Observer;
import uy.edu.cei.Obligatorio.Common.Server.Server;

public class Windows implements Observer {
	
	private LoginController loginController;
	private IntroWindow intro;
	private MenuWindow menu;
	private AltaUsuarioWindow altaUsuario;
	
	public Windows(IntroWindow intro,MenuWindow menu, AltaUsuarioWindow altaUsuario ,LoginController loginController) throws RemoteException  {
		this.loginController = loginController;
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
	
	public void Logear(String usuario, String contra) throws RemoteException {
		if(loginController.VerificarLogeo(usuario,contra)) {
			System.out.println("verdadero");
			menu.Visibilidad(true);
			intro.Visibilidad(false);
		}
		else {
			intro.MensajeError(loginController.Hola());
			System.out.println("falso");
		}	
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
	public boolean RegistrarUsuario() {
		return true;
	}
}
