package com.tgr.accounting.gui;

import javax.swing.JPanel;
import javax.swing.UIManager;

public class Panel extends JPanel {

	private static final long serialVersionUID = 4437815001841690745L;

	private Frame frame;
	
	public Panel(Frame frame) {
		this.frame = frame;
		
		setSize(frame.getSize());
		setSystemLookAndFeel();
	}

	public Frame getFrame() {
		return frame;
	}
	
	protected static void setSystemLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception exc) {
			System.err.println("Error loading L&F: " + exc);
		}
	}
}
