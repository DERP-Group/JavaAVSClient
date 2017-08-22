package com._3po_labs.avsclient.client;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginWithAmazonErrorResponse {

	private String error;
	private String errorDescription;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	@JsonProperty("error_description")
	public String getErrorDescription() {
		return errorDescription;
	}
	
	@JsonProperty("error_description")
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
}
