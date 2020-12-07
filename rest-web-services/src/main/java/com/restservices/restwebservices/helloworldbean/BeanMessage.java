package com.restservices.restwebservices.helloworldbean;

public class BeanMessage {

	private String message;

	public BeanMessage(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return String.format("BeanMessage [message=%s]", message);
	}

	
	
	}


