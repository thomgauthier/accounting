package com.tgr.fwk.exception;

public class NoDataFoundException extends Exception {

	private static final long serialVersionUID = -656185748420566793L;

	public NoDataFoundException() {
		super();
	}
	
	public NoDataFoundException(String message) {
		super(message);
	}
	
	public NoDataFoundException(Throwable t) {
		super(t);
	}
	
	public NoDataFoundException(String message, Throwable t) {
		super(message, t);
	}
}
