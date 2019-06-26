package com.cgapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class LoginException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginException(String message) {
		super("Employee not found for userid : " +message);
		// TODO Auto-generated constructor stub
	}

	
}
