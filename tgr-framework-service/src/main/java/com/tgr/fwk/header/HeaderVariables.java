package com.tgr.fwk.header;

public enum HeaderVariables {

	LOGIN("login"),
	PASSWORD("password");
	
	private String variable;
	
	private HeaderVariables(String variable) {
		this.variable = variable;
	}
	
	public String get() {
		return this.variable;
	}
}
