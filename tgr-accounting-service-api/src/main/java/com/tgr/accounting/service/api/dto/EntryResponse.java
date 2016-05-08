package com.tgr.accounting.service.api.dto;

import com.tgr.accounting.service.api.model.EntryModel;
import com.tgr.fwk.dto.AbstractResponse;

public class EntryResponse extends AbstractResponse<EntryModel> {

	private static final long serialVersionUID = 5817179126077326151L;

	public EntryResponse() {
		
	}
	
	public EntryResponse(EntryModel model) {
		setModel(model);
	}
}
