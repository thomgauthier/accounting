package com.tgr.accounting.service.api.dto;

import java.util.List;

import com.tgr.fwk.dto.AbstractSearchResponse;

public class LoadAxesResponse extends AbstractSearchResponse<List<String>> {

	private static final long serialVersionUID = -7907005520960776722L;

	public LoadAxesResponse() {
		
	}

	public LoadAxesResponse(List<String> results) {
		setModels(results);
	}
}
