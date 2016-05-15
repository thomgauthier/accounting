package com.tgr.accounting.client;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

import com.tgr.accounting.service.api.criteria.EntryCriteria;
import com.tgr.accounting.service.api.dto.AnnualBalanceRequest;
import com.tgr.accounting.service.api.dto.AnnualBalanceResponse;
import com.tgr.accounting.service.api.dto.EntryRequest;
import com.tgr.accounting.service.api.dto.EntryResponse;
import com.tgr.accounting.service.api.dto.ImportEntriesRequest;
import com.tgr.accounting.service.api.dto.LoadEntryRequest;
import com.tgr.accounting.service.api.dto.SearchEntryRequest;
import com.tgr.accounting.service.api.dto.SearchEntryResponse;
import com.tgr.accounting.service.api.model.EntryModel;
import com.tgr.accounting.service.api.model.ImportPropertiesModel;
import com.tgr.accounting.service.api.type.AmountType;
import com.tgr.accounting.service.api.type.PaymentType;
import com.tgr.fwk.dto.BooleanResponse;
import com.tgr.fwk.exception.ServiceException;

public class AccountingClient {

	private static final String URI_LOAD = "http://localhost:8080/tgr-accounting-webapp/AccountingService/load";
	private static final String URI_CREATE = "http://localhost:8080/tgr-accounting-webapp/AccountingService/create";
	private static final String URI_BALANCE = "http://localhost:8080/tgr-accounting-webapp/AccountingService/readBalance";
	private static final String URI_SEARCH_ENTRY = "http://localhost:8080/tgr-accounting-webapp/AccountingService/searchEntry";
	private static final String URI_IMPORT_ENTRY = "http://localhost:8080/tgr-accounting-webapp/AccountingService/importEntries";
	
	public static void main(String[] args) {

		callBatch();
//		create();
//		load();
//		searchBalance();
//		searchEntry();
	}
	
	private static void callBatch() {
		ClientRequest request = new ClientRequest(URI_IMPORT_ENTRY);
		ImportPropertiesModel importPropertiesModel = new ImportPropertiesModel();
		importPropertiesModel.setAbsoluteFilePath("P:\\Dossier perso\\Compta\\Compta-Compte-Courant.xlsx");
		importPropertiesModel.setSheet("2016");
		importPropertiesModel.setFromRow(83);
		importPropertiesModel.setToRow(169);
		request.body(MediaType.APPLICATION_JSON, new ImportEntriesRequest(importPropertiesModel));
		request.accept(MediaType.APPLICATION_JSON_TYPE);
		request.header("login", "toto");
		
		BooleanResponse entryResponse;
		ClientResponse<BooleanResponse> clientResponse;
		try {
			clientResponse = request.post(BooleanResponse.class);
			if (clientResponse.getResponseStatus().equals(Status.OK)) {
				entryResponse = clientResponse.getEntity();
				System.out.println("Result = " + entryResponse.getResult());
			} else {
				String reason = clientResponse.getEntity(String.class);
				throw new ServiceException(reason);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void searchEntry() {
		ClientRequest request = new ClientRequest(URI_SEARCH_ENTRY);

		EntryCriteria criteria = new EntryCriteria();
		criteria.setStartYear(2015);
		
		request.body(MediaType.APPLICATION_JSON, new SearchEntryRequest(criteria));
		request.accept(MediaType.APPLICATION_JSON_TYPE);
		request.header("login", "toto");
		
		SearchEntryResponse entryResponse = null;
		ClientResponse<SearchEntryResponse> clientResponse;
		try {
			clientResponse = request.post(SearchEntryResponse.class);
			if (clientResponse.getResponseStatus().equals(Status.OK)) {
				entryResponse = clientResponse.getEntity();
				for (EntryModel model : entryResponse.getModels()) {
					System.out.println("Result = " + model.toString());
				}
			} else {
				String reason = clientResponse.getEntity(String.class);
				throw new ServiceException(reason);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void searchBalance() {
		ClientRequest request = new ClientRequest(URI_BALANCE);

		request.body(MediaType.APPLICATION_JSON, new AnnualBalanceRequest(2014));
		request.accept(MediaType.APPLICATION_JSON_TYPE);
		request.header("login", "toto");
		
		AnnualBalanceResponse response = null;
		ClientResponse<AnnualBalanceResponse> clientResponse;
		try {
			clientResponse = request.post(AnnualBalanceResponse.class);
			if (clientResponse.getResponseStatus().equals(Status.OK)) {
				response = clientResponse.getEntity();
				System.out.println("Result = " + response.getModel().toString());
			} else {
				String reason = clientResponse.getEntity(String.class);
				throw new ServiceException(reason);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void load() {
		ClientRequest request = new ClientRequest(URI_LOAD);
		
		request.body(MediaType.APPLICATION_JSON, new LoadEntryRequest(1423L));
//		request.body(MediaType.APPLICATION_JSON, new LoadEntryRequest(1000000L));
		request.accept(MediaType.APPLICATION_JSON_TYPE);
		request.header("login", "toto");
		
		EntryResponse serviceResponse = null;

		ClientResponse<EntryResponse> clientResponse;
		try {
			clientResponse = request.post(EntryResponse.class);
			if (clientResponse.getResponseStatus().equals(Status.OK)) {
				serviceResponse = clientResponse.getEntity();
				System.out.println("Result = " + serviceResponse.getModel().toString());
			} else {
				String response = clientResponse.getEntity(String.class);
				throw new ServiceException(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void create() {
		ClientRequest request = new ClientRequest(URI_CREATE);
		
		EntryModel newModel = new EntryModel();
		newModel.setAmount(1D);
		newModel.setAmountType(AmountType.INPUT);
		newModel.setAxis1("test");
		newModel.setAxis2("1");
		newModel.setDay(7);
		newModel.setMonth(5);
		newModel.setYear(2016);
		newModel.setPaymentType(PaymentType.CB);
		
		request.body(MediaType.APPLICATION_JSON, new EntryRequest(newModel));
		request.accept(MediaType.APPLICATION_JSON_TYPE);
		request.header("login", "toto");
		
		EntryResponse serviceResponse = null;

		ClientResponse<EntryResponse> clientResponse;
		try {
			clientResponse = request.post(EntryResponse.class);
			if (clientResponse.getResponseStatus().equals(Status.OK)) {
				serviceResponse = clientResponse.getEntity();
				System.out.println("Result = " + serviceResponse.getModel().toString());
			} else {
				String response = clientResponse.getEntity(String.class);
				throw new ServiceException(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
