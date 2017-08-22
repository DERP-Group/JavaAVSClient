package com._3po_labs.avsclient.client;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthorizationCodeGrantRequest {

	private String code;
	private String grantType = "authorization_code";
	private String clientId;
	private String clientSecret;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@JsonProperty("grant_type")
	public String getGrantType() {
		return grantType;
	}

	@JsonProperty("grant_type")
	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}

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
}
