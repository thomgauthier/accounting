package com.tgr.accounting.service.api.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.tgr.accounting.service.api.type.AmountType;
import com.tgr.accounting.service.api.type.PaymentType;
import com.tgr.fwk.model.AbstractModel;

public class EntryModel extends AbstractModel {

	private static final long serialVersionUID = 3251846420842975509L;

	private Long id;
	private Double amount;
	private AmountType amountType;
	private Integer day;
	private Integer month;
	private Integer year;
	private PaymentType paymentType;
	private String axis1;
	private String axis2;
	private String axis3;

	public EntryModel() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotNull
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@NotNull
	public AmountType getAmountType() {
		return amountType;
	}

	public void setAmountType(AmountType amountType) {
		this.amountType = amountType;
	}

	@NotNull
	@Min(1)
	@Max(31)
	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	@NotNull
	@Min(1)
	@Max(12)
	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	@NotNull
	@Min(1)
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@NotNull
	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public String getAxis1() {
		return axis1;
	}

	public void setAxis1(String axis1) {
		this.axis1 = axis1;
	}

	public String getAxis2() {
		return axis2;
	}

	public void setAxis2(String axis2) {
		this.axis2 = axis2;
	}

	public String getAxis3() {
		return axis3;
	}

	public void setAxis3(String axis3) {
		this.axis3 = axis3;
	}

}
