package com.sandwich.core.app.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandwich.core.app.dto.OrderDTO;
import com.sandwich.core.app.exception.type.ProductNoFoundException;
import com.sandwich.core.app.model.Order;
import com.sandwich.core.app.pojo.OrderResponse;
import com.sandwich.core.app.repository.OrderRepository;
import com.sandwich.core.app.service.IClienteSerive;
import com.sandwich.core.app.service.IOrderService;
import com.sandwich.core.app.service.IProductService;
import com.sandwich.core.app.status.OrderStatus;

@Service
public class OrderService implements IOrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private IClienteSerive clientService;
	
	@Autowired 
	private IProductService productService;
	
	@Override
	public OrderResponse createOrder(List<OrderDTO> requestOrder) {
		
		for (OrderDTO orderTmp : requestOrder) {
			var tmpClient = clientService.findClientByMail(orderTmp.getOrderClientMail());
			
			if(tmpClient.getId() != null) {
				try {
					var tmpProduct = productService.findByProductCode(orderTmp.getOrderProductCode());
					orderRepository.save(Order.builder()
											.orderClientMail(tmpClient.getClientMail())
											.orderProductCode(tmpProduct.getCode())
											.orderProductPrice(tmpProduct.getPrice())
											.orderQuantity(orderTmp.getOrderQuantity())
											.orderTotalAmount(tmpProduct.getPrice() * orderTmp.getOrderQuantity())
											.orderDate(LocalDate.now())
											.orderDestination(tmpClient.getClientAddress())
											.orderIdfranchise((long) 1)
											.orderStatus(OrderStatus.CREATED)										
											.build());
					
					return new OrderResponse();
				} catch (ProductNoFoundException e) {
					e.printStackTrace();
				}
			}
		}
		
		return new OrderResponse();
	}

}
