package com.sandwich.core.app.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.sandwich.core.app.dto.ClientDTO;
import com.sandwich.core.app.pojo.StandardReponse;

public interface IClientController {

	@GetMapping(value = "/client" , headers = {"clientMail", "clientPass" })
	public ResponseEntity<StandardReponse> checkClientByMail(@RequestHeader(name = "clientMail", required = true) String clientMail, 
																		@RequestHeader(name = "clientPass" , required = true) String clientPassWord);
	
	@PostMapping("/client")
	public ResponseEntity<StandardReponse> saveClient(@Valid @RequestBody ClientDTO nClient);
}
