package com.sandwich.core.app.controller;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.sandwich.core.app.dto.PaymentMethodDTO;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface IPaymentMethod {

	@GetMapping("/PaymentMethod")
	@ApiOperation(value = "Returns all list payment method", 
				  response = PaymentMethodDTO.class, 
				  responseContainer = "Collection")
	@ApiResponses(value =  {@ApiResponse(code = 200, message = "Success")})
	public ResponseEntity<Collection<PaymentMethodDTO>> listPaymentMethod ();
}
