package com.tgr.accounting.service;

import com.tgr.accounting.service.api.model.EntryModel;
import com.tgr.fwk.service.Service;

public interface InternalValidationService extends Service {

	void validateWithException(EntryModel model);
}
