package com.restaurantbilling.dao;

import org.springframework.data.repository.CrudRepository;

import com.restaurantbilling.model.CustomerOrder;

public interface CustomerOrderRepository extends CrudRepository<CustomerOrder, Long>
{

	CustomerOrder findById( Long id);

}
