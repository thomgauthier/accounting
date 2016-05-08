package com.tgr.accounting.client;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

import com.tgr.accounting.service.api.dto.AnnualBalanceRequest;
import com.tgr.accounting.service.api.dto.AnnualBalanceResponse;
import com.tgr.accounting.service.api.dto.EntryRequest;
import com.tgr.accounting.service.api.dto.EntryResponse;
import com.tgr.accounting.service.api.dto.LoadEntryRequest;
import com.tgr.accounting.service.api.model.EntryModel;
import com.tgr.accounting.service.api.type.AmountType;
import com.tgr.accounting.service.api.type.PaymentType;
import com.tgr.fwk.exception.ServiceException;

public class AccountingClient {

	private static final String URI_LOAD = "http://localhost:8080/tgr-accounting-webapp/AccountingService/load";
	private static final String URI_CREATE = "http://localhost:8080/tgr-accounting-webapp/AccountingService/create";
	private static final String URI_BALANCE = "http://localhost:8080/tgr-accounting-webapp/AccountingService/readBalance";
	
	public static void main(String[] args) {
//		create();
//		load();
		searchBalance();
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
