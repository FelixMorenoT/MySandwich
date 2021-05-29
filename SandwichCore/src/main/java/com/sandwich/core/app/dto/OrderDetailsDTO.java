package com.sandwich.core.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class OrderDetailsDTO {

	@JsonProperty(required = true)
	@JsonInclude(Include.NON_NULL)
	private Long orderProductCode;
	
	@JsonProperty(required = true)
	@JsonInclude(Include.NON_NULL)
	private Long orderQuantity;
}
