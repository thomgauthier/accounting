package com.tgr.accounting.gui;

import java.awt.Dimension;

import javax.swing.JButton;

import com.tgr.accounting.resources.ResourcesHandler;

public class Button extends JButton {

	private static final long serialVersionUID = 1952495372110560680L;
	
	public Button() {
		this(null, null);
	}
	
	public Button(String text) {
		this(text, null);
	}
	
	public Button(String text, String icon) {
		super(text, icon != null ? ResourcesHandler.getInstance().getIcon(icon) : null);
		setPreferredSize(new Dimension(80, 25));
	}
	
}
