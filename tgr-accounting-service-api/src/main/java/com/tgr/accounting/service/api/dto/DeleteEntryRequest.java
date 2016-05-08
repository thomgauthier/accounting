package com.tgr.accounting.service.api.dto;

import com.tgr.fwk.dto.IdRequest;

public class DeleteEntryRequest extends IdRequest<Long> {

	private static final long serialVersionUID = 5194679592471119828L;

	public DeleteEntryRequest() {

	}

	public DeleteEntryRequest(Long id) {
		setId(id);
	}
}
