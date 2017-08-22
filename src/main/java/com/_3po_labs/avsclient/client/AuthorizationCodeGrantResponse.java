package com._3po_labs.avsclient.client;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthorizationCodeGrantResponse {

	private String accessToken;
	private String refreshToken;
	private String token_type;
	private int expires_in;

	@JsonProperty("access_token")
	public String getAccessToken() {
		return accessToken;
	}

	@JsonProperty("access_token")
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	@JsonProperty("refresh_token")
	public String getRefreshToken() {
		return refreshToken;
	}

	@JsonProperty("refresh_token")
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	@JsonProperty("token_type")
	public String getToken_type() {
		return token_type;
	}

	@JsonProperty("token_type")
	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

	@JsonProperty("expires_in")
	public int getExpires_in() {
		return expires_in;
	}

	@JsonProperty("expires_in")
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}
}
