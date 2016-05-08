package com.tgr.fwk.filter;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Provider
@PreMatching
@Priority(value = com.tgr.fwk.priority.Priority.MEDIATYPE)
public class ContentTypeInterceptor extends AbstractFilter implements ContainerRequestFilter {

private static Logger logger = LogManager.getLogger(ContentTypeInterceptor.class);
	
	public void filter(ContainerRequestContext context) throws IOException {
		
		logger.debug("Checking content type for request");
		
		if (!MediaType.APPLICATION_JSON_TYPE.equals(context.getMediaType())) {
			abort(context);
			return;
		}
		
		if (context.getAcceptableMediaTypes() == null) {
			abort(context);
			return;
		}
		
		if (context.getAcceptableMediaTypes().size() == 0) {
			abort(context);
			return;
		}
		
		if (!context.getAcceptableMediaTypes().contains(MediaType.APPLICATION_JSON_TYPE)) {
			abort(context);
			return;
		}
	}
	
	private void abort(ContainerRequestContext context) {
		Status status = Response.Status.UNSUPPORTED_MEDIA_TYPE;
		String reason = Response.Status.UNSUPPORTED_MEDIA_TYPE.getReasonPhrase();
		logger.debug("Aborting request with reason : " + reason);
		context.abortWith(Response.status(status).entity(reason).build());
	}
}
