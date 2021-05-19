package com.sandwich.core.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sandwich.core.app.exception.type.ProductNoFoundException;
import com.sandwich.core.app.pojo.StandardReponse;

@RestControllerAdvice
public class ProductExceptionHandler {

	@ExceptionHandler(ProductNoFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<StandardReponse> notFoundException(ProductNoFoundException productNoFoundException){
		var response = new StandardReponse(HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND.name(), productNoFoundException.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}
