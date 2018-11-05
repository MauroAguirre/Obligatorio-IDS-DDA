package uy.edu.cei.Obligatorio.Common.Notifications;

import java.io.Serializable;

public class GameNotification implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GameNotificationType type;
	private GameNotificationAction action;
	private int id;
	
	public GameNotification(GameNotificationType type,GameNotificationAction action,int id) {
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
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
