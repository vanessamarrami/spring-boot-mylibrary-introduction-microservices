package com.statistics.exception;

public class ConnectionRefusedExceptions extends RuntimeException {

	private static final long serialVersionUID = -2359369137104416919L;

	private String message;
	
	public ConnectionRefusedExceptions(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
