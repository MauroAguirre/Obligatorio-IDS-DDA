package uy.edu.cei.Obligatorio.Common.Controller;

import java.rmi.Remote;
import java.rmi.RemoteException;

import uy.edu.cei.Obligatorio.Domain.UsuarioModel;

public interface RealController extends Remote {
	public void crearSala(String nombre,UsuarioModel player, int apuesta) throws RemoteException;
	public void entrarSala(String nombre,UsuarioModel player) throws RemoteException;
}
