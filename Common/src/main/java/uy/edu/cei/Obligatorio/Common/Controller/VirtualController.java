package uy.edu.cei.Obligatorio.Common.Controller;

import java.rmi.RemoteException;
import java.util.List;

import uy.edu.cei.Obligatorio.Domain.RealModel;
import uy.edu.cei.Obligatorio.Domain.UsuarioModel;

public interface VirtualController {
	public List<RealModel> darSalas() throws RemoteException;
	public void crearSala(String nombre,UsuarioModel player, int apuesta) throws RemoteException;
	public void entrarSala(String nombre,UsuarioModel player) throws RemoteException;
}
