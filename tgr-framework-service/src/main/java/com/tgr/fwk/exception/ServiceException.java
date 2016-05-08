package com.tgr.fwk.exception;

import java.io.Serializable;

public class ServiceException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = -7608539447087153001L;

	public ServiceException() {
		super();
	}
	
	public ServiceException(String message) {
		super(message);
	}
	
	public ServiceException(Throwable t) {
		super(t);
	}
	
	public ServiceException(String message, Throwable t) {
		super(message, t);
	}
}
