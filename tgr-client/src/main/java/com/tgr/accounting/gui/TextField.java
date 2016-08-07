package com.tgr.accounting.gui;

import javax.swing.JFormattedTextField;

public class TextField extends JFormattedTextField {

	private static final long serialVersionUID = -2791817627289980530L;

	public TextField() {
		super();
	}
	
	public String getStringValue() {
		return (String) getValue();
	}
}
