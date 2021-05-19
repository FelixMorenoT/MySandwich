package com.sandwich.core.app.service;

import java.util.Collection;

import com.sandwich.core.app.dto.ProductDTO;
import com.sandwich.core.app.exception.type.ProductNoFoundException;

public interface IProductService {

	public Collection<ProductDTO> findAllProducts();
	
	public ProductDTO findByProductCode(Long productCode) throws ProductNoFoundException;
}
