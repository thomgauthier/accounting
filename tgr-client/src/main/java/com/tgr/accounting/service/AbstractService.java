package com.tgr.accounting.service;

import java.lang.reflect.Method;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.StringUtils;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

import com.tgr.accounting.resources.ResourcesHandler;

public abstract class AbstractService {

	private Class<?> service;
	
	public AbstractService(Class<?> service) {
		this.service = service;
	}
	
	protected <T> T getResponse(ClientRequest request, Class<T> responseType) throws Exception {
		ClientResponse<T> clientResponse = null;
		clientResponse = request.post(responseType);
		if (clientResponse.getResponseStatus().equals(Status.OK)) {
			return clientResponse.getEntity();
		} else {
			String response = clientResponse.getEntity(String.class);
			throw new Exception(response);
		}
	}
	
	protected ClientRequest buildRequest(String methodName, Object request) {
		ClientRequest clientRequest = null;
		try {
			clientRequest = new ClientRequest(getPath(service.getDeclaredMethod(methodName, request.getClass())));
			clientRequest.body(MediaType.APPLICATION_JSON, request);
			clientRequest.accept(MediaType.APPLICATION_JSON_TYPE);
			clientRequest.header("login", ResourcesHandler.getInstance().get("application.auth.login"));
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return clientRequest;
	}
	
	private String getPath(Method method) {
		String host = StringUtils.defaultIfBlank(ResourcesHandler.getInstance().get("application.remote.host"), "localhost");
		String port = StringUtils.defaultIfBlank(ResourcesHandler.getInstance().get("application.remote.port"), "80");
		String app = StringUtils.defaultIfBlank(ResourcesHandler.getInstance().get("application.remote.app"), "/");
		
		StringBuilder sb = new StringBuilder("http://");
		sb.append(host);
		sb.append(":" + port);
		sb.append(app);
		
		Path servicePath = service.getAnnotation(Path.class);
		if (servicePath != null) {
			sb.append(servicePath.value());
		}
		Path methodPath = method.getAnnotation(Path.class);
		if (methodPath != null) {
			sb.append(methodPath.value());
		}
		return sb.toString();
	}
}
