package com.tgr.accounting.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.tgr.accounting.listener.AddRowActionListener;
import com.tgr.accounting.listener.CommitRowActionListener;
import com.tgr.accounting.listener.RemoveRowActionListener;
import com.tgr.accounting.service.ClientAccountingService;
import com.tgr.accounting.service.api.criteria.AxesCriteria;
import com.tgr.accounting.service.api.model.EntryModel;
import com.tgr.accounting.service.api.type.AmountType;

public class InputDataRow extends Panel {

	private static final long serialVersionUID = 655944348682562349L;

	private LabelField labelCredit = new LabelField("Crédit");
	private LabelField labelDebit = new LabelField("Débit");
	private AmountField credit = new AmountField();
	private AmountField debit = new AmountField();
	private LabelField labelDate = new LabelField("Date");
	private DateField date = new DateField();
	private LabelField labelPaiement = new LabelField("Mode");
	private PaymentComboBox paymentComboBox = new PaymentComboBox();
	private LabelField labelAxe1 = new LabelField("Axe 1");
	private AxeComboBox axe1 = new AxeComboBox();
	private LabelField labelAxe2 = new LabelField("Axe 2");
	private AxeComboBox axe2 = new AxeComboBox();
	private LabelField labelAxe3 = new LabelField("Axe 3");
	private AxeComboBox axe3 = new AxeComboBox();
	private Button addRowButton = new Button("Add");
	private Button removeRowButton = new Button("Remove");
	private Button persistButton = new Button("Persist");
	
	private List<Component> components = new ArrayList<Component>();
	
	public InputDataRow(Frame frame, InputDataPanel panel) {
		super(frame);
		
		FlowLayout layout = new FlowLayout();
		layout.setHgap(5);
		setLayout(layout);
		
		addCheckedComponent(labelCredit);
		addCheckedComponent(credit);
		addCheckedComponent(labelDebit);
		addCheckedComponent(debit);
		addCheckedComponent(labelDate);
		addCheckedComponent(date);
		addCheckedComponent(labelPaiement);
		addCheckedComponent(paymentComboBox);
		addCheckedComponent(labelAxe1);
		populateAxes(axe1, AxesCriteria.AXE1);
		addCheckedComponent(axe1);
		addCheckedComponent(labelAxe2);
		populateAxes(axe2, AxesCriteria.AXE2);
		addCheckedComponent(axe2);
		addCheckedComponent(labelAxe3);
		populateAxes(axe3, AxesCriteria.AXE3);
		addCheckedComponent(axe3);
		add(addRowButton);
		addCheckedComponent(removeRowButton);
		addCheckedComponent(persistButton);
		
		addRowButton.addActionListener(new AddRowActionListener(panel));
		removeRowButton.addActionListener(new RemoveRowActionListener(panel, this));
		persistButton.addActionListener(new CommitRowActionListener(panel, this));
		
		Dimension dim = new Dimension();
		dim.setSize(getPreferredSize().getWidth(), 30);
		setPreferredSize(dim);
		updateUI();
		
	}
	
	private void populateAxes(AxeComboBox axeComboBox, int axe) {
		AxesCriteria criteria = new AxesCriteria();
		criteria.setAxe(axe);
		axeComboBox.addItem("");
		try {
			List<String> results = ClientAccountingService.getInstance().loadAxes(criteria);
			for (String axeName : results) {
				axeComboBox.addItem(axeName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void addCheckedComponent(Component component) {
		components.add(component);
		add(component);
	}
	
	public void assertResult(boolean success) {
		if (success) {
			persistButton.setBackground(Color.GREEN);
			// Disable all input fields
			for (Component component : components) {
				component.setEnabled(false);
			}
		} else {
			persistButton.setBackground(Color.RED);
		}
		updateUI();
	}
	
	public EntryModel getModel() {
		
		EntryModel newModel = new EntryModel();
		
		Double value = null;
		if (credit.getDoubleValue() != null) {
			value = credit.getDoubleValue();
			newModel.setAmountType(AmountType.INPUT);
		}
		if (debit.getDoubleValue() != null) {
			value = debit.getDoubleValue();
			newModel.setAmountType(AmountType.OUTPUT);
		}
		newModel.setAmount(value);
		newModel.setAxis1(axe1.getSelectedValue());
		newModel.setAxis2(axe2.getSelectedValue());
		newModel.setAxis3(axe3.getSelectedValue());
		Date dateValue = date.getDateValue();
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(dateValue);
		newModel.setDay(cal.get(GregorianCalendar.DAY_OF_MONTH));
		newModel.setMonth(cal.get(GregorianCalendar.MONTH) + 1);
		newModel.setYear(cal.get(GregorianCalendar.YEAR));
		newModel.setPaymentType(paymentComboBox.getSelectedValue());
		
		return newModel;
	}
}
