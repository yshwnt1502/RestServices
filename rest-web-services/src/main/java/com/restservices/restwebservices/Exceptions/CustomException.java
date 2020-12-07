package com.restservices.restwebservices.Exceptions;

import java.util.Date;

public class CustomException {

	
	private Date timestamp;
	private String message;
	private String details;
	public CustomException(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}
	
	
}
