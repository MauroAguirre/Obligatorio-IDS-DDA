package uy.edu.cei.Obligatorio.Server.Impl.Controller;

import java.rmi.RemoteException;
import java.util.List;

import uy.edu.cei.Obligatorio.Common.Observer;
import uy.edu.cei.Obligatorio.Common.Controller.GameController;

public class GameControllerImpl implements GameController {

	private List<Observer> observers;
	
	public GameControllerImpl(List<Observer> observers) {
		this.observers = observers;
	}

	@Override
	public void jugar(int jugada) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
