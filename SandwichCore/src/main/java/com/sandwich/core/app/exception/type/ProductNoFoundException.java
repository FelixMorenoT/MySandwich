package com.sandwich.core.app.exception.type;

public class ProductNoFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductNoFoundException(String exceptionMessage) {
		super(exceptionMessage);
	}
}
