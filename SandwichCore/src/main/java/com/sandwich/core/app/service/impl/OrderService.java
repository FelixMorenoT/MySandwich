package com.sandwich.core.app.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandwich.core.app.dto.OrderDTO;
import com.sandwich.core.app.dto.OrderDetailsDTO;
import com.sandwich.core.app.exception.type.ProductNoFoundException;
import com.sandwich.core.app.model.Order;
import com.sandwich.core.app.model.OrderDetail;
import com.sandwich.core.app.pojo.OrderResponse;
import com.sandwich.core.app.pojo.StandardReponse;
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
	public OrderResponse createOrder(OrderDTO requestOrder) {
		Double amount = 0.0;
		Order tmpOrder = null ;

		var tmpClient = clientService.findClientByMail(requestOrder.getOrderClientMail());
		
		if(tmpClient.getId() != null) {
			try {
				
				List<OrderDetailsDTO> tmpOrderDetailsDTO = requestOrder.getOrderDetails();
				List<OrderDetail> tmpOrderDetailsModel = new ArrayList<>();
				
				for (var orderDetail : tmpOrderDetailsDTO) {
					var tmpProduct = productService.findByProductCode(orderDetail.getOrderProductCode());
					
					tmpOrderDetailsModel.add(OrderDetail.builder()
							.orderDetailProductCode(tmpProduct.getCode())		
							.orderDetailProductPrice(tmpProduct.getPrice())
							.orderDetailQuantity(orderDetail.getOrderQuantity())
							.build());
					
					amount += tmpProduct.getPrice();
		
				}
				
				tmpOrder = orderRepository.save(Order.builder()
						.orderClientMail(tmpClient.getClientMail())
						.orderDetail(tmpOrderDetailsModel)
						.orderTotalAmount(amount)
						.orderDate(LocalDate.now())
						.orderDestination(tmpClient.getClientAddress())
						.orderIdfranchise((long) 1)
						.orderStatus(OrderStatus.CREATED.toString())										
						.build());
				
				return  OrderResponse.builder()
							.orderId(tmpOrder.getOrderId())
							.standardReponse(new StandardReponse().getReponse(201, "Orden CREADA"))
							.build();
				
			} catch (ProductNoFoundException e) {
				e.printStackTrace();
			}
		} 
		
		
		return new OrderResponse();
	}

}
