package com.sandwich.core.app.service;

import com.sandwich.core.app.dto.ClientDTO;
import com.sandwich.core.app.pojo.StandardReponse;

public interface IClienteSerive {

	public StandardReponse saveClient(ClientDTO nClient);
	public StandardReponse findClientByMail(String clientMail, String clientPassword);
}