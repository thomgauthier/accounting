package com.tgr.accounting.service.api.model;

import java.util.ArrayList;
import java.util.List;

import com.tgr.fwk.model.AbstractModel;

public class ValidationModel extends AbstractModel {

	private static final long serialVersionUID = 4035252720416794948L;

	private List<String> errors = new ArrayList<String>();

	public ValidationModel() {

	}

	public ValidationModel(List<String> errors) {
		this.errors = errors;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

}
