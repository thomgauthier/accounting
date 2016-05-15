package com.tgr.accounting.service.api.dto;

import com.tgr.accounting.service.api.model.ImportPropertiesModel;
import com.tgr.fwk.dto.AbstractRequest;

public class ImportEntriesRequest extends AbstractRequest<ImportPropertiesModel> {

	private static final long serialVersionUID = 8752664558330754697L;

	public ImportEntriesRequest() {

	}

	public ImportEntriesRequest(ImportPropertiesModel model) {
		setModel(model);
	}
}
