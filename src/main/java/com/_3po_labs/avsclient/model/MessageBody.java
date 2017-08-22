package com._3po_labs.avsclient.model;

public class MessageBody {

	private String profile = "alexa-close-talk";
	private String locale = "en-us";
	private String format = "audio/L16; rate=16000; channels=1";

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
}
