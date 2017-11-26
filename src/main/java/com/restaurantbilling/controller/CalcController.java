package com.restaurantbilling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restaurantbilling.model.CustomerOrder;
import com.restaurantbilling.model.OrderInput;
import com.restaurantbilling.service.CalcService;

@RestController
@RequestMapping("/calcs")
public class CalcController {

	@Autowired
	CalcService service;

	@RequestMapping(method = RequestMethod.POST)
	public CustomerOrder getBillCalcs(@RequestBody OrderInput o) {
		return service.getBillCalcs(o);

	}
}
