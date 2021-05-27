package com.sandwich.core.app.controller.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandwich.core.app.controller.IPaymentMethod;
import com.sandwich.core.app.dto.PaymentMethodDTO;
import com.sandwich.core.app.service.IPaymentMethodService;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@Api(tags = {"Payment Method Controller"})
public class PaymentMethodController implements IPaymentMethod {

	@Autowired
	private IPaymentMethodService paymentMethodService;
	
	@Override
	public ResponseEntity<Collection<PaymentMethodDTO>> listPaymentMethod() {
		log.info("I---> listProducts ENDPOINT");
		log.info("E---> listProducts ENDPOINT");
		return new ResponseEntity<>(paymentMethodService.findAllPaymentMethod(), HttpStatus.OK);
	}

}
