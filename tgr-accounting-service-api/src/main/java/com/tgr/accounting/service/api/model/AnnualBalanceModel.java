package com.tgr.accounting.service.api.model;

import com.tgr.fwk.model.AbstractModel;

public class AnnualBalanceModel extends AbstractModel {

	private static final long serialVersionUID = 5360884009531029990L;

	private Integer year;
	private Double balance;
	
	public AnnualBalanceModel() {
		
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
}
