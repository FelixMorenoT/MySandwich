package com.sandwich.core.app.service;

import java.util.Collection;
import java.util.List;

import com.sandwich.core.app.dto.IngredientDTO;
import com.sandwich.core.app.exception.type.IngredientNoFoundException;
import com.sandwich.core.app.pojo.StandardReponse;

public interface IIngredientService {

	public Collection<IngredientDTO> listAllIngredients();
	public List<IngredientDTO> listIngredientsByProductCode(Long productCode);
	public IngredientDTO findByIngredientCode(Long ingredientCode) throws IngredientNoFoundException;
	public StandardReponse saveIngredient(IngredientDTO nIngredient);
}
