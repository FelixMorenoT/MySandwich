package com.sandwich.core.app.controller.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandwich.core.app.controller.IIingredientController;
import com.sandwich.core.app.dto.IngredientDTO;
import com.sandwich.core.app.exception.type.IngredientNoFoundException;
import com.sandwich.core.app.pojo.StandardReponse;
import com.sandwich.core.app.service.IIngredientService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@Api(tags = {"Ingredient Controller"})
public class IngredientController implements IIingredientController {

	@Autowired
	private IIngredientService ingredientService;
	
	@Override
	public ResponseEntity<Collection<IngredientDTO>> listAllIngredients() {
		return new ResponseEntity<>(ingredientService.listAllIngredients(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<IngredientDTO> findByIngredientCode(long ingredientCode) throws IngredientNoFoundException {
		return new ResponseEntity<>(ingredientService.findByIngredientCode(ingredientCode),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<StandardReponse> includeIngredent(IngredientDTO nIngredient) {
		var response = ingredientService.saveIngredient(nIngredient);
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getResponseCode()));
	}
}
