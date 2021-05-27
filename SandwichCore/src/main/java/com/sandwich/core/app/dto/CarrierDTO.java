package com.sandwich.core.app.dto;

import java.util.Collection;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sandwich.core.app.model.Carrier;

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
@JsonPropertyOrder(value = {"idCarrier","carrierName","carrierNit","carrierPhoneNumber"})

public class CarrierDTO {

	
	private Long idCarrier;
	private String carrierName;
	private String carrierNit;
	private String carrierPhoneNumber;
	
	
	public Collection<CarrierDTO> convertEntityCollection(Collection<Carrier> carriers){
		return carriers.stream().map(carrier ->
										CarrierDTO.builder()
														.idCarrier(carrier.getIdCarrier())
														.carrierName(carrier.getCarrierName())
														.carrierNit(carrier.getCarrierName())
														.carrierPhoneNumber(carrier.getCarrierPhoneNumber())
														.build()
		).collect(Collectors.toList());
	}
	
}
