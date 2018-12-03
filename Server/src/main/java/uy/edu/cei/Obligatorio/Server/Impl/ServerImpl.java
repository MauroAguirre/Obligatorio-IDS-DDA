package uy.edu.cei.Obligatorio.Server.Impl;

import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import uy.edu.cei.Obligatorio.Domain.RegistroModel;
import uy.edu.cei.Obligatorio.Domain.UsuarioModel;
import uy.edu.cei.Obligatorio.Server.Service.JPAService;
import uy.edu.cei.Obligatorio.Common.Observable;
import uy.edu.cei.Obligatorio.Common.Observer;
import uy.edu.cei.Obligatorio.Common.Server.Server;

public class ServerImpl implements Server, Observable {
	
	private UsuarioControllerImpl usuarioControllerImpl;
	private List<Observer> observers;
	private long ultimaId;
	
	public ServerImpl() throws RemoteException {
		ultimaId=0;
		observers = new LinkedList<>();
		new LinkedList<>();
		usuarioControllerImpl = new UsuarioControllerImpl(observers);
		//ingresar
	
		//modificar 
		/*
		em.getTransaction().begin();
		UsuarioModel modificado = em.merge(u);
		modificado.SetUsuario("laura");
		em.persist(modificado);
		em.getTransaction().commit();
		*/
		//consulta
		/*
		UsuarioModel traido = em.find(UsuarioModel.class, 1L);
		System.out.println(traido.GetUsuario()+" - "+traido.GetContra());
		//consulta personalizada
		TypedQuery<UsuarioModel> query = em.createNamedQuery("UsuarioModel.UserFindByUserName",UsuarioModel.class);
		query.setParameter("usuario","pepe");
		UsuarioModel usuQuery = query.getSingleResult();
		*/
	}
	
	public UsuarioControllerImpl getUsuarioControllerImpl() throws RemoteException {
		return usuarioControllerImpl;
	}
	
	@Override
	public long subscribe(Observer observer) throws RemoteException {
		System.out.println("Observer agregado");
		this.observers.add(observer);
		ultimaId--;
		return ultimaId;
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
