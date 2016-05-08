package com.tgr.fwk.dto;

import java.io.Serializable;

public class IdRequest<ID> implements Serializable {

	private static final long serialVersionUID = -6797073416269310591L;

	private ID id;

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}
}
