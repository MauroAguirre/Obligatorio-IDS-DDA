package uy.edu.cei.Obligatorio.Common.Notifications;

import java.io.Serializable;

public class GameNotification implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GameNotificationType type;
	private GameNotificationAction action;
	private int[] datos;
	private long dato;
	private long id;
	
	public GameNotification(GameNotificationType type,GameNotificationAction action,long id,int[] datos) {
		this.type = type;
		this.action = action;
		this.id = id;
		this.datos = datos;
	}
	public GameNotification(GameNotificationType type,GameNotificationAction action,long id,long dato) {
		this.type = type;
		this.action = action;
		this.id = id;
		this.dato = dato;
	}
	public GameNotification(GameNotificationType type,GameNotificationAction action,long id) {
		this.type = type;
		this.action = action;
		this.id = id;
	}
	public GameNotificationType getType() {
		return type;
	}
	
	public void setType(GameNotificationType type) {
		this.type = type;
	}
	
	public GameNotificationAction getAction() {
		return action;
	}
	
	public void setAction(GameNotificationAction action) {
		this.action = action;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public long getDato() {
		return this.dato;
	}
	public int[] getDatos() {
		return this.datos;
	}
}
