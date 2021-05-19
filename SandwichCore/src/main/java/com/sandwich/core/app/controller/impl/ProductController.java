package com.sandwich.core.app.controller.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandwich.core.app.controller.IProductController;
import com.sandwich.core.app.dto.ProductDTO;
import com.sandwich.core.app.exception.type.ProductNoFoundException;
import com.sandwich.core.app.service.IProductService;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@Api(tags = {"Product Controller"})
public class ProductController implements IProductController {
	
	@Autowired
	private IProductService productService;	
	
	@Override
	public ResponseEntity<Collection<ProductDTO>> listProducts() {
		log.info("I---> listProducts ENDPOINT");
		log.info("E---> listProducts ENDPOINT");
		return new ResponseEntity<>(productService.findAllProducts(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ProductDTO> findByProductCode(Long productCode) throws ProductNoFoundException {
		log.info("I---> findByProductCode ENDPOINT");
		log.info("E---> findByProductCode ENDPOINT");
		return new ResponseEntity<>(productService.findByProductCode(productCode),HttpStatus.OK);
	}
}
