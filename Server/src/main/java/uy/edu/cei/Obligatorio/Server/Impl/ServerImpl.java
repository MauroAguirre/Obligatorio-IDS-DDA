package uy.edu.cei.Obligatorio.Server.Impl;

import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;
import uy.edu.cei.Obligatorio.Domain.UsuarioModel;
import uy.edu.cei.Obligatorio.Common.Observable;
import uy.edu.cei.Obligatorio.Common.Observer;
import uy.edu.cei.Obligatorio.Common.Server.Server;

public class ServerImpl implements Server, Observable {
	
	private UsuarioControllerImpl usuarioControllerImpl;
	private static int clientes;
	private List<Observer> observers;
	private List<UsuarioModel> usuarios;
	
	public int asignarIdACliente() throws RemoteException {
		return ++clientes;
	}
	
	public ServerImpl() throws RemoteException {
		observers = new LinkedList<>();
		usuarios = new LinkedList<>();
		usuarioControllerImpl = new UsuarioControllerImpl(observers);
	}
	
	public UsuarioControllerImpl getUsuarioControllerImpl() throws RemoteException {
		return usuarioControllerImpl;
	}
	
	@Override
	public void subscribe(Observer observer) throws RemoteException {
		System.out.println("Observer agregado");
		this.observers.add(observer);
	}
	
	@Override
	public void sayHello(String name) throws RemoteException {
		System.out.println(String.format("Hola %s", name));
		
		/*
		for(Observer o : this.observers) {
			o.update(String.format("Hola %s", name));
		}*/
	}



	@Override
	public void TestConnection() throws RemoteException {
		System.out.println("Hemos conectado con el server yeahh boooyyyyy");
		
	}


}
