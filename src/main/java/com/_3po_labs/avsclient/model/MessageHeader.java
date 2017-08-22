package com._3po_labs.avsclient.model;

public class MessageHeader {

	private DeviceContext[] deviceContext = new DeviceContext[]{ new DeviceContext()};

	public DeviceContext[] getDeviceContext() {
		return deviceContext;
	}

	public void setDeviceContext(DeviceContext[] deviceContext) {
		this.deviceContext = deviceContext;
	}
}
