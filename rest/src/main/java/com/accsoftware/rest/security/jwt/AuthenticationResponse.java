package com.accsoftware.rest.security.jwt;

public class AuthenticationResponse {

	private Long userId;
	private String token;

	public AuthenticationResponse() {
		token = new String();
	}

	public AuthenticationResponse(String token) {
		this.token = token;
	}

	public AuthenticationResponse(Long userId, String token) {
		super();
		this.userId = userId;
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
