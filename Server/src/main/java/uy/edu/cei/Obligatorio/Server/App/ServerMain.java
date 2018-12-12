package uy.edu.cei.Obligatorio.Server.App;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import uy.edu.cei.Obligatorio.Common.Server.Server;
import uy.edu.cei.Obligatorio.Server.Impl.Service.ServerImpl;
import uy.edu.cei.Obligatorio.Server.Service.JPAService;

/**
 * Hello world!
 *
 */
public class ServerMain {
	public static void main(String[] args) throws RemoteException {
		System.setProperty("java.security.policy", "file:C:\\java.policy");
		System.setSecurityManager(new SecurityManager());
		JPAService jpa = JPAService.getInstance();
		System.out.println("App server activated");
		Server server = new ServerImpl();
		LocateRegistry.createRegistry(1099);
		Registry locateRegistry = LocateRegistry.getRegistry();
		Server stub = (Server) UnicastRemoteObject.exportObject(server, 0);
		locateRegistry.rebind("server", stub);
	}
}
