package com.tgr.accounting.repository;

import java.util.List;

import com.tgr.accounting.entity.AnnualBalanceEntity;
import com.tgr.fwk.repository.Repository;

public interface AnnualBalanceRepository extends Repository<AnnualBalanceEntity> {

	List<AnnualBalanceEntity> findByYear(Integer year);
}
