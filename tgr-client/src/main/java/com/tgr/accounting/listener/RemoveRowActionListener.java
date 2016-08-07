package com.tgr.accounting.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.tgr.accounting.gui.InputDataPanel;
import com.tgr.accounting.gui.InputDataRow;

public class RemoveRowActionListener implements ActionListener {

	private InputDataPanel panel;
	private InputDataRow row;
	
	public RemoveRowActionListener(InputDataPanel panel, InputDataRow row) {
		this.panel = panel;
		this.row = row;
	}
	
	public void actionPerformed(ActionEvent e) {
		panel.removeInputRow(row);
	}

}
