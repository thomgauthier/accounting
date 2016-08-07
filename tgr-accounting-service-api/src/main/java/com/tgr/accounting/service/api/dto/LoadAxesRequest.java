package com.tgr.accounting.service.api.dto;

import com.tgr.accounting.service.api.criteria.AxesCriteria;
import com.tgr.fwk.dto.AbstractSearchRequest;

public class LoadAxesRequest extends AbstractSearchRequest<AxesCriteria> {

	private static final long serialVersionUID = 778847729985868736L;

	public LoadAxesRequest() {

	}

	public LoadAxesRequest(AxesCriteria criteria) {
		setCriteria(criteria);
	}
}
