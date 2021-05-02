package com.cg.exception;

public class BedNotfoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;
	public BedNotfoundException(String msg) {
		// TODO Auto-generated constructor stub
		this.message=msg;
	}
	public String getMessage() {
		return message;
	}
	
	

}
