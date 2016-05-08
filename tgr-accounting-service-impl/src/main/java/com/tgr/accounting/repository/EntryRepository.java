package com.tgr.accounting.repository;

import java.util.List;

import com.tgr.accounting.entity.EntryEntity;
import com.tgr.accounting.service.api.criteria.EntryCriteria;
import com.tgr.fwk.repository.Repository;

public interface EntryRepository extends Repository<EntryEntity> {

	List<EntryEntity> search(EntryCriteria criteria);
}
