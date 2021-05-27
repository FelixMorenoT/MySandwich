package com.sandwich.core.app.controller;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.sandwich.core.app.dto.CarrierDTO;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface ICarrierController {
	
	@GetMapping("/Carrier")
	@ApiOperation(value = "Returns all list carrier", 
				  response = CarrierDTO.class, 
				  responseContainer = "Collection")
	@ApiResponses(value =  {@ApiResponse(code = 200, message = "Success")})
	public ResponseEntity<Collection<CarrierDTO>> listCarriers ();

}
