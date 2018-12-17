package uy.edu.cei.Obligatorio.Common.Notifications;

public enum GameNotificationType {
	LOGIN_SUCCES("login_succes"),
	LOGIN_ERROR("login_error"),
	MAIN("main"),
	REGISTRY("registry"),
	REAL_NAMETAKEN("real_nameTaken"),
	REAL_CREATED("real_created"),
	REAL_MATCHNOTFOUND("real_matchNotFound"),
	REAL_MATCHSTART("real_matchStart"),
	USER_CREATED("user_created"),
	USER_CREATEDERROR("user_createdError"),
	USER_MODIFY("user_modify"),
	DICE_PUSH("dice_push"),
	DICE_PULL("dice_pull"),
	DICE_SELECTED("dice_selected"),
	YOUR_TURN("your_turno");
	
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
