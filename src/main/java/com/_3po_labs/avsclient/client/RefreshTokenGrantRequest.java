package com._3po_labs.avsclient.client;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RefreshTokenGrantRequest {

	private String clientId;
	private String clientSecret;
	private String refreshToken;
	private String grantType = "refresh_token";

	@JsonProperty("client_id")
	public String getClientId() {
		return clientId;
	}

	@JsonProperty("client_id")
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	@JsonProperty("client_secret")
	public String getClientSecret() {
		return clientSecret;
	}

	@JsonProperty("client_secret")
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	@JsonProperty("refresh_token")
	public String getRefreshToken() {
		return refreshToken;
	}

	@JsonProperty("refresh_token")
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	@JsonProperty("grant_type")
	public String getGrantType() {
		return grantType;
	}

	@JsonProperty("grant_type")
	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}
}
