package uy.edu.cei.Obligatorio.Common.Notifications;

public enum GameNotificationAction {
	LOG("log"),
	ERROR("login_error");
	
	private String value;
	
	GameNotificationAction(String value){
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
}
