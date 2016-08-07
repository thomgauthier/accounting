package com.tgr.accounting.gui;

import javax.swing.BoxLayout;

import com.tgr.accounting.service.ClientAccountingService;

public class InputDataPanel extends Panel {

	private static final long serialVersionUID = 7764535173106933829L;

	private BoxLayout layout;
	
	public InputDataPanel(Frame frame) {
		super(frame);
		setSize(getFrame().getSize());
		layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(layout);
		
		addInputRow();
	}
	
	public void addInputRow() {
		add(new InputDataRow(getFrame(), this));
		updateUI();
	}
	
	public void removeInputRow(InputDataRow row) {
		remove(row);
		updateUI();
	}
	
	public boolean commitInputRow(InputDataRow row) {
		ClientAccountingService service = ClientAccountingService.getInstance();
		
		try {
			service.addEntry(row.getModel());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
