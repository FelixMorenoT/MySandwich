package com.sandwich.core.app.exception.type;

public class ClientRequestException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClientRequestException(String exceptionMessage) {
		super(exceptionMessage);
	}
}
