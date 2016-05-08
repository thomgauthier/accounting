package com.tgr.accounting.service.api.dto;

import com.tgr.fwk.dto.BooleanResponse;

public class DeleteEntryResponse extends BooleanResponse {

	private static final long serialVersionUID = -4104747681383280231L;

	public static DeleteEntryResponse FALSE = new DeleteEntryResponse(Boolean.FALSE);
	public static DeleteEntryResponse TRUE = new DeleteEntryResponse(Boolean.TRUE);
	
	public DeleteEntryResponse() {
		
	}
	
	public DeleteEntryResponse(Boolean result) {
		setResult(result);
	}
}
