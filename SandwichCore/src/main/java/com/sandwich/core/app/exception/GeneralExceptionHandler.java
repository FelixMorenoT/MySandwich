package com.sandwich.core.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sandwich.core.app.pojo.StandardReponse;

@RestControllerAdvice
public class GeneralExceptionHandler {

	@ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<StandardReponse> requestException(IllegalArgumentException requestException){
		var response = new StandardReponse(HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.name(), requestException.getMessage());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
}
	