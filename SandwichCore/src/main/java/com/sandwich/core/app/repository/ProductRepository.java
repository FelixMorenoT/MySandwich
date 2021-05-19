package com.sandwich.core.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sandwich.core.app.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value = "SELECT P FROM Product P WHERE P.productCode=:productCode")
	Product findByProductCode(@Param("productCode") Long productCode);
}
