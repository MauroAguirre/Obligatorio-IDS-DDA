package uy.edu.cei.Obligatorio.Server;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import uy.edu.cei.Obligatorio.Domain.Usuario;
import uy.edu.cei.Obligatorio.Common.Observable;
import uy.edu.cei.Obligatorio.Common.Observer;
import uy.edu.cei.Obligatorio.Common.Server.Server;

public class ServerImpl implements Server, Observable {
	
	private UsuarioControllerImpl usuarioControllerImpl;
	private List<Observer> observers;
	private List<Usuario> usuarios;
	
	public ServerImpl() {
		this.usuarioControllerImpl = UsuarioControllerImpl.Instancia();
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

	@Override
	public boolean RegistrarUsuario() throws RemoteException {
		return true;
		
	}

	@Override
	public List<Usuario> ListaUsuarios() throws RemoteException {
		List<Usuario> a = new ArrayList<Usuario>();
		Usuario usu = new Usuario("123","123");
		a.add(usu);
		return a;
		//return this.usuarioControllerImpl.ListaUsuarios();
	}
	public String Hola() {
		return this.usuarioControllerImpl.Hola();
	}
}
