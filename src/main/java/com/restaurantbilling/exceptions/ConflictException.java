package com.restaurantbilling.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.CONFLICT)
public class ConflictException extends RuntimeException {

	private static final long serialVersionUID = 6880865703542428921L;

	public ConflictException() {
	
	}
	
	public ConflictException(Throwable t) {
		super(t);
	}
	
}
