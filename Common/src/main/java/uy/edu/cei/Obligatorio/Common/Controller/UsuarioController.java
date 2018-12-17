package uy.edu.cei.Obligatorio.Common.Controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import uy.edu.cei.Obligatorio.Domain.UsuarioModel;

public interface UsuarioController extends Remote {
	public void verificarUsuario(String usuario, String contra,Long id) throws RemoteException;
	public void agregarUsuario(String usuario,String contra,int avatar,Long id) throws RemoteException;
	public List<UsuarioModel> listaUsuarios() throws RemoteException;
	public List<UsuarioModel> listaVictorias() throws RemoteException;
	public List<UsuarioModel> listaPuntos() throws RemoteException;
	public List<UsuarioModel> listaReales() throws RemoteException;
	public List<UsuarioModel> listaVirtuales() throws RemoteException;
	public UsuarioModel buscarUsuarioPorId(Long id) throws RemoteException;
	public void modificarUsuario(Long idUsuario,String usuario,String contra,int avatar,Long id) throws RemoteException;
}
