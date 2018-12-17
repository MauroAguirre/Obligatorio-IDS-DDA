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
import uy.edu.cei.Obligatorio.Domain.VirtualModel;
import uy.edu.cei.Obligatorio.Server.Impl.Controller.GameControllerImpl;
import uy.edu.cei.Obligatorio.Server.Impl.Controller.RealControllerImpl;
import uy.edu.cei.Obligatorio.Server.Impl.Controller.RegistroControllerImpl;
import uy.edu.cei.Obligatorio.Server.Impl.Controller.UsuarioControllerImpl;
import uy.edu.cei.Obligatorio.Server.Impl.Controller.VirtualControllerImpl;
import uy.edu.cei.Obligatorio.Server.Service.JPAService;
import uy.edu.cei.Obligatorio.Common.Observable;
import uy.edu.cei.Obligatorio.Common.Observer;
import uy.edu.cei.Obligatorio.Common.Controller.GameController;
import uy.edu.cei.Obligatorio.Common.Controller.RealController;
import uy.edu.cei.Obligatorio.Common.Controller.RegistroController;
import uy.edu.cei.Obligatorio.Common.Controller.VirtualController;
import uy.edu.cei.Obligatorio.Common.Server.Server;

public class ServerImpl implements Server, Observable {
	
	private UsuarioControllerImpl usuarioControllerImpl;
	private RealControllerImpl realControllerImpl;
	private VirtualControllerImpl virtualControllerImpl;
	private GameControllerImpl gameControllerImpl;
	private RegistroControllerImpl registroControllerImpl;
	private List<Observer> observers;
	private List<RealModel> salasReales;
	private List<VirtualModel> salasVirtuales;
	private long ultimaId;
	
	public ServerImpl() throws RemoteException {
		ultimaId=0;
		observers = new LinkedList<>();
		salasReales = new LinkedList<>();
		salasVirtuales = new LinkedList<>();
		usuarioControllerImpl = new UsuarioControllerImpl(observers);
		realControllerImpl = new RealControllerImpl(observers,salasReales);
		virtualControllerImpl = new VirtualControllerImpl(observers,salasVirtuales);
		gameControllerImpl = new GameControllerImpl(observers,salasReales,salasVirtuales);
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

	public void testConnection() throws RemoteException {
		System.out.println("Hemos conectado con el server yeahh boooyyyyy");
		
	}

	@Override
	public VirtualControllerImpl getVirtualControllerImpl() throws RemoteException {
		return this.virtualControllerImpl;
	}

	@Override
	public GameControllerImpl getGameControllerImpl() throws RemoteException {
		return this.gameControllerImpl;
	}

	@Override
	public RegistroControllerImpl getRegistroControllerImpl() throws RemoteException {
		return this.registroControllerImpl;
	}



}
