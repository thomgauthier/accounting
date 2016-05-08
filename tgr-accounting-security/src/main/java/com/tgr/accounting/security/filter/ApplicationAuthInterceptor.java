package com.tgr.accounting.security.filter;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

import com.tgr.fwk.filter.AbstractAuthenticationInterceptor;

@Provider
@PreMatching
@Priority(value = com.tgr.fwk.priority.Priority.SECURITY)
public class ApplicationAuthInterceptor extends AbstractAuthenticationInterceptor implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext arg0) throws IOException {
		super.filter(arg0);
	}
	
	@Override
	protected boolean authorized(String login, String pwd) {
		return true;
	}

}
