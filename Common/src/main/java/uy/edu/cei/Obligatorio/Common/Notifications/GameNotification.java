package uy.edu.cei.Obligatorio.Common.Notifications;

import java.io.Serializable;

public class GameNotification implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GameNotificationType type;
	private int[] datos;
	private long dato;
	
	public GameNotification(GameNotificationType type,int[] datos) {
		this.type = type;
		this.datos = datos;
	}
	public GameNotification(GameNotificationType type,long dato) {
		this.type = type;
		this.dato = dato;
	}
	public GameNotification(GameNotificationType type) {
		this.type = type;
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
}
