package com.sandwich.core.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonPropertyOrder(value = {"clientUserName","clientFullName","clientMail","clientAddress","clientPhoneNumber","clientPassword"})
public class ClientDTO {

	@JsonIgnore
	private Long id;
	
	@JsonProperty(required = true)
	private String clientPhoneNumber;
	
	@JsonProperty(required = true)
	private String clientFullName;

	@JsonProperty(required = true)
	private String clientUserName;
	
	@JsonProperty(required = true)
	private String clientAddress;
	
	@JsonProperty(required = true)
	private String clientMail;
	
	@JsonProperty(required = true)
	private String clientPassword;
}
