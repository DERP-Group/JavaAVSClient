package com._3po_labs.avsclient.client;

public class UnauthorizedException extends LoginWithAmazonException {

	public UnauthorizedException(String message, LoginWithAmazonErrorResponse errorResponse) {
		super(message, errorResponse);
	}

}
