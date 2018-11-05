package uy.edu.cei.Obligatorio.Client.Controller;

import javax.swing.JFrame;

import uy.edu.cei.Obligatorio.Client.ui.Panel.LoginPanel;
import uy.edu.cei.Obligatorio.Client.ui.Panel.MainPanel;
import uy.edu.cei.Obligatorio.Common.Notifications.GameNotification;

public class LoginController{
	
	public JFrame frame;
	public LoginController(){
	}
	
	public void Verificar(JFrame frame,GameNotification gn) {
		Object o = frame.getContentPane();
		if(o instanceof LoginPanel) {
			LoginPanel lp = (LoginPanel)o;
			switch(gn.getAction()) {
				case LOG:
					frame.setContentPane(new MainPanel());
					break;
				case ERROR:
					lp.loginError();
					break;
				default :
					break;
			}
		}
	} 
}
