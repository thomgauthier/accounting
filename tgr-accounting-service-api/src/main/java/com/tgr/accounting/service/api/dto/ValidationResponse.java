package com.tgr.accounting.service.api.dto;

import com.tgr.accounting.service.api.model.ValidationModel;
import com.tgr.fwk.dto.AbstractResponse;

public class ValidationResponse extends AbstractResponse<ValidationModel> {

	private static final long serialVersionUID = -8866348914449048217L;

	public ValidationResponse() {

	}

	public ValidationResponse(ValidationModel model) {
		setModel(model);
	}
}
