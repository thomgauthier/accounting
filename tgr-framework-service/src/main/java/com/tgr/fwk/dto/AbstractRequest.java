package com.tgr.fwk.dto;

import java.io.Serializable;

import com.tgr.fwk.model.AbstractModel;

public abstract class AbstractRequest<MODEL extends AbstractModel> implements Serializable {

	private static final long serialVersionUID = -6301636223706020049L;

	private MODEL model;
	
	public MODEL getModel() {
		return model;
	}
	
	public void setModel(MODEL model) {
		this.model = model;
	}
}
