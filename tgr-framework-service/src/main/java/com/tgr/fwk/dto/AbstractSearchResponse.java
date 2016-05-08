package com.tgr.fwk.dto;

import java.io.Serializable;

public abstract class AbstractSearchResponse<List> implements Serializable {

	private static final long serialVersionUID = -1058899165203067977L;

	private List models;

	public List getModels() {
		return models;
	}

	public void setModels(List models) {
		this.models = models;
	}
}
