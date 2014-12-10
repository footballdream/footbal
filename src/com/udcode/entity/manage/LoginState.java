package com.udcode.entity.manage;

public class LoginState {

	public LoginState(){
		
	};
	
	public LoginState(LoginState.Type type,Long lastLoginTime){
		this.type = type;
		this.lastLoginTime = lastLoginTime;
	};
	
	private LoginState.Type type;
	
	private Long lastLoginTime;
	
	public Long getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}


	public LoginState.Type getType() {
		return type;
	}



	public void setType(LoginState.Type type) {
		this.type = type;
	}



	public enum Type{
		PC,
		MobileClient,
		MobileWeb
	}
}
