package com.sandwich.core.app.service;

import java.util.Collection;

import com.sandwich.core.app.dto.PaymentMethodDTO;

public interface IPaymentMethodService {

	public Collection<PaymentMethodDTO> findAllPaymentMethod();
}
