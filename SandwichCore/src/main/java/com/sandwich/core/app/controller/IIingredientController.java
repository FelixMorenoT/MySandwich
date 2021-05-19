package com.sandwich.core.app.controller;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sandwich.core.app.dto.IngredientDTO;
import com.sandwich.core.app.exception.type.IngredientNoFoundException;
import com.sandwich.core.app.pojo.StandardReponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface IIingredientController {

	@GetMapping("/ingredient")
	@ApiOperation(value = "Returns list ingredients", 
										  response = IngredientDTO.class, 
										  responseContainer = "Collection")
	@ApiResponses(value =  {@ApiResponse(code = 200, message = "Success")})
	public ResponseEntity<Collection<IngredientDTO>> listAllIngredients();
	
	@GetMapping("/ingredient/{ingredientCode}")
	@ApiOperation(value = "Returns a ingredient based on ingredient Code", 
	  response = IngredientDTO.class, 
	  responseContainer = "Object")
	@ApiResponses(value =  {@ApiResponse(code = 200, message = "Success"), @ApiResponse(code = 404, message = "No found ingredient")})
	public ResponseEntity<IngredientDTO> findByIngredientCode(@PathVariable("ingredientCode") long ingredientCode) throws IngredientNoFoundException;
	
	@PostMapping("/ingredient")
	@ApiOperation(value = "Include new ingredient", 
	  response = StandardReponse.class, 
	  responseContainer = "Object")
	@ApiResponses(value =  {@ApiResponse(code = 201, message = "Created"), @ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 409, message = "Already in the system")})
	public ResponseEntity<StandardReponse> includeIngredent(@RequestBody IngredientDTO nIngredient);
}
