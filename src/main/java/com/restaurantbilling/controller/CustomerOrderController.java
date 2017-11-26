package com.restaurantbilling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restaurantbilling.exceptions.BadRequestException;
import com.restaurantbilling.exceptions.ConflictException;
import com.restaurantbilling.exceptions.ExistingOrderException;
import com.restaurantbilling.exceptions.InsufficientDataException;
import com.restaurantbilling.model.CustomerOrder;
import com.restaurantbilling.service.CustomerOrderService;

@RestController
@RequestMapping("/orders")
public class CustomerOrderController {

	@Autowired
	private CustomerOrderService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<CustomerOrder> getList() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public CustomerOrder create(@RequestBody CustomerOrder o) {
		try {
			return service.save(o);
		} catch (InsufficientDataException e) {
			throw new BadRequestException();
		} catch (ExistingOrderException e) {
			throw new ConflictException();
		}

	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		service.delete(id);

	}

}
