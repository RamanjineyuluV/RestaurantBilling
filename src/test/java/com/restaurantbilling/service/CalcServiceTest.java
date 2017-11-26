package com.restaurantbilling.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.restaurantbilling.model.Arrangement;
import com.restaurantbilling.model.CustomerOrder;
import com.restaurantbilling.model.OrderInput;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalcServiceTest {

	@Autowired
	CalcService c;

	private OrderInput o;

	private CustomerOrder cus;

	@Test
	public void getBillCalcsTest() {
		OrderInput o = new OrderInput();
		o.setName("Peter Pan");
		o.setArrangement(Arrangement.Outdoor);
		o.setSubtotal(1000);
		CustomerOrder cus = new CustomerOrder();

		cus = c.getBillCalcs(o);

		assertEquals(0, cus.getCalcOutput().getDiscount());
		assertEquals(180, cus.getCalcOutput().getTax());
		assertEquals(1180, cus.getCalcOutput().getTotal());

	}

	@Test
	public void getBillCalcsTestA() {
		OrderInput o = new OrderInput();
		o.setName("Peter Pan");
		o.setArrangement(Arrangement.Outdoor);
		o.setSubtotal(0);
		CustomerOrder cus = new CustomerOrder();

		cus = c.getBillCalcs(o);

		assertEquals(0, cus.getCalcOutput().getDiscount());
		assertEquals(0, cus.getCalcOutput().getTax());
		assertEquals(0, cus.getCalcOutput().getTotal());
	}

	@Test
	public void getBillCalcsTestB() {
		OrderInput o = new OrderInput();
		o.setName("Peter Pan");
		o.setArrangement(Arrangement.Standard);
		o.setSubtotal(3000);
		CustomerOrder cus = new CustomerOrder();

		cus = c.getBillCalcs(o);

		assertEquals(100, cus.getCalcOutput().getDiscount());
		assertEquals(145, cus.getCalcOutput().getTax());
		assertEquals(3045, cus.getCalcOutput().getTotal());

	}
}