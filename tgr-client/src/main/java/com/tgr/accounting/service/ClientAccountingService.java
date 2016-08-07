package com.tgr.accounting.service;

import java.util.List;

import org.jboss.resteasy.client.ClientRequest;

import com.tgr.accounting.service.api.criteria.AxesCriteria;
import com.tgr.accounting.service.api.dto.EntryRequest;
import com.tgr.accounting.service.api.dto.EntryResponse;
import com.tgr.accounting.service.api.dto.LoadAxesRequest;
import com.tgr.accounting.service.api.dto.LoadAxesResponse;
import com.tgr.accounting.service.api.model.EntryModel;
import com.tgr.accounting.service.api.service.AccountingService;

public class ClientAccountingService extends AbstractService {

	private static ClientAccountingService instance;
	
	private ClientAccountingService() {
		super(AccountingService.class);
	}
	
	public static ClientAccountingService getInstance() {
		if (instance == null) {
			instance = new ClientAccountingService();
		}
		return instance;
	}
	
	public EntryModel addEntry(EntryModel model) throws Exception {
		ClientRequest request = buildRequest("create", new EntryRequest(model));
		EntryResponse serviceResponse = getResponse(request, EntryResponse.class);
		return serviceResponse.getModel();
	}
	
	public List<String> loadAxes(AxesCriteria criteria) throws Exception {
		ClientRequest request = buildRequest("loadAxes", new LoadAxesRequest(criteria));
		LoadAxesResponse serviceResponse = getResponse(request, LoadAxesResponse.class);
		return serviceResponse.getModels();
	}
}
