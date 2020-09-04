package com.appsdeveloperblog.app.ws.ui.model.response;

import java.util.Date;

public class ErrorMessage {

	private Date timestamp;
	private String messae;

	public ErrorMessage() {
	}

	public ErrorMessage(Date timestamp, String messae) {
		super();
		this.timestamp = timestamp;
		this.messae = messae;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessae() {
		return messae;
	}

	public void setMessae(String messae) {
		this.messae = messae;
	}
}
