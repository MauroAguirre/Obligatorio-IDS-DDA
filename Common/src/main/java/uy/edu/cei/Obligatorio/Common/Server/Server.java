package uy.edu.cei.Obligatorio.Common.Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import uy.edu.cei.Obligatorio.Domain.Usuario;

public interface Server extends Remote {
	public void sayHello(String name) throws RemoteException;
	public void IrMenuRegistrar() throws RemoteException;
	public boolean RegistrarUsuario() throws RemoteException;
	public List<Usuario> ListaUsuarios() throws RemoteException;
	public String Hola() throws RemoteException;
}