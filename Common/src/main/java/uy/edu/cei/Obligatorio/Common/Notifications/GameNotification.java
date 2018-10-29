package uy.edu.cei.Obligatorio.Common.Notifications;

import java.io.Serializable;

public class GameNotification implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GameNotificationType type;
	private String currentUser;
	
	public GameNotificationType getType() {
		return type;
	}
	
	public void setType(GameNotificationType type) {
		this.type = type;
	}
	
	public String getCurrentUser() {
		return currentUser;
	}
	
	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}
}
