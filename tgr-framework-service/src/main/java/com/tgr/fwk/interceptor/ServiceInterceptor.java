package com.tgr.fwk.interceptor;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Interceptor
@Transactional
@Priority(value = com.tgr.fwk.priority.Priority.SERVICE)
public class ServiceInterceptor {

	private static Logger logger = LogManager.getLogger(ServiceInterceptor.class);
	
	@AroundInvoke
	public Object intercept(InvocationContext context) throws Exception {
		
		logger.debug("Start logging method " + context.getMethod().getName() + " of service " + context.getMethod().getDeclaringClass().getSimpleName());
		
		Object serviceContext = context.proceed();
		
		logger.debug("End logging method " + context.getMethod().getName() + " of service " + context.getMethod().getDeclaringClass().getSimpleName());
		
		return serviceContext;
	}
	
}
