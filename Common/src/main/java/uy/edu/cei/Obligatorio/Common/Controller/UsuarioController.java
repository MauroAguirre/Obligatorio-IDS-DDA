package uy.edu.cei.Obligatorio.Common.Controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import uy.edu.cei.Obligatorio.Domain.UsuarioModel;

public interface UsuarioController extends Remote {
	public void verificarUsuario(String usuario, String contra,Long id) throws RemoteException;
	public UsuarioModel agregarUsuario(String usuario,String contra,int avatar) throws RemoteException;
	public List<UsuarioModel> listaUsuarios() throws RemoteException;
	public UsuarioModel buscarUsuarioPorId(Long id) throws RemoteException;
	public UsuarioModel modificarUsuario(String usuario,String contra,int avatar) throws RemoteException;
}
