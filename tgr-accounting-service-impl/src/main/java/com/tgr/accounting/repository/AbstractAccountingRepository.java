package com.tgr.accounting.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.tgr.fwk.repository.AbstractRepository;

public class AbstractAccountingRepository<ENTITY, METAMODEL> extends AbstractRepository<ENTITY, METAMODEL> {

	@PersistenceContext(unitName="AccountingPersistenceUnit")
	private EntityManager em;
	
	protected EntityManager getEntityManager() {
		return em;
	}
}
