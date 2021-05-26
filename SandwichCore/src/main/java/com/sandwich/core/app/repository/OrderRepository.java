package com.sandwich.core.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sandwich.core.app.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
