package com.threepio_labs.avsclient.client;

import javax.ws.rs.core.Response;

import org.junit.Test;

import com.threepio_labs.avsclient.model.RecognizeSpeechRequest;

public class AVSClientTest {

	private String accessToken = "Atza|IwEBIIZMGuRUMTsebV4w-27Tnh1DUm5X3EtqankZKoR68phUzfVI_BeEDdDUHrTCqQ15z6JdtvNd_Do0KiMpH3dV1w9P8LMH99veiFGx9e0HNUQceY1dwywynkvWpZmpKpFTgemHF4o8mXKRptFlNvTy-czmzXUzSckJ0so543pjXCXGV16FO4RH9ikT5XBVoMm5EUWM16zrMOOjDogljSYrB6U-8jeor9-sxVTEkn_rtLmmuZjYsCx-ecLdMfkqox9WKVMyonsY03dOdUg6Pqd-uRpoDmciYAJqYDrZ1zCfwFcrUtC47BQtwLMkHJ2QXld1A66LNeZ2csQZErADFP6ZRsILiTykoI1JJDeYhxWZykEIrWOJNoyI9xtHELV6CZy8DLFsg9od7glhHUVWhmiMYpWCCLLkrDdNO4aujTVn6WiFvS88hKHBVJRpwJp9vhUrryky19F_jRLzs3J_QX5YFRPkGk-RZ1Q-tcj8k777D2TTO-29DAXsygYOqPjAEnNCzxmZBP1ddBbexsOx2ozxF5G91TKVI2UGB4ATnEuQPsIZ9Q";
	
	@Test
	public void testAVSClient(){
		AVSClient client = new AVSClient();
		Response response = client.recognizeSpeech(accessToken, new RecognizeSpeechRequest());
	}
}
