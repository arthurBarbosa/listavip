package com.example.demo.service.exception;

public class ExistingGuest extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ExistingGuest(String message) {
		super(message);
	}

}
