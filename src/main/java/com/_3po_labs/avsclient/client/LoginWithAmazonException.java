package com._3po_labs.avsclient.client;

public class LoginWithAmazonException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3488734649042026167L;
	
	private LoginWithAmazonErrorResponse errorResponse; 

	public LoginWithAmazonException(String message, LoginWithAmazonErrorResponse errorResponse){
		super(message);
		this.errorResponse = errorResponse;
	}

	public LoginWithAmazonErrorResponse getErrorResponse() {
		return errorResponse;
	}

	public void setErrorResponse(LoginWithAmazonErrorResponse errorResponse) {
		this.errorResponse = errorResponse;
	}
}
