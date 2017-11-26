package com.restaurantbilling.service;

import java.util.List;

import com.restaurantbilling.model.CustomerOrder;

public interface CustomerOrderService {
	
	List<CustomerOrder> findAll();

	CustomerOrder save(CustomerOrder o);

	void delete(Long id);


}
