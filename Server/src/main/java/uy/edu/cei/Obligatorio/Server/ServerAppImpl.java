package uy.edu.cei.Obligatorio.Server;

import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

import uy.edu.cei.Obligatorio.Common.Observable;
import uy.edu.cei.Obligatorio.Common.Observer;
import uy.edu.cei.Obligatorio.Common.ServerApp;

public class ServerAppImpl implements ServerApp, Observable {
	
	private List<Observer> observers;
	
	public ServerAppImpl() {
		this.observers = new LinkedList<Observer>();
	}
	
	@Override
	public void subscribe(Observer observer) throws RemoteException {
		System.out.println("agrego observer");
		this.observers.add(observer);
		System.out.println("termine agregar observer");
	}
	
	@Override
	public void sayHello(String name) throws RemoteException {
		System.out.println(String.format("Hola %s", name));
		// this.observers.forEach((o) -> o.update(String.format("Hola %s", name)));
		for(Observer o : this.observers) {
			o.update(String.format("Hola %s", name));
		}
	}

	@Override
	public void IrMenuRegistrar() throws RemoteException {
		for(Observer o : this.observers) {
			o.CambiarMenuRegistro();
		}
	}
	
}
