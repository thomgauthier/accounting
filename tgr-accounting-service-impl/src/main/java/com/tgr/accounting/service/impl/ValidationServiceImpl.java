package com.tgr.accounting.service.impl;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.tgr.accounting.service.InternalValidationService;
import com.tgr.accounting.service.api.dto.ValidationRequest;
import com.tgr.accounting.service.api.dto.ValidationResponse;
import com.tgr.accounting.service.api.model.EntryModel;
import com.tgr.accounting.service.api.model.ValidationModel;
import com.tgr.accounting.service.api.service.ValidationService;
import com.tgr.fwk.exception.ServiceException;
import com.tgr.fwk.service.AbstractService;

public class ValidationServiceImpl extends AbstractService implements ValidationService, InternalValidationService {

	public void validateWithException(EntryModel model) {
		Set<ConstraintViolation<EntryModel>> cvs = validate(model);
		
		if (!cvs.isEmpty()) {
			StringBuilder sb = new StringBuilder("Impossible to validate data on object [" + model.getClass().getSimpleName() + "] : \n");
			for (ConstraintViolation<EntryModel> cv : cvs) {
				sb.append(cv.getRootBeanClass().getSimpleName());
				sb.append(".");
				sb.append(cv.getPropertyPath());
				sb.append(" ");
				sb.append(cv.getMessage());
				sb.append("\n");
			}
			throw new ServiceException(sb.toString());
		}
	}
	
	private Set<ConstraintViolation<EntryModel>> validate(EntryModel model) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		return validator.validate(model);
	}

	public ValidationResponse validate(ValidationRequest request) {
		
		ValidationModel model = new ValidationModel();
		ValidationResponse response = new ValidationResponse(model);
		
		if (request == null) {
			return response;
		}
		
		if (request.getModel() == null) {
			return response;
		}
		
		Set<ConstraintViolation<EntryModel>> cvs = validate(request.getModel());
		for (ConstraintViolation<EntryModel> cv : cvs) {
			StringBuilder sb = new StringBuilder()
				.append(cv.getRootBeanClass().getSimpleName())
				.append(".")
				.append(cv.getPropertyPath())
				.append(" ")
				.append(cv.getMessage());
			model.getErrors().add(sb.toString());
		}
		
		return response;
	}

}
