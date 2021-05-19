package com.sandwich.core.app.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sandwich.core.app.dto.IngredientDTO;
import com.sandwich.core.app.exception.type.IngredientNoFoundException;
import com.sandwich.core.app.model.Ingredient;
import com.sandwich.core.app.pojo.StandardReponse;
import com.sandwich.core.app.repository.IngredientRepository;
import com.sandwich.core.app.service.IIngredientService;

@Service
public class IngredientService implements IIngredientService{

	@Autowired
	private IngredientRepository ingredientRepository;

	@Override
	public Collection<IngredientDTO> listAllIngredients() {
		return new IngredientDTO().convertEntityCollection(ingredientRepository.findAll());
	}
	
	@Override
	public List<IngredientDTO> listIngredientsByProductCode(Long productCode) {
		return (List<IngredientDTO>) new IngredientDTO().convertEntityCollection(ingredientRepository.listIngredientsByProductCode(productCode));
	}

	@Override
	public IngredientDTO findByIngredientCode(Long ingredientCode) throws IngredientNoFoundException {
		var tmpIngredient = ingredientRepository.findByIngredientCode(ingredientCode);
		
		if(tmpIngredient != null)
			return new IngredientDTO().convertEntity(tmpIngredient);
		
		throw new IngredientNoFoundException("No found ingredient with code: " + ingredientCode);
	}

	@Override
	public StandardReponse saveIngredient(IngredientDTO nIngredient) {
		var tmpIngredient =  ingredientRepository.findByIngredientCode(nIngredient.getCodeIngredient());
		StandardReponse response = null;
		
		if(tmpIngredient != null) {
			response = new StandardReponse();
			response.setResponseCode(HttpStatus.BAD_REQUEST.value());
			response.setResponseStatus(HttpStatus.BAD_REQUEST.name());
			response.setResponseMsg("Is already registered");
			return response;
			
		}
		
		ingredientRepository.save(Ingredient.builder()
				.codeIngredient(nIngredient.getCodeIngredient())
				.nameIngredient(nIngredient.getNameIngredient())
				.build());
		
		response = new StandardReponse();
		response.setResponseCode(HttpStatus.CREATED.value());
		response.setResponseStatus(HttpStatus.CREATED.name());
		response.setResponseMsg("Registered successfully");
		return response;
	}
}
