package com.tgr.accounting.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.tgr.fwk.entity.AbstractEntity;


@Entity
@Table(name = "SIT_COMPTE_COURANT")
@SequenceGenerator(name = "SEQ_SIT_COMPTE_COURANT_GENERATOR", initialValue = 1, allocationSize = 1, sequenceName = "SEQ_SIT_COMPTE_COURANT")
@AttributeOverrides({
	@AttributeOverride(name = "id", column = @Column(name = "SCC_IDENT")),
})
public class AnnualBalanceEntity extends AbstractEntity {

	private static final long serialVersionUID = 8441885596748398112L;

	private Integer year;
	private Double balance;
	
	public AnnualBalanceEntity() {
		
	}

	@Column(name = "SCC_YEAR", precision = 14, scale = 0)
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Column(name = "SCC_SITUATION", precision = 14, scale = 2)
	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
}
