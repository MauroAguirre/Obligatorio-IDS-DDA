package uy.edu.cei.Obligatorio.Server.Impl;

import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import uy.edu.cei.Obligatorio.Domain.RegistroModel;
import uy.edu.cei.Obligatorio.Domain.UsuarioModel;
import uy.edu.cei.Obligatorio.Common.Observable;
import uy.edu.cei.Obligatorio.Common.Observer;
import uy.edu.cei.Obligatorio.Common.Server.Server;

public class ServerImpl implements Server, Observable {
	
	private UsuarioControllerImpl usuarioControllerImpl;
	private static int clientes;
	private List<Observer> observers;
	public int asignarIdACliente() throws RemoteException {
		return ++clientes;
	}
	
	public ServerImpl() throws RemoteException {
		observers = new LinkedList<>();
		new LinkedList<>();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaDS");
		EntityManager em = emf.createEntityManager(); 
		
		usuarioControllerImpl = new UsuarioControllerImpl(observers,em);
		//ingresar
		em.getTransaction().begin();
		UsuarioModel u = new UsuarioModel("mauro","123");
		RegistroModel r1 = new RegistroModel("kakaroto");
		RegistroModel r2 = new RegistroModel("ponele sabor");
		em.persist(u);
		u.getRegistros().add(r1);
		u.getRegistros().add(r2);
		em.getTransaction().commit();
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
