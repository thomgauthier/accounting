package com.tgr.accounting.service.api.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.tgr.accounting.service.api.dto.AnnualBalanceRequest;
import com.tgr.accounting.service.api.dto.AnnualBalanceResponse;
import com.tgr.accounting.service.api.dto.DeleteEntryRequest;
import com.tgr.accounting.service.api.dto.DeleteEntryResponse;
import com.tgr.accounting.service.api.dto.EntryRequest;
import com.tgr.accounting.service.api.dto.EntryResponse;
import com.tgr.accounting.service.api.dto.LoadEntryRequest;
import com.tgr.accounting.service.api.dto.SearchEntryRequest;
import com.tgr.accounting.service.api.dto.SearchEntryResponse;
import com.tgr.fwk.service.Service;


@Path("/AccountingService")
public interface AccountingService extends Service {

	@POST
	@Path("/load")
	EntryResponse load(LoadEntryRequest request);
	
	@POST
	@Path("/create")
	EntryResponse create(EntryRequest request);
	
	@POST
	@Path("/modify")
	EntryResponse modify(EntryRequest request);
	
	@POST
	@Path("/delete")
	DeleteEntryResponse delete(DeleteEntryRequest request);
	
	@POST
	@Path("/searchEntry")
	SearchEntryResponse searchEntry(SearchEntryRequest request);
	
	@POST
	@Path("/readBalance")
	AnnualBalanceResponse readBalance(AnnualBalanceRequest request);
}
