package com.sandwich.core.app.dto;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sandwich.core.app.model.Product;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ApiModel
@JsonPropertyOrder(value = {"status","id","code","name","description","price"})
public class ProductDTO {
 
	private Long id;
	private Long code;
	private String name;
	private String description; 
	private Double price;
	private List<IngredientDTO> ingredients;
	private boolean status;
	
	public Collection<ProductDTO> convertEntityCollection(Collection<Product> products, HashMap<Long, List<IngredientDTO>> ingredients){
		return products.stream().map(product ->
										ProductDTO.builder()
														.description(product.getProductDescription())
														.price(product.getProductPrice())
														.id(product.getId())
														.code(product.getProductCode())
														.name(product.getProductName())
														.ingredients(ingredients.get(product.getProductCode()))
														.status(product.isProductStatus())
														.build()
		).collect(Collectors.toList());
	}
	
	public ProductDTO convertEntity(Product product, List<IngredientDTO> ingredients) {
		return ProductDTO.builder()
							.description(product.getProductDescription())
							.price(product.getProductPrice())
							.id(product.getId())
							.code(product.getProductCode())
							.name(product.getProductName())
							.ingredients(ingredients)
							.status(product.isProductStatus())
							.build();
	}
}
