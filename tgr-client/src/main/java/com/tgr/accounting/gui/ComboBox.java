package com.tgr.accounting.gui;

import javax.swing.JComboBox;

public class ComboBox<T> extends JComboBox<T> {

	private static final long serialVersionUID = -8214974729130918953L;

	public ComboBox() {
		super();
	}
	
	@SuppressWarnings("unchecked")
	public T getSelectedValue() {
		return (T)getSelectedItem();
	}
}
