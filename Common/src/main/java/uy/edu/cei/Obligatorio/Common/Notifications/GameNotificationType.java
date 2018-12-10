package uy.edu.cei.Obligatorio.Common.Notifications;

public enum GameNotificationType {
	LOGIN_SUCCES("login_succes"),
	LOGIN_ERROR("login_error"),
	MAIN("main"),
	REGISTRY("registry"),
	REAL_NAMETAKEN("real_nameTaken"),
	REAL_CREATED("real_created");
	
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
