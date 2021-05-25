package com.sandwich.core.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sandwich.core.app.dto.ClientDTO;
import com.sandwich.core.app.model.Client;
import com.sandwich.core.app.pojo.StandardReponse;
import com.sandwich.core.app.repository.ClientRepository;
import com.sandwich.core.app.service.IClienteSerive;

@Service
public class ClientService implements IClienteSerive {

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public StandardReponse saveClient(ClientDTO nClient) {
		var tmpClient = clientRepository.findClientByMail(nClient.getClientMail());
		
		if(tmpClient.isPresent())
			return new StandardReponse().getReponse(208, "Client Already Exsits!");
		
		var tmpClientSave = clientRepository.save(Client.builder()
										.clientAddress(nClient.getClientAddress())
										.clientFullName(nClient.getClientFullName())
										.clientMail(nClient.getClientMail())
										.clientPhoneNumber(nClient.getClientPhoneNumber())
										.rol("CUSTOMER")
										.clientStatus(true)
										.clientUserName(nClient.getClientUserName())
										.clientPassword(passwordEncoder.encode(nClient.getClientPassword()))
										.build());
		
		if(tmpClientSave.getId() != 0)
			return new StandardReponse().getReponse(201, "Client created successfully");;

		return new StandardReponse().getReponse(500, "Internal Error Service Client");
	}

	@Override
	public StandardReponse findClientByMail(String clientMail, String clientPassWord) {
		var tmpClient = clientRepository.findClientByMail(clientMail);
		var response = new StandardReponse();
			
		if(tmpClient.isPresent()) {
			if(new BCryptPasswordEncoder().matches(clientPassWord, tmpClient.get().getClientPassword())) {
				return response.getReponse(200, "Valid Client");
			}
			return response.getReponse(203, "Invalid Credentials");
		}
		
		return response.getReponse(404, "Client Doesn't Exsits");
	}
}
