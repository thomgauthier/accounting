package com.tgr.accounting.service.api.dto;

import java.util.List;

import com.tgr.accounting.service.api.model.EntryModel;
import com.tgr.fwk.dto.AbstractSearchResponse;

public class SearchEntryResponse extends AbstractSearchResponse<List<EntryModel>> {

	private static final long serialVersionUID = 6966473670052461738L;

	public SearchEntryResponse() {
		
	}
	
	public SearchEntryResponse(List<EntryModel> models) {
		setModels(models);
	}
}
