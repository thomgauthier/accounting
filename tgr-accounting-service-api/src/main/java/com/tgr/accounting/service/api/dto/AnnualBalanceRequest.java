package com.tgr.accounting.service.api.dto;

import com.tgr.fwk.dto.IdRequest;

public class AnnualBalanceRequest extends IdRequest<Integer> {

	private static final long serialVersionUID = 2185658130699817030L;

	public AnnualBalanceRequest() {

	}

	public AnnualBalanceRequest(Integer year) {
		setId(year);
	}
}
