package com.tgr.fwk.dto;

import java.io.Serializable;

import com.tgr.fwk.criteria.AbstractCriteria;

public abstract class AbstractSearchRequest<CRITERIA extends AbstractCriteria> implements Serializable {

	private static final long serialVersionUID = 1740865435757575775L;

	private CRITERIA criteria;

	public CRITERIA getCriteria() {
		return criteria;
	}

	public void setCriteria(CRITERIA criteria) {
		this.criteria = criteria;
	}
	
}
