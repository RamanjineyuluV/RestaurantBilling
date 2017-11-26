package com.restaurantbilling.model;

import javax.persistence.Embeddable;

@Embeddable
public class OrderInput {
	
	private String name;
	private Arrangement arrangement;
	private int subtotal;
	
	public OrderInput() {}
	
	public OrderInput(String name, Arrangement arrangement, int subtotal) {
		this.name=name;
		this.arrangement=arrangement;
		this.subtotal=subtotal;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Arrangement getArrangement() {
		return arrangement;
	}

	public void setArrangement(Arrangement arrangement) {
		this.arrangement = arrangement;
	}

	public int getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}


}
