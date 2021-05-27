package com.sandwich.core.app.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandwich.core.app.dto.PaymentMethodDTO;
import com.sandwich.core.app.model.PaymentMethod;
import com.sandwich.core.app.repository.PaymentMethodRepository;
import com.sandwich.core.app.service.IPaymentMethodService;

@Service
public class PaymentMethodService implements IPaymentMethodService {
	
	@Autowired
	private PaymentMethodRepository paymentMethodRepository;
	
	@Override
	public Collection<PaymentMethodDTO> findAllPaymentMethod() {
		
		Collection<PaymentMethod> tmp = paymentMethodRepository.findAll();
		
		return new PaymentMethodDTO().convertEntityCollection(tmp);
	}

}
