package com.tgr.accounting.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.dozer.DozerBeanMapper;

import com.tgr.accounting.entity.EntryEntity;
import com.tgr.accounting.repository.EntryRepository;
import com.tgr.accounting.service.api.dto.AnnualBalanceRequest;
import com.tgr.accounting.service.api.dto.AnnualBalanceResponse;
import com.tgr.accounting.service.api.dto.DeleteEntryRequest;
import com.tgr.accounting.service.api.dto.DeleteEntryResponse;
import com.tgr.accounting.service.api.dto.EntryRequest;
import com.tgr.accounting.service.api.dto.EntryResponse;
import com.tgr.accounting.service.api.dto.LoadEntryRequest;
import com.tgr.accounting.service.api.model.EntryModel;
import com.tgr.accounting.service.api.service.AccountingService;
import com.tgr.fwk.exception.NoDataFoundException;
import com.tgr.fwk.exception.ServiceException;
import com.tgr.fwk.service.AbstractService;

@Transactional
public class AccountingServiceImpl extends AbstractService implements AccountingService {

	@Inject
	private EntryRepository entryRepository;
	private DozerBeanMapper mapper;
	
	public AccountingServiceImpl() {
		List<String> mappingFiles = new ArrayList<String>();
		mappingFiles.add("mapping/EntryModel-dozer-mapping.xml");
		mapper = new DozerBeanMapper(mappingFiles);
	}
	
	public EntryResponse load(LoadEntryRequest request) {
		
		EntryEntity entryEntity;
		try {
			entryEntity = entryRepository.loadById(request.getId());
		} catch (NoDataFoundException e) {
			throw new ServiceException(e);
		}
		
		EntryModel entry = mapper.map(entryEntity, EntryModel.class);
		
		return new EntryResponse(entry);
	}

	public EntryResponse create(EntryRequest request) {
		
		if (request.getModel() == null) {
			throw new ServiceException();
		}
		
		validateValues(request.getModel());
		
		request.getModel().setId(null);
		
		EntryEntity entity = mapper.map(request.getModel(), EntryEntity.class);
		
//		entity = entryRepository.insert(entity);
		
		EntryModel result = mapper.map(entity, EntryModel.class);
		
		return new EntryResponse(result);
	}

	public EntryResponse modify(EntryRequest request) {
		
		validateValues(request.getModel());
		
		if (request.getModel().getId() == null) {
			throw new ServiceException();
		}
		
		EntryEntity entity = mapper.map(request.getModel(), EntryEntity.class);

//		entity = entryRepository.update(entity);

		EntryModel result = mapper.map(entity, EntryModel.class);
		
		return new EntryResponse(result);
	}
	
	private void validateValues(EntryModel model) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<EntryModel>> cvs = validator.validate(model);
		
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
		
		if (Double.compare(model.getAmount(), 0D) == 0) {
			throw new ServiceException();
		}
	}
	
	public DeleteEntryResponse delete(DeleteEntryRequest request) {
		
		if (request.getId() == null) {
			return DeleteEntryResponse.FALSE;
		}
		
		EntryEntity entryEntity;
		try {
			entryEntity = entryRepository.loadById(request.getId());
		} catch (NoDataFoundException e) {
			throw new ServiceException(e);
		}
		
		entryRepository.delete(entryEntity);
		
		return DeleteEntryResponse.TRUE;
	}

	public AnnualBalanceResponse readBalance(AnnualBalanceRequest request) {
		// TODO Auto-generated method stub
		return new AnnualBalanceResponse();
	}

}
