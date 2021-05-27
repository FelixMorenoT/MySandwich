package com.sandwich.core.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sandwich.core.app.model.Carrier;

public interface CarrierRepository extends JpaRepository<Carrier, Long>  {

	@Query(value = "SELECT C FROM Carrier C WHERE C.carrierName=:tmpCarrierName")
	Carrier findByProductCode(@Param("tmpCarrierName") String carrierName);
}
