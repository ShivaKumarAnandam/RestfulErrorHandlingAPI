package com.rest.eh;

public class UserAgeNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public UserAgeNotFoundException(String msg) {
		super(msg);
	}
}
