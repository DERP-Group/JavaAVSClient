package com._3po_labs.avsclient.model;

public class Payload {

	private String streamId = "";
	private String offsetInMilliseconds = "0";
	private String playerActivity = "IDLE";

	public String getStreamId() {
		return streamId;
	}

	public void setStreamId(String streamId) {
		this.streamId = streamId;
	}

	public String getOffsetInMilliseconds() {
		return offsetInMilliseconds;
	}

	public void setOffsetInMilliseconds(String offsetInMilliseconds) {
		this.offsetInMilliseconds = offsetInMilliseconds;
	}

	public String getPlayerActivity() {
		return playerActivity;
	}

	public void setPlayerActivity(String playerActivity) {
		this.playerActivity = playerActivity;
	}
}
