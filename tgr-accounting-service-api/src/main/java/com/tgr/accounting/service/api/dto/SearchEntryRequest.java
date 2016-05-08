package com.tgr.accounting.service.api.dto;

import com.tgr.accounting.service.api.criteria.EntryCriteria;
import com.tgr.fwk.dto.AbstractSearchRequest;

public class SearchEntryRequest extends AbstractSearchRequest<EntryCriteria> {

	private static final long serialVersionUID = 990256188360024103L;

	public SearchEntryRequest() {
		
	}
	
	public SearchEntryRequest(EntryCriteria criteria) {
		setCriteria(criteria);
	}
}
