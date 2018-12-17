package uy.edu.cei.Obligatorio.Common.Controller;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

import uy.edu.cei.Obligatorio.Domain.SalaModel;

public interface GameController extends Remote ,Serializable{
	public void tirarDados(int[] dados,boolean[] disponibles,Long tiradorId,Long recibidorId,int turno) throws RemoteException;
	public void lockearJugada(int[] dados,Long tiradorId,Long recibidorId,int jugada) throws RemoteException;
}
