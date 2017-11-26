package com.restaurantbilling.model;

import javax.persistence.Embeddable;

@Embeddable
public class CalcOutput {

	private int discount;
	private int tax;
	private int total;
	
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getTax() {
		return tax;
	}
	public void setTax(int tax) {
		this.tax = tax;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
}
