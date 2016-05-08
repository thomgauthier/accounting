package com.tgr.accounting.repository.impl;

import java.util.List;

import com.querydsl.jpa.impl.JPAQuery;
import com.tgr.accounting.entity.AnnualBalanceEntity;
import com.tgr.accounting.entity.QAnnualBalanceEntity;
import com.tgr.accounting.repository.AbstractAccountingRepository;
import com.tgr.accounting.repository.AnnualBalanceRepository;


public class AnnualBalanceRepositoryImpl  extends AbstractAccountingRepository<AnnualBalanceEntity, QAnnualBalanceEntity> implements AnnualBalanceRepository {

	public List<AnnualBalanceEntity> findByYear(Integer year) {
		
		QAnnualBalanceEntity qEntity = QAnnualBalanceEntity.annualBalanceEntity;
		JPAQuery<AnnualBalanceEntity> query = buildQuery(qEntity);
		query.where(qEntity.year.eq(year));
		
		return query.fetch();
	}

}
