package com.tgr.accounting.service.api.type;

public enum PaymentType {

	PA("PA"),
	VP("VP"),
	CB("CB"),
	RETRAIT("RETRAIT"),
	CH("CH"),
	PP("PP"),
	VA("VA");

	private String code;

	private PaymentType() {

	}

	private PaymentType(String code) {
		this.code = code;
	}

	public static PaymentType getByCode(String code) {
		for (PaymentType paymentType : values()) {
			if (paymentType.getCode().equals(code))
				return paymentType;
		}
		return null;
	}

	public String getCode() {
		return code;
	}
}
