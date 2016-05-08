package com.tgr.accounting.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.tgr.fwk.repository.AbstractRepository;

public class AbstractAccountingRepository<ENTITY> extends AbstractRepository<ENTITY> {

	@PersistenceContext(unitName="AccountingPersistenceUnit")
	private EntityManager em;
	
	protected EntityManager getEntityManager() {
		return em;
	}
}
