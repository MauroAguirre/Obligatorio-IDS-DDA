package uy.edu.cei.Obligatorio.Common.Notifications;

public enum GameNotificationType {
	LOGIN("login"),
	MAIN("main"),
	REGISTRY("registry");
	
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
