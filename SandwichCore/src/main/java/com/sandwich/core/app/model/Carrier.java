package com.sandwich.core.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "carriers")

public class Carrier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCarrier;
	
	@Column(name = "nombre")
	private String carrierName;
	
	@Column(name = "NITempresa")
	private String carrierNit;
	
	@Column(name = "telefono")
	private String carrierPhoneNumber;
	
	}
