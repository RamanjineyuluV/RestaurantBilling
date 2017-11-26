package com.restaurantbilling.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurantbilling.calcs.CalcUtil;
import com.restaurantbilling.calcs.impl.DiscountUtil;
import com.restaurantbilling.calcs.impl.GstUtil;
import com.restaurantbilling.calcs.impl.TotalUtil;
import com.restaurantbilling.model.CalcOutput;
import com.restaurantbilling.model.CustomerOrder;
import com.restaurantbilling.model.OrderInput;
import com.restaurantbilling.service.CalcService;
import com.restaurantbilling.service.CustomerOrderService;

@Service
public class CalcServiceImpl implements CalcService {

	@Autowired
	CustomerOrderService cos;

	@Override
	public CustomerOrder getBillCalcs(OrderInput input) {

		CalcOutput output = new CalcOutput();

		//discount
		CalcUtil d = new DiscountUtil(input.getSubtotal());
		output.setDiscount(d.doCalcs());

		CustomerOrder custOrder = new CustomerOrder(input, output);

		//gst
		CalcUtil g = new GstUtil(custOrder);
		custOrder.getCalcOutput().setTax(g.doCalcs());

		//total
		CalcUtil t = new TotalUtil(custOrder);
		custOrder.getCalcOutput().setTotal(t.doCalcs());

		return custOrder;

	}

}
