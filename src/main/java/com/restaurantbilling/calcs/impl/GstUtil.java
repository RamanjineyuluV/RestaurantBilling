package com.restaurantbilling.calcs.impl;

import com.restaurantbilling.calcs.CalcUtil;
import com.restaurantbilling.constants.Constants;
import com.restaurantbilling.exceptions.InsufficientDataException;
import com.restaurantbilling.model.CustomerOrder;

public class GstUtil implements CalcUtil{

	private final CustomerOrder custOrder;

	public GstUtil(CustomerOrder custOrder) {
		this.custOrder = custOrder;
	}

	
	public int doCalcs () {
		int val = Constants.ZERO;
		switch (custOrder.getOrderInput().getArrangement()) {
		case Standard:
			val= (int) (Constants.FIVE_PERCENT
					* (custOrder.getOrderInput().getSubtotal() - custOrder.getCalcOutput().getDiscount()));

			break;

		case Premium:
			val=(int) (Constants.EIGHTEEN_PERCENT
					* (custOrder.getOrderInput().getSubtotal() - custOrder.getCalcOutput().getDiscount()));
			break;

		case Outdoor:
			val=(int) (Constants.EIGHTEEN_PERCENT
					* (custOrder.getOrderInput().getSubtotal() - custOrder.getCalcOutput().getDiscount()));
			break;

		default:
			throw new InsufficientDataException();
		}

		
		return val;
	}

}
