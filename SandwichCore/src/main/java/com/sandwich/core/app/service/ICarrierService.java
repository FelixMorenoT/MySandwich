package com.sandwich.core.app.service;

import java.util.Collection;

import com.sandwich.core.app.dto.CarrierDTO;

public interface ICarrierService {

	public Collection<CarrierDTO> findAllCarriers();
	
	//public CarrierDTO findByProductCode(Long productCode) throws ProductNoFoundException;
}
