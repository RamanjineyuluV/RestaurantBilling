package com.restaurantbilling.exceptions;

public class InsufficientDataException extends RuntimeException {
	
	private static final long serialVersionUID = 7111080709978074325L;

	public InsufficientDataException(Throwable t) {
		super (t);
	}
	
	public InsufficientDataException(String msg) {
		super (msg);
	}
	
	public InsufficientDataException(Throwable t, String msg) {
		super (msg);
	}
	
	public InsufficientDataException() {
		super ();
	}
	

}
