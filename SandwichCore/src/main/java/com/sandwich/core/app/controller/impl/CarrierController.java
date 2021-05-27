package com.sandwich.core.app.controller.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandwich.core.app.controller.ICarrierController;
import com.sandwich.core.app.dto.CarrierDTO;
import com.sandwich.core.app.service.ICarrierService;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@Api(tags = {"Carrier Controller"})
public class CarrierController implements ICarrierController {

	@Autowired
	private ICarrierService carrierService;	
	
	@Override
	public ResponseEntity<Collection<CarrierDTO>> listCarriers() {
		log.info("I---> listProducts ENDPOINT");
		log.info("E---> listProducts ENDPOINT");
		return new ResponseEntity<>(carrierService.findAllCarriers(), HttpStatus.OK);
	}

}
