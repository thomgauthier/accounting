package com.tgr.accounting.gui;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;

import com.tgr.accounting.format.DoubleFormatFactory;

public class AmountField extends JFormattedTextField {

	private static final long serialVersionUID = 8279775363124889039L;

	public AmountField() {
		super(DoubleFormatFactory.getFormat());
		setHorizontalAlignment(SwingConstants.RIGHT);
		setPreferredSize(new Dimension(70, 25));
		
		addKeyListener(new KeyListener() {

			public void keyTyped(KeyEvent e) {

			}

			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == 110) {
					switchSeparator(getText());
				}
			}

			private void switchSeparator(String text) {
				if (text == null) {
					return;
				}
				if (!text.endsWith(".")) {
					return;
				}
				text = text.substring(0, text.length() - 1) + ",";
				setText(text);
			}

			public void keyPressed(KeyEvent e) {

			}
		});
	}
	
	public Double getDoubleValue() {
		Object value = getValue();
		if (value instanceof Long) {
			return ((Long)value).doubleValue(); 
		}
		if (value instanceof Double) {
			return (Double)value;
		}
		return null;
	}
}
