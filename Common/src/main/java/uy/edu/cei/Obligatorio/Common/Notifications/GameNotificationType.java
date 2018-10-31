package uy.edu.cei.Obligatorio.Common.Notifications;

public enum GameNotificationType {
	LOGIN("login"),
	LOGIN_ERROR("login_error"),
	LOGOUT("logout"),
	THROW_DICE("throw_dice");
	
	private String value;
	
	GameNotificationType(String value){
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
}
