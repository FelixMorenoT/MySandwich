package com.sandwich.core.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sandwich.core.app.exception.type.IngredientNoFoundException;
import com.sandwich.core.app.pojo.StandardReponse;

@RestControllerAdvice
public class IngredientExceptionHandler {

	@ExceptionHandler(IngredientNoFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<StandardReponse> notFoundException(IngredientNoFoundException ingredientNoFoundException){
		var response = new StandardReponse(HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND.name(), ingredientNoFoundException.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}
