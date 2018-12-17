package uy.edu.cei.Obligatorio.Common.Notifications;

import java.io.Serializable;

import uy.edu.cei.Obligatorio.Domain.RealModel;
import uy.edu.cei.Obligatorio.Domain.SalaModel;
import uy.edu.cei.Obligatorio.Domain.VirtualModel;

public class GameNotification implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GameNotificationType type;
	private int[] datos;
	private boolean[] disponibles;
	private long dato;
	private SalaModel sala;
	
	public GameNotification(GameNotificationType type,int[] datos,boolean[] disponibles) {
		this.type = type;
		this.datos = datos;
		this.sala = null;
		this.disponibles = disponibles;
	}
	public GameNotification(GameNotificationType type,long dato) {
		this.type = type;
		this.dato = dato;
		this.sala = null;
	}
	public GameNotification(GameNotificationType type) {
		this.type = type;
		this.sala = null;
	}
	public GameNotification(GameNotificationType type,RealModel sala,int dato) {
		this.type = type;
		this.sala = sala;
		this.dato = dato;
	}
	public GameNotification(GameNotificationType type,VirtualModel sala,int dato) {
		this.type = type;
		this.sala = sala;
		this.dato = dato;
	}
	public GameNotificationType getType() {
		return type;
	}
	public void setType(GameNotificationType type) {
		this.type = type;
	}
	public long getDato() {
		return this.dato;
	}
	public int[] getDatos() {
		return this.datos;
	}
	public SalaModel getSala() {
		return this.sala;
	}
	public boolean[] getDisponibles() {
		return this.disponibles;
	}
}
