package uy.edu.cei.Obligatorio.Server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import uy.edu.cei.Obligatorio.Common.Server.Server;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws RemoteException {
		Scanner sc = new Scanner(System.in);
		String nombre = sc.next();
		String algo = "pepe";
		if(nombre == algo)
			System.out.print("hola");
		if(nombre.equals(algo))
			System.out.print("dios mio por favor");
		System.out.println("App server activated");
		Server server = new ServerImpl();
		LocateRegistry.createRegistry(1099);
		Registry locateRegistry = LocateRegistry.getRegistry();
		Server stub = (Server) UnicastRemoteObject.exportObject(server, 0);
		locateRegistry.rebind("server", stub);
	}
}
