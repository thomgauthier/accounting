package com.tgr.accounting.gui;

import com.tgr.accounting.service.api.type.PaymentType;

public class PaymentComboBox extends ComboBox<PaymentType> {

	private static final long serialVersionUID = 6953890739438232566L;

	public PaymentComboBox() {
		super();
		for (PaymentType paymentType : PaymentType.values()) {
			addItem(paymentType);
		}
	}
}
