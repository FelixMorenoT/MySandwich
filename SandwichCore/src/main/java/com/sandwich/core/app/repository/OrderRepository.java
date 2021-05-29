package com.sandwich.core.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sandwich.core.app.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

	@Query("SELECT O FROM Order O WHERE O.orderClientMail=:clientMail")
	List<Order> findOrderByClientMail(@Param("clientMail") String clientMail);
}
