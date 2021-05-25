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
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "client_full_name")
	private String clientFullName;
	
	@Column(name = "client_user_name")
	private String clientUserName; 
	
	@Column(name = "client_password")
	private String clientPassword;
	
	@Column(name = "client_mail")
	private String clientMail;
	
	@Column(name = "client_address")
	private String clientAddress;
	
	@Column(name = "client_status")
	private boolean clientStatus;
	
	@Column(name = "client_phone_number")
	private String clientPhoneNumber;

	@Column(name = "rol")
	private String rol;
}
