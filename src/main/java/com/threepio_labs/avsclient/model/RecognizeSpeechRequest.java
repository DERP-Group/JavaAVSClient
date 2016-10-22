package com.threepio_labs.avsclient.model;

public class RecognizeSpeechRequest {

	private MessageHeader messageHeader = new MessageHeader();
	private MessageBody messageBody = new MessageBody();

	public MessageHeader getMessageHeader() {
		return messageHeader;
	}

	public void setMessageHeader(MessageHeader messageHeader) {
		this.messageHeader = messageHeader;
	}

	public MessageBody getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(MessageBody messageBody) {
		this.messageBody = messageBody;
	}
}
