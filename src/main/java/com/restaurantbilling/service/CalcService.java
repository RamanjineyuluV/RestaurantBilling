package com.restaurantbilling.service;

import com.restaurantbilling.model.CustomerOrder;
import com.restaurantbilling.model.OrderInput;

public interface CalcService {

	CustomerOrder getBillCalcs(OrderInput o);

}
