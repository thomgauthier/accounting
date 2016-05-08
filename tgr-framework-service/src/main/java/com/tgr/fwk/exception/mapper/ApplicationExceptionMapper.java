package com.tgr.fwk.exception.mapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.tgr.fwk.exception.ServiceException;

@Provider
public class ApplicationExceptionMapper extends AbstractExceptionMapper implements ExceptionMapper<ServiceException>  {

	public Response toResponse(ServiceException exception) {
		StringBuilder sb = new StringBuilder(exception.getMessage());
		sb.append("\n");
		for (StackTraceElement elt : exception.getStackTrace()) {
			sb.append("\t").append(elt.toString()).append("\n");
		}
		return Response.status(Status.BAD_REQUEST).type(MediaType.APPLICATION_JSON).entity(sb.toString()).build();
	}

}
