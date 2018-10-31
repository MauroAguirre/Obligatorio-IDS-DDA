package uy.edu.cei.Obligatorio.Common.Notifications;

import java.io.Serializable;

public class GameNotification implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GameNotificationType type;
	private int id;
	
	public GameNotification(GameNotificationType gnt,int id) {
		this.type = gnt;
		this.id = id;
	}
	
	public GameNotificationType getType() {
		return type;
	}
	
	public void setType(GameNotificationType type) {
		this.type = type;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
