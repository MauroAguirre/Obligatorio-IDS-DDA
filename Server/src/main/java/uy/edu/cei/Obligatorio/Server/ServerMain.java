package uy.edu.cei.Obligatorio.Server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import uy.edu.cei.Obligatorio.Common.Server.Server;
import uy.edu.cei.Obligatorio.Server.Impl.ServerImpl;

/**
 * Hello world!
 *
 */
public class ServerMain {
	public static void main(String[] args) throws RemoteException {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaDS");
		EntityManager em = emf.createEntityManager(); 
		System.out.println("App server activated");
		Server server = new ServerImpl();
		LocateRegistry.createRegistry(1099);
		Registry locateRegistry = LocateRegistry.getRegistry();
		Server stub = (Server) UnicastRemoteObject.exportObject(server, 0);
		locateRegistry.rebind("server", stub);
	}
}
