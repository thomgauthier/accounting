package com.tgr.accounting.gui;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LabelField extends JLabel {

	private static final long serialVersionUID = 636044389048203443L;

	public LabelField(String label) {
		super(label);
		setHorizontalAlignment(SwingConstants.RIGHT);
	}
}
