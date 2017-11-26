package com.restaurantbilling.calcs.impl;

import com.restaurantbilling.calcs.CalcUtil;
import com.restaurantbilling.model.CustomerOrder;

public class TotalUtil implements CalcUtil {

	private final CustomerOrder custOrder;
	
	public TotalUtil(CustomerOrder custOrder) {
		this.custOrder = custOrder;
	}
	
	@Override
	public int doCalcs() {
		return custOrder.getCalcOutput().getTax()
				+ custOrder.getOrderInput().getSubtotal()
				- custOrder.getCalcOutput().getDiscount();

	}

}
