package com.tgr.accounting.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;

import com.tgr.accounting.entity.AnnualBalanceEntity;
import com.tgr.accounting.entity.EntryEntity;
import com.tgr.accounting.repository.AnnualBalanceRepository;
import com.tgr.accounting.repository.EntryRepository;
import com.tgr.accounting.service.InternalExcelImportService;
import com.tgr.accounting.service.InternalValidationService;
import com.tgr.accounting.service.api.dto.AnnualBalanceRequest;
import com.tgr.accounting.service.api.dto.AnnualBalanceResponse;
import com.tgr.accounting.service.api.dto.DeleteEntryRequest;
import com.tgr.accounting.service.api.dto.DeleteEntryResponse;
import com.tgr.accounting.service.api.dto.EntryRequest;
import com.tgr.accounting.service.api.dto.EntryResponse;
import com.tgr.accounting.service.api.dto.ImportEntriesRequest;
import com.tgr.accounting.service.api.dto.LoadAxesRequest;
import com.tgr.accounting.service.api.dto.LoadAxesResponse;
import com.tgr.accounting.service.api.dto.LoadEntryRequest;
import com.tgr.accounting.service.api.dto.SearchEntryRequest;
import com.tgr.accounting.service.api.dto.SearchEntryResponse;
import com.tgr.accounting.service.api.model.AnnualBalanceModel;
import com.tgr.accounting.service.api.model.EntryModel;
import com.tgr.accounting.service.api.model.ImportPropertiesModel;
import com.tgr.accounting.service.api.service.AccountingService;
import com.tgr.fwk.dto.BooleanResponse;
import com.tgr.fwk.exception.NoDataFoundException;
import com.tgr.fwk.exception.ServiceException;
import com.tgr.fwk.service.AbstractService;

@Transactional
public class AccountingServiceImpl extends AbstractService implements AccountingService {

	@Inject
	private InternalValidationService validationService;
	@Inject
	private InternalExcelImportService excelImportService;
	@Inject
	private EntryRepository entryRepository;
	@Inject
	private AnnualBalanceRepository annualBalanceRepository;
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
		EntryModel result = create(request.getModel());
		
		return new EntryResponse(result);
	}
	
	private EntryModel create(EntryModel model) {
		model.setId(null);
		
		EntryEntity entity = mapper.map(model, EntryEntity.class);
		
		entity = entryRepository.insert(entity);
		
		EntryModel result = mapper.map(entity, EntryModel.class);
		
		return result;
	}

	public EntryResponse modify(EntryRequest request) {
		
		validateValues(request.getModel());
		
		if (request.getModel().getId() == null) {
			throw new ServiceException();
		}
		
		EntryEntity entity = mapper.map(request.getModel(), EntryEntity.class);

		entity = entryRepository.update(entity);

		EntryModel result = mapper.map(entity, EntryModel.class);
		
		return new EntryResponse(result);
	}
	
	private void validateValues(EntryModel model) {

		validationService.validateWithException(model);
		
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
	
	public SearchEntryResponse searchEntry(SearchEntryRequest request) {
		
		if (request == null) throw new ServiceException();
		if (request.getCriteria() == null) throw new ServiceException();
		
		List<EntryEntity> entries = entryRepository.search(request.getCriteria());
		
		List<EntryModel> models = new ArrayList<EntryModel>();
		for (EntryEntity entry : entries) {
			models.add(mapper.map(entry, EntryModel.class));
		}
		
		return new SearchEntryResponse(models);
	}

	public AnnualBalanceResponse readBalance(AnnualBalanceRequest request) {
		
		if (request == null) throw new ServiceException();
		if (request.getId() == null) throw new ServiceException();
		
		List<AnnualBalanceEntity> balances = annualBalanceRepository.findByYear(request.getId());
		
		if (balances.isEmpty()) {
			throw new ServiceException();
		}
		if (balances.size() > 1) {
			throw new ServiceException();
		}
		
		AnnualBalanceModel model = mapper.map(balances.get(0), AnnualBalanceModel.class);
		
		return new AnnualBalanceResponse(model);
	}

	public BooleanResponse importEntries(ImportEntriesRequest request) {
		
		ImportPropertiesModel model = request.getModel();
		
//		JobOperator jo = BatchRuntime.getJobOperator();
//		jo.start("importEntriesJob", new Properties());
		
		File file = new File(model.getAbsoluteFilePath());
		if (!file.exists()) {
			return new BooleanResponse(Boolean.FALSE);
		}
		if (file.isDirectory()) {
			return new BooleanResponse(Boolean.FALSE);
		}
		
		List<EntryModel> models = excelImportService.importFile(file, model, EntryModel.class);
		
		for (EntryModel entryModel : models) {
			create(entryModel);
		}
		
		return new BooleanResponse(Boolean.TRUE);
	}

	public LoadAxesResponse loadAxes(LoadAxesRequest request) {
		
		List<String> results = entryRepository.loadAxes(request.getCriteria());
		
		return new LoadAxesResponse(results);
	}
	
}
