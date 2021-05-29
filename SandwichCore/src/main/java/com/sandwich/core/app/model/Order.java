package com.sandwich.core.app.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	
	private String orderClientMail;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<OrderDetail> orderDetail;
	
	private Double orderTotalAmount;
	
	private LocalDate orderDate;
	
	private String orderDestination;
	
	private Long orderIdfranchise;
	
	private String orderStatus;
	
}
