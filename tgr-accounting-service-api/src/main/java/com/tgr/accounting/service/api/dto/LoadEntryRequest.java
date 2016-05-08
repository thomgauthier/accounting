package com.tgr.accounting.service.api.dto;

import com.tgr.fwk.dto.IdRequest;

public class LoadEntryRequest extends IdRequest<Long> {

	private static final long serialVersionUID = 1577817901840183223L;

	public LoadEntryRequest() {

	}

	public LoadEntryRequest(Long id) {
		setId(id);
	}
}
