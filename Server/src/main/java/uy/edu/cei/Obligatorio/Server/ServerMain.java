package uy.edu.cei.Obligatorio.Server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import uy.edu.cei.Obligatorio.Common.Server.Server;
import uy.edu.cei.Obligatorio.Domain.UsuarioModel;
import uy.edu.cei.Obligatorio.Server.Impl.ServerImpl;

/**
 * Hello world!
 *
 */
public class ServerMain {
	public static void main(String[] args) throws RemoteException {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaDS");
		EntityManager em = emf.createEntityManager(); 
		
		//ingresar
		em.getTransaction().begin();
		UsuarioModel u = new UsuarioModel("pepe","1234");
		em.persist(u);
		em.getTransaction().commit();
		//modificar
		em.getTransaction().begin();
		UsuarioModel modificado = em.merge(u);
		modificado.SetUsuario("laura");
		em.persist(modificado);
		em.getTransaction().commit();
		//consulta
		UsuarioModel traido = em.find(UsuarioModel.class, 1L);
		System.out.println(traido.GetUsuario()+" - "+traido.GetContra());
		//consulta personalizada
		TypedQuery<UsuarioModel> query = em.createNamedQuery("UsuarioModel.UserFindByUserName",UsuarioModel.class);
		query.setParameter("usuario","pepe");
		UsuarioModel usuQuery = query.getSingleResult();
		

		
		
		System.out.println("App server activated");
		Server server = new ServerImpl();
		LocateRegistry.createRegistry(1099);
		Registry locateRegistry = LocateRegistry.getRegistry();
		Server stub = (Server) UnicastRemoteObject.exportObject(server, 0);
		locateRegistry.rebind("server", stub);
	}
}
