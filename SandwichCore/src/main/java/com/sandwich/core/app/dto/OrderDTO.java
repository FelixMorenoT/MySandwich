package com.sandwich.core.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder(value = {"orderClientMail","orderProductCode","orderQuantity"})
public class OrderDTO {

	@JsonProperty(required = true)
	private String orderClientMail;
	
	@JsonProperty(required = true)
	private Long orderProductCode;
	
	@JsonProperty(required = true)
	private Long orderQuantity;
	
}
