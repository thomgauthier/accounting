package com.tgr.accounting.service.api.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.tgr.accounting.service.api.dto.ValidationRequest;
import com.tgr.accounting.service.api.dto.ValidationResponse;
import com.tgr.fwk.service.Service;

@Path("/ValidationService")
public interface ValidationService extends Service {

	@POST
	@Path("/validate")
	ValidationResponse validate(ValidationRequest request);
}
