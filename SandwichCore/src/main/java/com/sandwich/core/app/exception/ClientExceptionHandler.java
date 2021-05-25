package com.sandwich.core.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sandwich.core.app.exception.type.ClientRequestException;
import com.sandwich.core.app.pojo.StandardReponse;

@RestControllerAdvice
public class ClientExceptionHandler {

	@ExceptionHandler(ClientRequestException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<StandardReponse> clientRequestException(ClientRequestException clientRequestException){
		var response = new StandardReponse(HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.name(), clientRequestException.getMessage());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
}
	