package com.accsoftware.rest.security;

public class AuthenticationBean {
		
	Long userId;

	public AuthenticationBean() {
	}

	public AuthenticationBean(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "AuthenticationBean [userId=" + userId + "]";
	}
}
