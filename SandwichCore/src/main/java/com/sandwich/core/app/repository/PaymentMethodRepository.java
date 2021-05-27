package com.sandwich.core.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sandwich.core.app.model.PaymentMethod;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {

	@Query(value = "SELECT C FROM PaymentMethod C WHERE C.name=:tmpName")
	PaymentMethod findByProductCode(@Param("tmpName") String name);
}
