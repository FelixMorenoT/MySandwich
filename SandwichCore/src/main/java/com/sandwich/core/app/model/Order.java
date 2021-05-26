package com.sandwich.core.app.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sandwich.core.app.status.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "hist_orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	
	private String orderClientMail;
	
	private Long orderProductCode;
	
	private Double orderProductPrice;
	
	private Long orderQuantity;
	
	private Double orderTotalAmount;
	
	private LocalDate orderDate;
	
	private String orderDestination;
	
	private Long orderIdfranchise;
	
	private OrderStatus orderStatus;
	
}
