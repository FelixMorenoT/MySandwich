package com.sandwich.core.app.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandwich.core.app.controller.IClientController;
import com.sandwich.core.app.dto.ClientDTO;
import com.sandwich.core.app.pojo.StandardReponse;
import com.sandwich.core.app.service.IClienteSerive;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@Api(tags = {"Client Controller"})
public class ClientController implements IClientController{

	@Autowired
	private IClienteSerive clientService;
	
	@Override
	public ResponseEntity<StandardReponse> checkClientByMail(String clientMail, String clientPassWord) {
		var response = clientService.findClientByMail(clientMail, clientPassWord);
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getResponseCode()));
	}

	@Override
	public ResponseEntity<StandardReponse> saveClient(ClientDTO nClient) {
		var response = clientService.saveClient(nClient);
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getResponseCode()));
	}
}
  