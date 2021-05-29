package com.sandwich.core.app.service;

import com.sandwich.core.app.dto.OrderDTO;
import com.sandwich.core.app.pojo.OrderResponse;

public interface IOrderService {

	public OrderResponse createOrder(OrderDTO requestOrder);
}
