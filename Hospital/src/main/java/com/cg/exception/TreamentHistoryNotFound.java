package com.cg.exception;

public class TreamentHistoryNotFound extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;
	public TreamentHistoryNotFound() {
	}
	
	public TreamentHistoryNotFound(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	

}
