package uy.edu.cei.Obligatorio.Server.Impl.Controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import uy.edu.cei.Obligatorio.Common.Observer;
import uy.edu.cei.Obligatorio.Common.Controller.RealController;
import uy.edu.cei.Obligatorio.Common.Notifications.GameNotification;
import uy.edu.cei.Obligatorio.Common.Notifications.GameNotificationType;
import uy.edu.cei.Obligatorio.Domain.RealModel;
import uy.edu.cei.Obligatorio.Domain.UsuarioModel;

public class RealControllerImpl extends UnicastRemoteObject implements RealController {
	
	private static final long serialVersionUID = 1L;
	private List<Observer> observers;
	private List<RealModel> salasReales;
	
	public RealControllerImpl(List<Observer> observers,List<RealModel> salasReales) throws RemoteException {
		this.observers = observers;
		this.salasReales = salasReales;
	}

	@Override
	public void crearSala(String nombre,UsuarioModel player, int apuesta) throws RemoteException {
		boolean encontrado = false;
		for(int l=0;l<observers.size();l++) {
			if(observers.get(l).getId()==player.getId()) {
				for(int i=0;i<salasReales.size();i++) {
					if(salasReales.get(i).getNombre().equals(nombre)){
						encontrado = true;
						break;
					}
				}
				if(encontrado)
					observers.get(l).update(new GameNotification(GameNotificationType.REAL_NAMETAKEN));
				else {
					this.salasReales.add(new RealModel(nombre,player,apuesta));
					observers.get(l).update(new GameNotification(GameNotificationType.REAL_CREATED));
				}
				break;
			}
		}
	}

	@Override
	public void entrarSala(String nombre,UsuarioModel player) throws RemoteException {
		boolean encontrado = false;
		for(int l=0;l<observers.size();l++) {
			if(observers.get(l).getId()==player.getId()) {
				for(int i=0;i<salasReales.size();i++) {
					if(salasReales.get(i).getPlayer2()==null && salasReales.get(i).getNombre().equals(nombre) && salasReales.get(i).getApuesta()<player.getReales()){
						encontrado = true;
						salasReales.get(i).setPlayer2(player);
						for(int y=0;y<observers.size();y++) {
							if(observers.get(y).getId()==salasReales.get(i).getPlayer1().getId()) {
								if(numerosRandom(1,2)==1) {
									observers.get(y).update(new GameNotification(GameNotificationType.REAL_MATCHSTART,salasReales.get(i),1));
									observers.get(l).update(new GameNotification(GameNotificationType.REAL_MATCHSTART,salasReales.get(i),2));
								}
								else
								{
									observers.get(y).update(new GameNotification(GameNotificationType.REAL_MATCHSTART,salasReales.get(i),2));
									observers.get(l).update(new GameNotification(GameNotificationType.REAL_MATCHSTART,salasReales.get(i),1));
								}
								break;
							}
						}
						break;
					}
				}
				if(!encontrado)
					observers.get(l).update(new GameNotification(GameNotificationType.REAL_MATCHNOTFOUND));
				break;
			}
		}
	}

	@Override
	public List<RealModel> darSalas() throws RemoteException {
		return this.salasReales;
	}
	private int numerosRandom(int minimo, int maximo){
	       return ThreadLocalRandom.current().nextInt(minimo,maximo);
	}
}
