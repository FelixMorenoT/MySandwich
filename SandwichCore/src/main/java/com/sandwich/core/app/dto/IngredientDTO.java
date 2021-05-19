package com.sandwich.core.app.dto;

import java.util.Collection;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sandwich.core.app.model.Ingredient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class IngredientDTO {

	@JsonIgnore
	private Long id;
	
	@JsonProperty(value = "Ingredient Code")
	private Long codeIngredient;
	
	@JsonProperty(value = "Ingredient Name")
	private String nameIngredient;
	
	
	public Collection<IngredientDTO> convertEntityCollection( Collection<Ingredient> ingredients){
		return ingredients.stream().map(ingredient ->
						IngredientDTO.builder()
										.id(ingredient.getId())
										.codeIngredient(ingredient.getCodeIngredient())
										.nameIngredient(ingredient.getNameIngredient())
										.build()
						).collect(Collectors.toList());
	}
	
	public IngredientDTO convertEntity(Ingredient ingredient) {
		return IngredientDTO.builder()
				.id(ingredient.getId())
				.codeIngredient(ingredient.getCodeIngredient())
				.nameIngredient(ingredient.getNameIngredient())
				.build();
	}
}
