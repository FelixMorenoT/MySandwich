package com.sandwich.core.app.dto;

import java.util.Collection;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sandwich.core.app.model.PaymentMethod;

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
@JsonPropertyOrder(value = {"idPaymentMethod","Name"})

public class PaymentMethodDTO {

	private Long idPaymentMethod;
	private String Name;
	
	
	public Collection<PaymentMethodDTO> convertEntityCollection(Collection<PaymentMethod> paymentMethods){
		return paymentMethods.stream().map(paymentMethod ->
										PaymentMethodDTO.builder()
														.idPaymentMethod(paymentMethod.getIdPaymentMethod())
														.Name(paymentMethod.getName())
														.build()
		).collect(Collectors.toList());
	}
}
