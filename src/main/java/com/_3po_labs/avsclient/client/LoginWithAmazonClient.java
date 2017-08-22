package com._3po_labs.avsclient.client;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class LoginWithAmazonClient {

	private static final String TOKEN_ENDPOINT = "/token";
	
	private Client client;
	private WebTarget serviceRoot;
	
	public LoginWithAmazonClient(String serviceUrl){
		client = ClientBuilder.newClient(new ClientConfig().register( LoggingFilter.class ));
		client.register(JacksonJsonProvider.class);
		serviceRoot = client.target(serviceUrl);
	}
	
	public AuthorizationCodeGrantResponse authorize(AuthorizationCodeGrantRequest request) throws LoginWithAmazonException{

		WebTarget target = serviceRoot.path(TOKEN_ENDPOINT);
		Builder builder = target.request(MediaType.APPLICATION_JSON_TYPE);		
		Response response = builder.post(Entity.json(request));
		if(response.getStatus() == Status.OK.getStatusCode()){
			return response.readEntity(AuthorizationCodeGrantResponse.class);
		}else if(response.getStatus() == Status.UNAUTHORIZED.getStatusCode()){
			LoginWithAmazonErrorResponse errorResponse = response.readEntity(LoginWithAmazonErrorResponse.class);
			throw new UnauthorizedException("Error", errorResponse);
		}else{
			LoginWithAmazonErrorResponse errorResponse = response.readEntity(LoginWithAmazonErrorResponse.class);
			throw new LoginWithAmazonException("Error", errorResponse);
		}
		
	}
	
	public AuthorizationCodeGrantResponse refresh(RefreshTokenGrantRequest request) throws LoginWithAmazonException{
		WebTarget target = serviceRoot.path(TOKEN_ENDPOINT);
		Builder builder = target.request(MediaType.APPLICATION_JSON_TYPE);		
		Response response = builder.post(Entity.json(request));
		if(response.getStatus() == Status.OK.getStatusCode()){
			return response.readEntity(AuthorizationCodeGrantResponse.class);
		}else{
			LoginWithAmazonErrorResponse errorResponse = response.readEntity(LoginWithAmazonErrorResponse.class);
			throw new LoginWithAmazonException("Error", errorResponse);
		}
	}
}
