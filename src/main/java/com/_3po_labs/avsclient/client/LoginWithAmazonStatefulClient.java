package com._3po_labs.avsclient.client;

public class LoginWithAmazonStatefulClient extends LoginWithAmazonClient{

	private String clientId;
	private String clientSecret;
	private String refreshToken;
	
	private String accessToken;
	private long tokenExpiration;
	
	public LoginWithAmazonStatefulClient(String serviceUrl, String clientId, String clientSecret, String refreshToken){
		super(serviceUrl);
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.refreshToken = refreshToken;
	}

	public String refreshAccessToken() throws LoginWithAmazonException{
		if(accessToken != null && tokenExpiration > System.currentTimeMillis()){
			return accessToken;
		}
		RefreshTokenGrantRequest request = new RefreshTokenGrantRequest();
		request.setClientId(clientId);
		request.setClientSecret(clientSecret);
		request.setRefreshToken(refreshToken);
		return refresh(request).getAccessToken();
	}
	
	@Override
	public AuthorizationCodeGrantResponse refresh(RefreshTokenGrantRequest request) throws LoginWithAmazonException{
		AuthorizationCodeGrantResponse response = super.refresh(request);
		accessToken = response.getAccessToken();
		tokenExpiration = System.currentTimeMillis() + (1000 * response.getExpires_in());
		return response;
	}
}
