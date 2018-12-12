package uy.edu.cei.Obligatorio.Common.Controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import uy.edu.cei.Obligatorio.Domain.UsuarioModel;
import uy.edu.cei.Obligatorio.Domain.RealModel;

public interface RealController extends Remote {
	public List<RealModel> darSalas() throws RemoteException;
	public void crearSala(String nombre,UsuarioModel player, int apuesta) throws RemoteException;
	public void entrarSala(String nombre,UsuarioModel player) throws RemoteException;
	public void entrarSalaPorApuesta(UsuarioModel player,int apuesta) throws RemoteException;
}
