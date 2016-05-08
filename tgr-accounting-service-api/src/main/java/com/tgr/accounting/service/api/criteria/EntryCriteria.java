package com.tgr.accounting.service.api.criteria;

import java.util.ArrayList;
import java.util.List;

import com.tgr.accounting.service.api.type.AmountType;
import com.tgr.accounting.service.api.type.PaymentType;
import com.tgr.fwk.criteria.AbstractCriteria;

public class EntryCriteria extends AbstractCriteria {

	private static final long serialVersionUID = 3307113665741643052L;

	private Double amountMin;
	private Double amountMax;
	private AmountType amountType;
	private Integer startDay;
	private Integer endDay;
	private Integer startMonth;
	private Integer endMonth;
	private Integer startYear;
	private Integer endYear;
	private List<PaymentType> paymentTypes = new ArrayList<PaymentType>();
	private String axis1Like;
	private String axis2Like;
	private String axis3Like;

	public EntryCriteria() {

	}

	public Double getAmountMin() {
		return amountMin;
	}

	public void setAmountMin(Double amountMin) {
		this.amountMin = amountMin;
	}

	public Double getAmountMax() {
		return amountMax;
	}

	public void setAmountMax(Double amountMax) {
		this.amountMax = amountMax;
	}

	public AmountType getAmountType() {
		return amountType;
	}

	public void setAmountType(AmountType amountType) {
		this.amountType = amountType;
	}

	public Integer getStartDay() {
		return startDay;
	}

	public void setStartDay(Integer startDay) {
		this.startDay = startDay;
	}

	public Integer getEndDay() {
		return endDay;
	}

	public void setEndDay(Integer endDay) {
		this.endDay = endDay;
	}

	public Integer getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(Integer startMonth) {
		this.startMonth = startMonth;
	}

	public Integer getEndMonth() {
		return endMonth;
	}

	public void setEndMonth(Integer endMonth) {
		this.endMonth = endMonth;
	}

	public Integer getStartYear() {
		return startYear;
	}

	public void setStartYear(Integer startYear) {
		this.startYear = startYear;
	}

	public Integer getEndYear() {
		return endYear;
	}

	public void setEndYear(Integer endYear) {
		this.endYear = endYear;
	}

	public List<PaymentType> getPaymentTypes() {
		return paymentTypes;
	}

	public void setPaymentTypes(List<PaymentType> paymentTypes) {
		this.paymentTypes = paymentTypes;
	}

	public String getAxis1Like() {
		return axis1Like;
	}

	public void setAxis1Like(String axis1Like) {
		this.axis1Like = axis1Like;
	}

	public String getAxis2Like() {
		return axis2Like;
	}

	public void setAxis2Like(String axis2Like) {
		this.axis2Like = axis2Like;
	}

	public String getAxis3Like() {
		return axis3Like;
	}

	public void setAxis3Like(String axis3Like) {
		this.axis3Like = axis3Like;
	}

}
