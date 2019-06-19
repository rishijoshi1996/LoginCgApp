package com.cgapp.exception;

public class ErrorResponse {

	private String errorcode;
	private String message;
	public ErrorResponse() {
	}
	
	public ErrorResponse(String errorcode, String message) {
		super();
		this.errorcode = errorcode;
		this.message = message;
	}

	public String getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	
	
}
