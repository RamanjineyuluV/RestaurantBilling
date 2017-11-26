package com.restaurantbilling.exceptions;


public class ExistingOrderException extends RuntimeException {

	private static final long serialVersionUID = 3124208863340564696L;

	public ExistingOrderException(Throwable t) {
		super(t);
	}

	public ExistingOrderException(String msg) {
		super(msg);
	}

	public ExistingOrderException(Throwable t, String msg) {
		super(msg);
	}

	public ExistingOrderException() {
		super();
	}

}
