package com.sandwich.core.app.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder(value = {"orderClientMail","orderPaymentMethod","orderDetails"})
public class OrderDTO {

	private String orderClientMail;
	
	private Long orderPaymentMethod;
	
	private List<OrderDetailsDTO> orderDetails;

	private CardDTO card;
}
