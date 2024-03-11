package com.igorgomes.workshopmongo.services.exception;

public class ObjectoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ObjectoNotFoundException(String msg) {
		super(msg);
	}

}
