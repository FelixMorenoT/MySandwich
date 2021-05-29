package com.sandwich.core.app.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sandwich.core.app.dto.OrderDTO;
import com.sandwich.core.app.pojo.OrderResponse;

public interface IOrderController {

	@PostMapping("/order")
	public ResponseEntity<OrderResponse> createOrder(@Valid @RequestBody OrderDTO order);
}
