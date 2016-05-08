package com.tgr.fwk.dto;

import java.io.Serializable;

import com.tgr.fwk.model.AbstractModel;

public abstract class AbstractResponse<MODEL extends AbstractModel> implements Serializable {

	private static final long serialVersionUID = -4348534468345480875L;

	private MODEL model;
	
	public MODEL getModel() {
		return model;
	}
	
	public void setModel(MODEL model) {
		this.model = model;
	}
}
