package uy.edu.cei.Obligatorio.Client;
import java.rmi.RemoteException;
import java.util.List;

import uy.edu.cei.Obligatorio.Domain.*;

public class LoginController {
	private CommunicationImpl communicationImpl;
	
	public LoginController(CommunicationImpl communicationImpl) {
		this.communicationImpl = communicationImpl;
	}
	public boolean VerificarLogeo(String usuario, String contra) throws RemoteException {
		List<Usuario> usuarios = communicationImpl.DarUsuarios();
		System.out.print(usuario);
		System.out.print(contra);
		for(int i=0;i<usuario.length();i++) {
			if(usuarios.get(i).GetUsuario().equals(usuario) && usuarios.get(i).GetContra().equals(contra) ) 
				return true;
		}
		return false;
	}
	public String Hola() throws RemoteException {
		return this.communicationImpl.Hola();
	}
}
