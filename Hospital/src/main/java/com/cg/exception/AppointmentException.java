package com.cg.exception;

public class AppointmentException extends RuntimeException{
	   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;
	public AppointmentException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
		
	}
	
}