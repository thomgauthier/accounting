package com.tgr.fwk.dto;

import java.io.Serializable;

public class BooleanResponse implements Serializable {

	private static final long serialVersionUID = 8526381729805261859L;

	private Boolean result;
	
	public BooleanResponse() {
		
	}
	
	public BooleanResponse(Boolean result) {
		this.result = result;
	}

	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}
}
