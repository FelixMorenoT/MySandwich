package com.sandwich.core.app.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandwich.core.app.dto.IngredientDTO;
import com.sandwich.core.app.dto.ProductDTO;
import com.sandwich.core.app.exception.type.ProductNoFoundException;
import com.sandwich.core.app.model.Product;
import com.sandwich.core.app.repository.ProductRepository;
import com.sandwich.core.app.service.IIngredientService;
import com.sandwich.core.app.service.IProductService;

@Service
public class ProductService implements IProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private IIngredientService ingredientSerive;
	
	@Override
	public Collection<ProductDTO> findAllProducts() {
		
		Collection<Product> tmp = productRepository.findAll();
		
		HashMap<Long, List<IngredientDTO>> tmpHash = new HashMap<>();
		
		tmp.forEach(value ->
			tmpHash.put(value.getProductCode(), ingredientSerive.listIngredientsByProductCode(value.getProductCode()))
		);
		
		return new ProductDTO().convertEntityCollection(tmp,tmpHash);
	}

	@Override
	public ProductDTO findByProductCode(Long productCode) throws ProductNoFoundException {
		var tmpProduct = productRepository.findByProductCode(productCode);
		List<IngredientDTO> tmpIngredients = ingredientSerive.listIngredientsByProductCode(productCode);	
		
		if(tmpProduct != null)
				return new ProductDTO().convertEntity(tmpProduct, tmpIngredients);
		
 		throw new ProductNoFoundException("No found product with code: " + productCode);
	}

}
