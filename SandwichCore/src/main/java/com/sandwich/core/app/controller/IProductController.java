package com.sandwich.core.app.controller;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sandwich.core.app.dto.ProductDTO;
import com.sandwich.core.app.exception.type.ProductNoFoundException;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface IProductController {

	@GetMapping("/product")
	@ApiOperation(value = "Returns all list products", 
				  response = ProductDTO.class, 
				  responseContainer = "Collection")
	@ApiResponses(value =  {@ApiResponse(code = 200, message = "Success")})
	public ResponseEntity<Collection<ProductDTO>> listProducts ();
	
	
	@GetMapping("/product/{productCode}")
	@ApiOperation(value = "Returns a product based on product Code", 
				  response = ProductDTO.class, 
				  responseContainer = "Object")
	@ApiResponses(value =  {@ApiResponse(code = 200, message = "Success"), @ApiResponse(code = 404, message = "No found product")})
	public ResponseEntity<ProductDTO> findByProductCode(@PathVariable("productCode") Long productCode) throws ProductNoFoundException;
}
	