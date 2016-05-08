package com.tgr.accounting.service.api.dto;

import com.tgr.accounting.service.api.model.AnnualBalanceModel;
import com.tgr.fwk.dto.AbstractResponse;

public class AnnualBalanceResponse extends AbstractResponse<AnnualBalanceModel> {

	private static final long serialVersionUID = 5264143150558734765L;

	public AnnualBalanceResponse() {

	}

	public AnnualBalanceResponse(AnnualBalanceModel model) {
		setModel(model);
	}
}
