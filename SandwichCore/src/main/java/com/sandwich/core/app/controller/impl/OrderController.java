package com.sandwich.core.app.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandwich.core.app.controller.IOrderController;
import com.sandwich.core.app.dto.OrderDTO;
import com.sandwich.core.app.pojo.OrderResponse;
import com.sandwich.core.app.service.IOrderService;

@RestController
@RequestMapping("/api")
public class OrderController implements IOrderController{

	@Autowired
	private IOrderService orderService;
	
	@Override
	public ResponseEntity<OrderResponse> createOrder(OrderDTO order) {
		
		var response = orderService.createOrder(order);
		
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStandardReponse().getResponseCode()));
	}
}
