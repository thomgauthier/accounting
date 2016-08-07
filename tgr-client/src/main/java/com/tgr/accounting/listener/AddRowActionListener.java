package com.tgr.accounting.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.tgr.accounting.gui.InputDataPanel;

public class AddRowActionListener implements ActionListener {

	private InputDataPanel panel;
	
	public AddRowActionListener(InputDataPanel panel) {
		this.panel = panel;
	}
	
	public void actionPerformed(ActionEvent e) {
		panel.addInputRow();
	}

}
