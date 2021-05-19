package com.sandwich.core.app.exception.type;

public class IngredientNoFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IngredientNoFoundException(String exceptionMessage) {
		super(exceptionMessage);
	}
}
