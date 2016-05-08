package com.tgr.fwk.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public abstract class AbstractModel implements Serializable {

	private static final long serialVersionUID = -596333632153989141L;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
