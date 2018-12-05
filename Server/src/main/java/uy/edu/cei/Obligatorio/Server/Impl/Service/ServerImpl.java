package uy.edu.cei.Obligatorio.Server.Impl.Service;

import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import uy.edu.cei.Obligatorio.Domain.RealModel;
import uy.edu.cei.Obligatorio.Domain.RegistroModel;
import uy.edu.cei.Obligatorio.Domain.UsuarioModel;
import uy.edu.cei.Obligatorio.Server.Impl.Model.RealControllerImpl;
import uy.edu.cei.Obligatorio.Server.Impl.Model.UsuarioControllerImpl;
import uy.edu.cei.Obligatorio.Server.Service.JPAService;
import uy.edu.cei.Obligatorio.Common.Observable;
import uy.edu.cei.Obligatorio.Common.Observer;
import uy.edu.cei.Obligatorio.Common.Controller.RealController;
import uy.edu.cei.Obligatorio.Common.Server.Server;

public class ServerImpl implements Server, Observable {
	
	private UsuarioControllerImpl usuarioControllerImpl;
	private RealControllerImpl realControllerImpl;
	private List<Observer> observers;
	private List<RealModel> salasReales;
	private long ultimaId;
	
	public ServerImpl() throws RemoteException {
		ultimaId=0;
		observers = new LinkedList<>();
		usuarioControllerImpl = new UsuarioControllerImpl(observers);
		realControllerImpl = new RealControllerImpl(observers);
		salasReales = new LinkedList<>();
	}
	
	public UsuarioControllerImpl getUsuarioControllerImpl() throws RemoteException {
		return usuarioControllerImpl;
	}
	
	public RealControllerImpl getRealControllerImpl() throws RemoteException {
		return realControllerImpl;
	}
	
	public long subscribe(Observer observer) throws RemoteException {
		System.out.println("Observer agregado");
		this.observers.add(observer);
		ultimaId--;
		return ultimaId;
	}

	public void TestConnection() throws RemoteException {
		System.out.println("Hemos conectado con el server yeahh boooyyyyy");
		
	}



}
