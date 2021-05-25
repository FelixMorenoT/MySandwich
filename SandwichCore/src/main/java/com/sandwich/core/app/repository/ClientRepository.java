package com.sandwich.core.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sandwich.core.app.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

	@Query(value = "SELECT C FROM Client C WHERE C.clientMail=:mailToSearch")
	Optional<Client> findClientByMail(@Param("mailToSearch") String clientMail);
}
