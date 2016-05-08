package com.tgr.accounting.repository.impl;

import com.tgr.accounting.entity.EntryEntity;
import com.tgr.accounting.entity.QEntryEntity;
import com.tgr.accounting.repository.AbstractAccountingRepository;
import com.tgr.accounting.repository.EntryRepository;

public class EntryRepositoryImpl extends AbstractAccountingRepository<EntryEntity, QEntryEntity> implements EntryRepository {
	
	@Override
	public void commonTrigger(EntryEntity entity) {
		super.commonTrigger(entity);
		
		entity.setInput(entity.getInput() == null ? 0D : entity.getInput());
		entity.setOutput(entity.getOutput() == null ? 0D : entity.getOutput());
	}
}
