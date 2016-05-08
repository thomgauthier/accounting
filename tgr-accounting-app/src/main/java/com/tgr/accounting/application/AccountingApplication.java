package com.tgr.accounting.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.reflections.Reflections;

import com.tgr.fwk.exception.mapper.AbstractExceptionMapper;
import com.tgr.fwk.filter.AbstractAuthenticationInterceptor;
import com.tgr.fwk.filter.AbstractFilter;
import com.tgr.fwk.service.AbstractService;

@ApplicationPath("/")
public class AccountingApplication extends Application {

	private static final String ACCOUNTING_SERVICES_PATH = "com.tgr.accounting.service.impl";
	private static final String ACCOUNTING_FILTERS_PATH = "com.tgr.accounting.security.filter";
	private static final String FWK_FILTERS_PATH = "com.tgr.fwk.filter";
	private static final String ACCOUNTING_EXCEPTIONMAPPER_PATH = "com.tgr.fwk.exception.mapper";
	
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classesList = new HashSet<Class<?>>();

		// Services
		Reflections reflections = new Reflections(ACCOUNTING_SERVICES_PATH);
		Set<Class<? extends AbstractService>> services = reflections.getSubTypesOf(AbstractService.class);
		classesList.addAll(services);
		
		// Filters
		reflections = new Reflections(FWK_FILTERS_PATH);
		Set<Class<? extends AbstractFilter>> filters = reflections.getSubTypesOf(AbstractFilter.class);
		classesList.addAll(filters);
		reflections = new Reflections(ACCOUNTING_FILTERS_PATH);
		Set<Class<? extends AbstractAuthenticationInterceptor>> filters2 = reflections.getSubTypesOf(AbstractAuthenticationInterceptor.class);
		classesList.addAll(filters2);
		
		// ExceptionMappers
		reflections = new Reflections(ACCOUNTING_EXCEPTIONMAPPER_PATH);
		Set<Class<? extends AbstractExceptionMapper>> mappers = reflections.getSubTypesOf(AbstractExceptionMapper.class);
		classesList.addAll(mappers);
		
		return classesList;
	}
}
