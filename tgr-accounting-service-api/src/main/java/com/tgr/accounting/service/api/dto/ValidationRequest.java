package com.tgr.accounting.service.api.dto;

import com.tgr.accounting.service.api.model.EntryModel;
import com.tgr.fwk.dto.AbstractRequest;

public class ValidationRequest extends AbstractRequest<EntryModel> {

	private static final long serialVersionUID = 8507748376451845066L;

	public ValidationRequest() {
		
	}
	
	public ValidationRequest(EntryModel model) {
		setModel(model);
	}
}
