package com.restservices.restwebservices.helloworldbean;

public class ErrorBeanMessage {
	
	private String message2;

	public ErrorBeanMessage(String message2) {
		super();
		this.message2 = message2;
	}

	public String getMessage2() {
		return message2;
	}

	public void setMessage2(String message2) {
		this.message2 = message2;
	}

	@Override
	public String toString() {
		return String.format("ErrorBeanMessage [message2=%s]", message2);
	}
	

}
