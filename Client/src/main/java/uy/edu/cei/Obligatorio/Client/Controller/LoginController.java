package uy.edu.cei.Obligatorio.Client.Controller;

import java.rmi.RemoteException;

import uy.edu.cei.Obligatorio.Client.App.EventQueueClient;
import uy.edu.cei.Obligatorio.Client.ui.MainWindow;
import uy.edu.cei.Obligatorio.Client.ui.Panel.GeneralaPanel;
import uy.edu.cei.Obligatorio.Client.ui.Panel.LoginPanel;
import uy.edu.cei.Obligatorio.Common.Controller.UsuarioController;
import uy.edu.cei.Obligatorio.Common.Notifications.GameNotification;

public class LoginController implements MasterController {
	
	private static LoginController instancia;
	private static LoginPanel panel;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static LoginController getInstancia() {
		if(instancia == null) {
			instancia = new LoginController();
			panel = new LoginPanel();
			panel.getLblRespuesta().setText("");
		}
		return instancia;
	}
	
	public LoginPanel darPanel() {
		return panel;
	}
	
	public void IntentarLogear() {
		try {
			String nombre = panel.getTextUsuario().getText();
			String contra= new String(panel.getPasswordContra().getPassword());
			EventQueueClient css = EventQueueClient.Instancia();
			UsuarioController uci = css.GetServer().getUsuarioControllerImpl();
			uci.verificarUsuario(nombre, contra,css.getId());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void respuesta(GameNotification gn) {
		MainWindow mainWindow = MainWindow.getInstancia();
		switch(gn.getType()) {
			case LOGIN_SUCCES:
				/*
				EventQueueClient css = EventQueueClient.Instancia();
				css.setId(gn.getDato());
				mainWindow.cambiarVentana("main");
				*/
				panel.setModificable(false);
				new Thread(new Runnable() {
					public void run() {
						int contador=0;
						while(contador<100) {
							try {
								panel.getLblLogin().setBounds(284, 60-(contador*1), 60, 23);
								panel.getLblLogin().repaint();
								panel.getLblUsuario().setBounds(140-(contador*4), 153, 83, 23);
								panel.getLblUsuario().repaint();
								panel.getTextUsuario().setBounds(343+(contador*4), 152, 175, 24);
								panel.getTextUsuario().repaint();
								panel.getLblContrasea().setBounds(116-(contador*4), 237, 107, 30);
								panel.getLblContrasea().repaint();
								panel.getPasswordContra().setBounds(343+(contador*4), 240, 175, 23);
								panel.getPasswordContra().repaint();
								panel.getBtnEntrar().setBounds(134, 357+(contador*2), 89, 23);
								panel.getBtnEntrar().repaint();
								panel.getBtnSalir().setBounds(343, 357+(contador*2), 89, 23);
								panel.getBtnSalir().repaint();
								panel.getLblRespuesta().setBounds(211, 301+(contador*2), 175, 23);
								panel.getLblRespuesta().repaint();
								//lblRespuesta.setBounds(211, 301, 175, 23);
								contador++;
								Thread.sleep(25);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						try {
							EventQueueClient css = EventQueueClient.Instancia();
							css.setId(gn.getDato());
							mainWindow.cambiarVentana("main");
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				}).start(); 
				break;
			case LOGIN_ERROR:
				panel.getLblRespuesta().setText("Error en los datos");
				break;
			default :
				break;
		}
	}
	public void intro() {
		panel.setModificable(false);
		new Thread(new Runnable() {
			public void run() {
				int contador=0;
				while(contador<100) {
					try {
						panel.getLblLogin().setBounds(284, -40+(contador*1), 60, 23);
						panel.getLblLogin().repaint();
						panel.getLblUsuario().setBounds(-260+(contador*4), 153, 83, 23);
						panel.getLblUsuario().repaint();
						panel.getTextUsuario().setBounds(743-(contador*4), 152, 175, 24);
						panel.getTextUsuario().repaint();
						panel.getLblContrasea().setBounds(-284+(contador*4), 237, 107, 30);
						panel.getLblContrasea().repaint();
						panel.getPasswordContra().setBounds(743-(contador*4), 240, 175, 23);
						panel.getPasswordContra().repaint();
						panel.getBtnEntrar().setBounds(134, 557-(contador*2), 89, 23);
						panel.getBtnEntrar().repaint();
						panel.getBtnSalir().setBounds(343, 557-(contador*2), 89, 23);
						panel.getBtnSalir().repaint();
						panel.getLblRespuesta().setBounds(211, 501-(contador*2), 175, 23);
						panel.getLblRespuesta().repaint();
						contador++;
						Thread.sleep(25);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				panel.setModificable(true);
			}
		}).start(); 
	}

}
