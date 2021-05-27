package com.sandwich.core.app.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandwich.core.app.dto.CarrierDTO;
import com.sandwich.core.app.model.Carrier;
import com.sandwich.core.app.repository.CarrierRepository;
import com.sandwich.core.app.service.ICarrierService;

@Service
public class CarrierService implements ICarrierService {
	
	@Autowired
	private CarrierRepository carrierRepository;
	
	@Override
	public Collection<CarrierDTO> findAllCarriers() {
		
		Collection<Carrier> tmp = carrierRepository.findAll();
		
		//HashMap<String, String> tmpHash = new HashMap<>();
		
		//tmp.forEach(value ->
			//tmpHash.put(value.getCarrierName(), value.getCarrierNit() )
		//);
		
		return new CarrierDTO().convertEntityCollection(tmp);
	}
}
