package com.restaurantbilling.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CustomerOrder {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Embedded
	private OrderInput orderInput;
	
	@Embedded
	private CalcOutput calcOutput;
	
	public CustomerOrder() {}

	public CustomerOrder(final OrderInput orderInput) {
		this(orderInput, null);
	}
	
	public CustomerOrder(final OrderInput orderInput,  CalcOutput calcOutput) {
		this.orderInput = orderInput;
		this.calcOutput = calcOutput;
		
	}
	
	public Long getId() {
		return id;
	}
	
	public OrderInput getOrderInput() {
		return orderInput;
	}

	public void setOrderInput(OrderInput orderInput) {
		this.orderInput = orderInput;
	}

	public CalcOutput getCalcOutput() {
		return calcOutput;
	}

	public void setCalcOutput(CalcOutput calcOutput) {
		this.calcOutput = calcOutput;
	}
	
}
