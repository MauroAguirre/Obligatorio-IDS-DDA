package uy.edu.cei.Obligatorio.Common.Controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import uy.edu.cei.Obligatorio.Domain.UsuarioModel;

public interface UsuarioController extends Remote {
	public void verificarUsuario(String usuario, String contra,long id) throws RemoteException;
	public UsuarioModel agregarUsuario(String usuario,String contra) throws RemoteException;
	public List<UsuarioModel> ListaUsuarios() throws RemoteException;
}
