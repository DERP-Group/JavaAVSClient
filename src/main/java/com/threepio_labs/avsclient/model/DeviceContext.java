package com.threepio_labs.avsclient.model;

public class DeviceContext {

	private String name = "playbackState";
	private String namespace = "AudioPlayer";
	private Payload payload = new Payload();;

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public Payload getPayload() {
		return payload;
	}

	public void setPayload(Payload payload) {
		this.payload = payload;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
