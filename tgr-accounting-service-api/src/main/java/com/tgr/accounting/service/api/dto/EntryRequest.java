package com.tgr.accounting.service.api.dto;

import com.tgr.accounting.service.api.model.EntryModel;
import com.tgr.fwk.dto.AbstractRequest;

public class EntryRequest extends AbstractRequest<EntryModel> {

	private static final long serialVersionUID = 7797285674952544458L;

	public EntryRequest() {
		
	}
	
	public EntryRequest(EntryModel model) {
		setModel(model);
	}
}
