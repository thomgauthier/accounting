package com.tgr.fwk.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tgr.fwk.header.HeaderVariables;

public abstract class AbstractAuthenticationInterceptor {

	protected static Logger logger = LogManager.getLogger(AbstractAuthenticationInterceptor.class);
	
	protected void filter(ContainerRequestContext context) throws IOException {
		
		String login = context.getHeaderString(HeaderVariables.LOGIN.get());
		String pwd = context.getHeaderString(HeaderVariables.PASSWORD.get());
		
		logger.debug("Checking auth for user [" + login + "]");
		
		if (!authorized(login, pwd)) {
			Status status = Response.Status.UNAUTHORIZED;
			String reason = status.getReasonPhrase();
			logger.debug("Aborting request for user [" + login + "] with reason : " + reason);
			context.abortWith(Response.status(status).entity(reason).build());
			return;
		}
	}
	
	protected abstract boolean authorized(String login, String pwd);

}
