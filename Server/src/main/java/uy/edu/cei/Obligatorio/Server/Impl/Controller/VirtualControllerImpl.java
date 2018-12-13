package uy.edu.cei.Obligatorio.Server.Impl.Controller;

import java.rmi.RemoteException;
import java.util.List;

import uy.edu.cei.Obligatorio.Common.Observer;
import uy.edu.cei.Obligatorio.Common.Controller.VirtualController;
import uy.edu.cei.Obligatorio.Domain.RealModel;
import uy.edu.cei.Obligatorio.Domain.UsuarioModel;
import uy.edu.cei.Obligatorio.Domain.VirtualModel;

public class VirtualControllerImpl implements VirtualController {

	private List<Observer> observers;
	private List<VirtualModel> salasVirtuales;
	
	public VirtualControllerImpl(List<Observer> observers, List<VirtualModel> salasVirtuales) {
		this.observers = observers;
		this.salasVirtuales = salasVirtuales;
	}

	@Override
	public List<RealModel> darSalas() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crearSala(String nombre, UsuarioModel player, int apuesta) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void entrarSala(String nombre, UsuarioModel player) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
