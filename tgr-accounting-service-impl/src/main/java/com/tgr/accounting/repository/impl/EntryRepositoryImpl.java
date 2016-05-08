package com.tgr.accounting.repository.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.querydsl.jpa.impl.JPAQuery;
import com.tgr.accounting.entity.EntryEntity;
import com.tgr.accounting.entity.QEntryEntity;
import com.tgr.accounting.repository.AbstractAccountingRepository;
import com.tgr.accounting.repository.EntryRepository;
import com.tgr.accounting.service.api.criteria.EntryCriteria;
import com.tgr.accounting.service.api.type.AmountType;

public class EntryRepositoryImpl extends AbstractAccountingRepository<EntryEntity, QEntryEntity> implements EntryRepository {
	
	@Override
	public void commonTrigger(EntryEntity entity) {
		super.commonTrigger(entity);
		
		entity.setInput(entity.getInput() == null ? 0D : entity.getInput());
		entity.setOutput(entity.getOutput() == null ? 0D : entity.getOutput());
	}

	public List<EntryEntity> search(EntryCriteria criteria) {
		QEntryEntity qEntity = QEntryEntity.entryEntity;
		JPAQuery<EntryEntity> query = buildQuery(qEntity);
		
		// Amount and types
		if (AmountType.INPUT.equals(criteria.getAmountType())) {
			if (criteria.getAmountMin() != null) {
				query.where(qEntity.input.goe(criteria.getAmountMin()));
			}
			if (criteria.getAmountMax() != null) {
				query.where(qEntity.input.loe(criteria.getAmountMax()));
			}
			
		} else if (AmountType.OUTPUT.equals(criteria.getAmountType())) {
			if (criteria.getAmountMin() != null) {
				query.where(qEntity.output.goe(criteria.getAmountMin()));
			}
			if (criteria.getAmountMax() != null) {
				query.where(qEntity.output.loe(criteria.getAmountMax()));
			}
		}
		// Payments
		if (CollectionUtils.isNotEmpty(criteria.getPaymentTypes())) {
			query.where(qEntity.paymentType.in(criteria.getPaymentTypes()));
		}
		// Day
		if (criteria.getStartDay() != null) {
			query.where(qEntity.day.goe(criteria.getStartDay()));
		}
		if (criteria.getEndDay() != null) {
			query.where(qEntity.day.loe(criteria.getEndDay()));
		}
		// Month
		if (criteria.getStartMonth() != null) {
			query.where(qEntity.month.goe(criteria.getStartMonth()));
		}
		if (criteria.getEndMonth() != null) {
			query.where(qEntity.month.loe(criteria.getEndMonth()));
		}
		// Year
		if (criteria.getStartYear() != null) {
			query.where(qEntity.year.goe(criteria.getStartYear()));
		}
		if (criteria.getEndYear() != null) {
			query.where(qEntity.year.loe(criteria.getEndYear()));
		}
		// Axis
		if (StringUtils.isNotEmpty(criteria.getAxis1Like())) {
			query.where(qEntity.axis1.like(criteria.getAxis1Like() + "%"));
		}
		if (StringUtils.isNotEmpty(criteria.getAxis2Like())) {
			query.where(qEntity.axis2.like(criteria.getAxis2Like() + "%"));
		}
		if (StringUtils.isNotEmpty(criteria.getAxis3Like())) {
			query.where(qEntity.axis3.like(criteria.getAxis3Like() + "%"));
		}
		
		return query.fetch();
	}
}
