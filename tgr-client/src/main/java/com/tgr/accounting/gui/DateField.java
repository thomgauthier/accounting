package com.tgr.accounting.gui;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFormattedTextField;

import com.tgr.accounting.format.DateFormatFactory;

public class DateField extends JFormattedTextField {

	private static final long serialVersionUID = -1372247636146654328L;

	public DateField() {
		super(DateFormatFactory.getFormat());
		
		addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent e) {
				
			}
			
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() > 96 && e.getKeyCode() < 110) {
					addSeparator(getText());
				}
			}
			
			private void addSeparator(String text) {
				if (text == null) {
					return;
				}
				if (text.endsWith("/")) {
					return;
				}
				String newText = text;
				if (text.length() == 2 || text.length() == 5) {
					newText += "/";
				}
				if (text.length() == 5) {
					GregorianCalendar cal = new GregorianCalendar();
					newText += cal.get(GregorianCalendar.YEAR);
				}
				setText(newText);
			}
			
			public void keyPressed(KeyEvent e) {
				
			}
		});
		
		setPreferredSize(new Dimension(70, 25));
	}
	
	public Date getDateValue() {
		return (Date) getValue();
	}
	
}
