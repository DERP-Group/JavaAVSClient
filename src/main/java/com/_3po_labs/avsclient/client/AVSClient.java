package com._3po_labs.avsclient.client;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Future;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;

import com._3po_labs.avsclient.model.RecognizeSpeechRequest;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class AVSClient {

	private static final String RECOGNIZE_SPEECH_ENDPOINT = "/speechrecognizer/recognize";
	
	private String serviceUrl = "https://access-alexa-na.amazon.com/v1/avs";
	private Client client;
	private WebTarget serviceRoot;
	
	public AVSClient(){
		client = ClientBuilder.newClient(new ClientConfig().register( LoggingFilter.class ));
		client.register(JacksonJsonProvider.class);
		client.register(MultiPartFeature.class);
		serviceRoot = client.target(serviceUrl);
	}
	
	public Response recognizeSpeech(String authString, RecognizeSpeechRequest request, String audioFileUrl){

		MultiPart multiPart = new MultiPart();
		Builder builder = getInvocationBuilder(authString);
		Entity<MultiPart> entity = buildMultiPartEntry(multiPart, request, audioFileUrl);
		
		Response response = builder.post(entity);
		try {
			MultiPart multiPartEntity = entity.getEntity();
			multiPartEntity.close();
			multiPart.close();
		} catch (IOException e) {
			// TODO Make AVS Client exception
			e.printStackTrace();
		}
		return response;
	}
	
	public Future<Response> recognizeSpeechAsync(String authString, RecognizeSpeechRequest request, String audioFileUrl){
		
		

		MultiPart multiPart = new MultiPart();
		Builder builder = getInvocationBuilder(authString);
		Entity<MultiPart> entity = buildMultiPartEntry(multiPart, request, audioFileUrl);
		
		Future<Response> response = builder.async().post(entity);
		try {
			MultiPart multiPartEntity = entity.getEntity();
			multiPartEntity.close();
			multiPart.close();
		} catch (IOException e) {
			// TODO Make AVS Client exception
			e.printStackTrace();
		}
		return response;
	}
	
	private Entity<MultiPart> buildMultiPartEntry(MultiPart multiPart, RecognizeSpeechRequest request, String audioFileUrl) {
		WebTarget fileServerTarget = client.target(audioFileUrl);
		Builder fileServerBuilder = fileServerTarget.request();
		Response fileServerResponse = fileServerBuilder.get();
		MediaType fileMediaType = fileServerResponse.getMediaType();
		MultiPart multiPartEntity = multiPart.bodyPart(request, MediaType.APPLICATION_JSON_TYPE).bodyPart(fileServerResponse.getEntity(),fileMediaType);
		return Entity.entity(multiPartEntity, multiPartEntity.getMediaType());
	}

	public Response recognizeSpeechV2(String accessToken, RecognizeSpeechRequest request, File audioFile){
		WebTarget target = serviceRoot.path(RECOGNIZE_SPEECH_ENDPOINT);
		Builder builder = target.request();
		builder = builder.header("Authorization", "BEARER " + accessToken);
		FileDataBodyPart filePart = new FileDataBodyPart("file",new File("./src/main/resources/AstroBot.wav"));
		MultiPart multiPartEntity = new MultiPart().bodyPart(request, MediaType.APPLICATION_JSON_TYPE).bodyPart(filePart);
		Response response = builder.post(Entity.entity(multiPartEntity, multiPartEntity.getMediaType()));
		try {
			multiPartEntity.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
	
	public Builder getInvocationBuilder(String authString){
		WebTarget target = serviceRoot.path(RECOGNIZE_SPEECH_ENDPOINT);
		Builder builder = target.request();
		builder = builder.header("Authorization", authString);
		return builder;
	}
}
