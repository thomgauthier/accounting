package com.tgr.accounting.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.tgr.accounting.service.api.type.PaymentType;
import com.tgr.fwk.entity.AbstractEntity;


@Entity
@Table(name = "COMPTE_COURANT")
@SequenceGenerator(name = "SEQ_COMPTE_COURANT_GENERATOR", initialValue = 1, allocationSize = 1, sequenceName = "SEQ_COMPTE_COURANT")
@AttributeOverrides({
	@AttributeOverride(name = "id", column = @Column(name = "CC_IDENT")),
})
public class EntryEntity extends AbstractEntity {

	private static final long serialVersionUID = 3077585741999227133L;

	private Double output;
	private Double input;
	private Integer day;
	private Integer month;
	private Integer year;
	private PaymentType paymentType;
	private String axis1;
	private String axis2;
	private String axis3;

	public EntryEntity() {
		
	}
	
	@Column(name = "CC_OUTPUT", precision = 14, scale = 2)
	public Double getOutput() {
		return output;
	}

	public void setOutput(Double output) {
		this.output = output;
	}

	@Column(name = "CC_INPUT", precision = 14, scale = 2)
	public Double getInput() {
		return input;
	}

	public void setInput(Double input) {
		this.input = input;
	}

	@Column(name = "CC_DAY", precision = 14, scale = 0)
	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	@Column(name = "CC_MONTH", precision = 14, scale = 0)
	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	@Column(name = "CC_YEAR", precision = 14, scale = 0)
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "CC_PAYMENT", length = 10)
	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	@Column(name = "CC_AXE_1", length = 20)
	public String getAxis1() {
		return axis1;
	}

	public void setAxis1(String axis1) {
		this.axis1 = axis1;
	}

	@Column(name = "CC_AXE_2", length = 20)
	public String getAxis2() {
		return axis2;
	}

	public void setAxis2(String axis2) {
		this.axis2 = axis2;
	}

	@Column(name = "CC_AXE_3", length = 20)
	public String getAxis3() {
		return axis3;
	}

	public void setAxis3(String axis3) {
		this.axis3 = axis3;
	}

}
