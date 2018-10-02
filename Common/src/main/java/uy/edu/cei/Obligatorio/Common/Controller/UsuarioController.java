package uy.edu.cei.Obligatorio.Common.Controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import uy.edu.cei.Obligatorio.Domain.UsuarioModel;

public interface UsuarioController extends Remote {
	public UsuarioModel VerificarUsuario(String usuario, String contra) throws RemoteException;
}
