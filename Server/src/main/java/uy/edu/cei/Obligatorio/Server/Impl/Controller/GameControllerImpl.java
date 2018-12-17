package uy.edu.cei.Obligatorio.Server.Impl.Controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import uy.edu.cei.Obligatorio.Common.Observer;
import uy.edu.cei.Obligatorio.Common.Controller.GameController;
import uy.edu.cei.Obligatorio.Common.Notifications.GameNotification;
import uy.edu.cei.Obligatorio.Common.Notifications.GameNotificationType;
import uy.edu.cei.Obligatorio.Domain.RealModel;
import uy.edu.cei.Obligatorio.Domain.SalaModel;
import uy.edu.cei.Obligatorio.Domain.VirtualModel;

public class GameControllerImpl extends UnicastRemoteObject implements GameController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Observer> observers;
	private List<RealModel> reales;
	private List<VirtualModel> virtuales;
	
	public GameControllerImpl(List<Observer> observers,List<RealModel> reales,List<VirtualModel> virtuales) throws RemoteException {
		this.observers = observers;
		this.reales = reales;
		this.virtuales = virtuales;
	}

	@Override
	public void tirarDados(int[] dados, boolean[] disponibles,Long tiradorId,Long recibidorId,int turno) throws RemoteException {
		for(int i=0;i<dados.length;i++) {
			if(disponibles[i])
				dados[i] = numerosRandom(1,6);
		}
		if(turno!=3) {
			for(int i=0;i<observers.size();i++) {
				if(observers.get(i).getId()==tiradorId) {
					observers.get(i).update(new GameNotification(GameNotificationType.DICE_PUSH,dados,disponibles));
				}
				if(observers.get(i).getId()==recibidorId) {
					observers.get(i).update(new GameNotification(GameNotificationType.DICE_PULL,dados,disponibles));
				}
			}
		}
	}

	private int numerosRandom(int minimo, int maximo){
	       return ThreadLocalRandom.current().nextInt(minimo,maximo);
	}

	public void lockearJugada(int[] dados,Long tiradorId,Long recibidorId,int jugada) throws RemoteException {
		Long puntaje=0l;
		switch(jugada) {
			case 1:
				for(int i=0;i<dados.length;i++) {
					if(dados[i]==1)
						puntaje++;
				}
				break;
			case 2:
				for(int i=0;i<dados.length;i++) {
					if(dados[i]==2)
						puntaje+=2;
				}
				break;
			case 3:
				for(int i=0;i<dados.length;i++) {
					if(dados[i]==3)
						puntaje+=3;
				}
				break;
			case 4:
				for(int i=0;i<dados.length;i++) {
					if(dados[i]==4)
						puntaje+=4;
				}
				break;
			case 5:
				for(int i=0;i<dados.length;i++) {
					if(dados[i]==5)
						puntaje+=5;
				}
				break;
			case 6:
				for(int i=0;i<dados.length;i++) {
					if(dados[i]==1)
						puntaje+=6;
				}
				break;
			case 7:
				int[] numeros= {0,0,0,0,0,0,0};
				for(int i=0;i<dados.length+1;i++) {
					for(int l=0;l<dados.length;l++) {
						if(dados[l]==i+1)
							numeros[i]=1;
					}
				}
				if(numeros[0]==1&&numeros[1]==1&&numeros[2]==1&&numeros[3]==1&&numeros[4]==1)
					puntaje=20l;
				else {
					if(numeros[1]==1&&numeros[2]==1&&numeros[3]==1&&numeros[4]==1&&numeros[5]==1)
						puntaje=20l;
				}
				break;
			case 8:
				int[] veces = new int[6];
				for(int i=0;i<dados.length+1;i++) {
					for(int l=0;l<dados.length;l++) {
						if(dados[l]==i+1)
							veces[i]++;
					}
				}
				boolean doble=false;
				boolean triple=false;
				for(int l=0;l<veces.length;l++) {
					if(veces[l]==3)
						triple=true;
					if(veces[l]==2)
						doble = true;
				}
				if(doble&&triple)
					puntaje=30l;
				break;
			case 9:
				int[] veces2 = new int[6];
				for(int i=0;i<dados.length+1;i++) {
					for(int l=0;l<dados.length;l++) {
						if(dados[l]==i+1)
							veces2[i]++;
					}
				}
				for(int l=0;l<veces2.length;l++) {
					if(veces2[l]==4)
						puntaje=40l;

				}
				break;
			case 10:
				int[] veces3 = new int[6];
				for(int i=0;i<dados.length+1;i++) {
					for(int l=0;l<dados.length;l++) {
						if(dados[l]==i+1)
							veces3[i]++;
					}
				}
				for(int l=0;l<veces3.length;l++) {
					if(veces3[l]==5)
						puntaje=60l;

				}
				break;
			case 11:
				break;
			case 0:
				puntaje-=100l;
		}
		for(int i=0;i<observers.size();i++) {
			if(observers.get(i).getId()==tiradorId) {
				observers.get(i).update(new GameNotification(GameNotificationType.DICE_SELECTED,puntaje));
			}
			if(observers.get(i).getId()==recibidorId) {
				observers.get(i).update(new GameNotification(GameNotificationType.YOUR_TURN,puntaje));
			}
		}
	}
}
