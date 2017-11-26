package com.restaurantbilling.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.restaurantbilling.dao.CustomerOrderRepository;
import com.restaurantbilling.exceptions.ExistingOrderException;
import com.restaurantbilling.exceptions.InsufficientDataException;
import com.restaurantbilling.model.CustomerOrder;
import com.restaurantbilling.service.CustomerOrderService;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

	@Autowired
	private CustomerOrderRepository cor;

	@Override
	public List<CustomerOrder> findAll() {
		return (List<CustomerOrder>) cor.findAll();
	}

	@Override
	public CustomerOrder save(CustomerOrder o) {
		if (cor.findById(o.getId()) == null) {
			if (StringUtils.isEmpty(o.getOrderInput().getName()) || StringUtils.isEmpty(o.getOrderInput().getArrangement())) {
				throw new InsufficientDataException();
			}
			return cor.save(o);
		} else {
			throw new ExistingOrderException();
		}

	}

	@Override
	public void delete(Long id) {
		cor.delete(id);
		
	}

}
